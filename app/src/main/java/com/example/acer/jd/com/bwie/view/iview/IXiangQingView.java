package com.example.acer.jd.com.bwie.view.iview;

import com.example.acer.jd.com.bwie.model.bean.XiangQingBean;

/**
 * Created by acer on 2018/10/20.
 */

public interface IXiangQingView extends IBaseView{
    void onSuccess(XiangQingBean xiangQingBean);
    void onFailure(String msg);
}
