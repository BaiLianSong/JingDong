package com.example.acer.jd.com.bwie.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.jd.R;
import com.example.acer.jd.SouSuoActivity;
import com.example.acer.jd.com.bwie.model.bean.HomeBean;
import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.presenter.HomePresenter;
import com.example.acer.jd.com.bwie.view.MyImageLoader;
import com.example.acer.jd.com.bwie.view.adapter.HomeHengAdapter;
import com.example.acer.jd.com.bwie.view.adapter.HomeMiaoShaAdapter;
import com.example.acer.jd.com.bwie.view.adapter.HomeTuiJianAdapter;
import com.example.acer.jd.com.bwie.view.custom.NoticeView;
import com.example.acer.jd.com.bwie.view.iview.IHomeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;
import com.youth.banner.Banner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by acer on 2018/10/12.
 */

public class HomeFragment extends Fragment implements IHomeView {
    private static final int REQUEST_CODE = 0x1000;
    private HomePresenter homePresenter;
    private Banner banner;
    private View view;
    private List<String> list = new ArrayList<>();
    private RecyclerView home_recyclerView,miaosha_recyclerview,tuijian_recyclerView;
    private HomeHengAdapter homeHengAdapter;
    private HomeTuiJianAdapter homeTuiJianAdapter;
    private NoticeView noticeView;
    private ImageView saoyisao;
    private int mtext = 1000000000;
    final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    private TextView textView;
    private HomeMiaoShaAdapter homeMiaoShaAdapter;
    private EditText sousuo_edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.home_fragment_layout, container, false);
        ZXingLibrary.initDisplayOpinion(getActivity());
        initView();
        initData();
        homePresenter = new HomePresenter();
        homePresenter.attachView(this);
        homePresenter.showImage();
        homePresenter.showJiu();
        homePresenter.showHome();

        CountDownTimer countDownTimer = new CountDownTimer(mtext, 1000) {
            @Override
            public void onTick(long l) {
                String format = simpleDateFormat.format(new Date(l));
                textView.setText("京东秒杀:" + format);
            }

            @Override
            public void onFinish() {
            }
        }.start();
        return view;
    }

    private void initData() {
        homeTuiJianAdapter = new HomeTuiJianAdapter(getActivity());
        homeMiaoShaAdapter = new HomeMiaoShaAdapter(getActivity());
        saoyisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        sousuo_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SouSuoActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        sousuo_edit = view.findViewById(R.id.sousuo_edit);
        tuijian_recyclerView = view.findViewById(R.id.tuijian_recyclerView);
        miaosha_recyclerview = view.findViewById(R.id.miaosha_recyclerview);
        textView = view.findViewById(R.id.miaoshao_text);
        saoyisao = view.findViewById(R.id.saoyisao);
        noticeView = view.findViewById(R.id.noticeView);
        banner = view.findViewById(R.id.banner);
        homeHengAdapter = new HomeHengAdapter(getActivity());
        home_recyclerView = view.findViewById(R.id.heng_recyclerView);
        tuijian_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2,LinearLayoutManager.VERTICAL,false));
        home_recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.HORIZONTAL, false));
        miaosha_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        List<String> notices = new ArrayList<>();
        notices.add("大促销下单拆福袋，亿万新年红包随便拿");
        notices.add("家电五折团，抢十亿无门槛现金红包");
        notices.add("星球大战剃须刀首发送200元代金券");
        noticeView.addNotice(notices);
        noticeView.startFlipping();
    }

    @Override
    public void onSuccess(ImageBean imageBean) {
        List<ImageBean.DataBean> data = imageBean.getData();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getIcon().replace("https","http"));
        }
        banner.setImageLoader(new MyImageLoader());
        banner.setImages(list);
        banner.start();
        //Log.i("aaaa", "onSuccess: " + data.get(0).getTitle());
    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    public void onJiuSuccess(JiuBean jiuBean) {
        String name = jiuBean.getData().get(0).getName();
        homeHengAdapter.setList(jiuBean.getData());
        home_recyclerView.setAdapter(homeHengAdapter);
       // Log.i("aaa", name + "-----------------");
    }

    @Override
    public void onHomeSuccess(HomeBean homeBean) {
        List<HomeBean.DataBean.MiaoshaBean.ListBean> list = homeBean.getData().getMiaosha().getList();
        homeMiaoShaAdapter.setList(list);
        miaosha_recyclerview.setAdapter(homeMiaoShaAdapter);

        List<HomeBean.DataBean.TuijianBean.ListBeanX> tuijian = homeBean.getData().getTuijian().getList();
        homeTuiJianAdapter.setList(tuijian);
        tuijian_recyclerView.setAdapter(homeTuiJianAdapter);

        //Log.i("aaa", tuijian.get(0).getTitle() + "-----------------");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homePresenter.dettachView();
    }
    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }*/

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        homePresenter.dettachView();
    }
}
