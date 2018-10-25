package com.example.acer.jd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.acer.jd.com.bwie.model.bean.XiangQingBean;
import com.example.acer.jd.com.bwie.model.eventbusbean.MessageBean;
import com.example.acer.jd.com.bwie.presenter.XiangQingPresenter;
import com.example.acer.jd.com.bwie.view.MyImageLoader;
import com.example.acer.jd.com.bwie.view.iview.IXiangQingView;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class XiangQingActivity extends AppCompatActivity implements IXiangQingView{

    private int pid;
    private XiangQingPresenter xiangQingPresenter;
    private Banner xiangQingBanner;
    private TextView xiangQingTitle,xiangQingPrice;
    private List<String> list;
    private Button jiesuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();
        Intent intent = getIntent();
        pid = intent.getIntExtra("pid", 1);
        initData();
    }

    private void initView() {
        xiangQingBanner = findViewById(R.id.xiangqing_banner);
        xiangQingTitle = findViewById(R.id.xiangqing_title);
        xiangQingPrice = findViewById(R.id.xiangqing_price);
        jiesuan = findViewById(R.id.jiesuan);
    }

    private void initData() {
        list = new ArrayList<>();
        xiangQingPresenter = new XiangQingPresenter();
        xiangQingPresenter.attachView(this);
        xiangQingPresenter.xiangQingShow(pid);

        jiesuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageBean messageBean = new MessageBean();
                messageBean.setFlag("success");
                EventBus.getDefault().post(messageBean);
                Intent intent = new Intent(XiangQingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onSuccess(XiangQingBean xiangQingBean) {
        String[] split = xiangQingBean.getData().getImages().split("\\|");
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        xiangQingBanner.setImageLoader(new MyImageLoader());
        xiangQingBanner.setImages(list);
        xiangQingBanner.start();

        xiangQingTitle.setText(xiangQingBean.getData().getTitle());
        xiangQingPrice.setText(xiangQingBean.getData().getPrice()+"");
    }

    @Override
    public void onFailure(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        xiangQingPresenter.dettachView();
    }
}
