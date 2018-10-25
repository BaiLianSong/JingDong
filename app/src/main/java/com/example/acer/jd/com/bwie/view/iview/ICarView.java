package com.example.acer.jd.com.bwie.view.iview;

import com.example.acer.jd.com.bwie.model.bean.CarBean;

/**
 * Created by acer on 2018/10/20.
 */

public interface ICarView  extends IBaseView{
    void onCarSuccess(CarBean carBean);
    void onCarFailure(String msg);
}
