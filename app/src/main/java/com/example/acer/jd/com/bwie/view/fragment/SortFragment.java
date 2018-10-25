package com.example.acer.jd.com.bwie.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.model.bean.SortBean;
import com.example.acer.jd.com.bwie.presenter.SortPresenter;
import com.example.acer.jd.com.bwie.view.MyImageLoader;
import com.example.acer.jd.com.bwie.view.adapter.SortYouAdapter;
import com.example.acer.jd.com.bwie.view.adapter.SortYouAdapter02;
import com.example.acer.jd.com.bwie.view.adapter.SortZuoAdapter;
import com.example.acer.jd.com.bwie.view.iview.ISortView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by acer on 2018/10/12.
 */

public class SortFragment extends Fragment implements ISortView{
    private SortPresenter sortPresenter;
    private RecyclerView sort_zuo_recyclerView,sort_you_recyclerView;
    private View view;
    private SortZuoAdapter sortZuoAdapter;
    private SortYouAdapter sortYouAdapter;
    private Banner sortBanner;
    private List<String> imageList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.sort_fragment_layout,container,false);
        initView();
        initData();
        sortPresenter.attachView(this);
        sortPresenter.show();
        sortPresenter.showImage();
        sortPresenter.sortRight(1);
        return view;
    }

    private void initData() {
        sortPresenter = new SortPresenter();
        sortPresenter.attachView(this);

        sortZuoAdapter = new SortZuoAdapter(getActivity());
        sortYouAdapter = new SortYouAdapter(getActivity());

        sort_zuo_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        sort_you_recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
    }

    private void initView() {
        sort_zuo_recyclerView = view.findViewById(R.id.sort_zuo_recyclerView);
        sort_you_recyclerView = view.findViewById(R.id.sort_you_recyclerView);
        sortBanner = view.findViewById(R.id.sort_banner);
    }

    @Override
    public void onSuccess(final JiuBean jiuBean) {
        List<JiuBean.DataBean> data = jiuBean.getData();
        sortZuoAdapter.setData(data);
        sort_zuo_recyclerView.setAdapter(sortZuoAdapter);
        sortZuoAdapter.setOnItemClickListener(new SortZuoAdapter.OnItemClickLisenter() {
            @Override
            public void onItemClick(int postion) {
                sortPresenter.sortRight(jiuBean.getData().get(postion).getCid());
            }
        });
    }

    @Override
    public void onFailure(String msg) {

    }

    @Override
    public void onSortSuccess(final SortBean sortBean) {
        List<SortBean.DataBean> data = sortBean.getData();
        sortYouAdapter.setData(data);
        sort_you_recyclerView.setAdapter(sortYouAdapter);
    }

    @Override
    public void onBannerSuccess(ImageBean imageBean) {
        List<ImageBean.DataBean> data = imageBean.getData();
        for (int i = 0; i < data.size(); i++) {
            imageList.add(data.get(i).getIcon());
        }
        sortBanner.setImageLoader(new MyImageLoader());
        sortBanner.setImages(imageList);
        sortBanner.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sortPresenter.dettachView();
    }
}
