package com.example.acer.jd.com.bwie.view.iview;

import com.example.acer.jd.com.bwie.model.bean.SouSuoBean;

/**
 * Created by acer on 2018/10/19.
 */

public interface ISouSuo extends IBaseView{
    void onSuccess(SouSuoBean souSuoBean);
    void onFailure(String msg);
}
