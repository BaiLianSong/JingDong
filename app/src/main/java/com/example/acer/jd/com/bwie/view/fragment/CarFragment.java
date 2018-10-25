package com.example.acer.jd.com.bwie.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.acer.jd.R;
import com.example.acer.jd.com.bwie.model.bean.CarBean;
import com.example.acer.jd.com.bwie.presenter.CarPresenter;
import com.example.acer.jd.com.bwie.view.adapter.CarRecycler01Adapter;
import com.example.acer.jd.com.bwie.view.iview.ICarView;

import java.util.List;


/**
 * Created by acer on 2018/10/12.
 */

public class CarFragment extends Fragment implements ICarView{
    private RecyclerView carRecycler01;
    private View view;
    private CarRecycler01Adapter carRecycler01Adapter;
    private CarPresenter carPresenter;
    private CheckBox allCheck;
    private List<CarBean.DataBean> data;
    private boolean isAllChecked;
    private double zongjia;
    private TextView num_text,price_text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(getActivity()).inflate(R.layout.car_fragment_layout,container,false);
        initView();
        initData();
        carPresenter.carShow(75);
        return view;
    }

    private void initData() {
        carRecycler01.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        carRecycler01Adapter = new CarRecycler01Adapter(getActivity());
        carPresenter = new CarPresenter();
        carPresenter.attachView(this);

        allCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断全选按钮是否选中
                isAllChecked = allCheck.isChecked();
                if (isAllChecked){
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setOutCheck(true);
                        for (int j = 0; j < data.get(i).getList().size(); j++) {
                            data.get(i).getList().get(j).setInCheck(true);
                            zongjia += data.get(i).getList().get(j).getPrice();
                            price_text.setText("总价"+zongjia);
                        }
                    }
                }else {
                    for (int i = 0; i < data.size(); i++) {
                        data.get(i).setOutCheck(false);
                        for (int j = 0; j < data.get(i).getList().size(); j++) {
                            data.get(i).getList().get(j).setInCheck(false);
                            zongjia = 0;
                            price_text.setText("总价"+zongjia);
                        }
                    }
                }
                num();
                carRecycler01Adapter.notifyDataSetChanged();

            }
        });
    }

    private void initView() {
        carRecycler01 = view.findViewById(R.id.car_recycler01);
        allCheck = view.findViewById(R.id.allCheck);
        num_text = view.findViewById(R.id.shop_num);
        price_text = view.findViewById(R.id.shop_price);
    }

    @Override
    public void onCarSuccess(CarBean carBean) {
        data = carBean.getData();
        carRecycler01Adapter.setData(data);
        carRecycler01.setAdapter(carRecycler01Adapter);
    }

    @Override
    public void onCarFailure(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        carPresenter.dettachView();
    }

    private void num(){
        double price = 0;
        for (int i = 0; i < carRecycler01Adapter.getData().size(); i++) {
            for (int j = 0; j < carRecycler01Adapter.getData().get(i).getList().size(); j++) {
                if (carRecycler01Adapter.getData().get(j).isOutCheck()){
                    CarBean.DataBean.ListBean listBean = carRecycler01Adapter.getData().get(i).getList().get(j);
                    price += listBean.getBargainPrice() * listBean.getNum();
                }
            }
            num_text.setText("总价"+price);
        }
    }
}