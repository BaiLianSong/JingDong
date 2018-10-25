package com.example.acer.jd.com.bwie.view.iview;

import com.example.acer.jd.com.bwie.model.bean.LoginBean;

/**
 * Created by acer on 2018/10/18.
 */

public interface ILoginOrRegisterView extends IBaseView{
    void onLoginSuceess(LoginBean loginBean);
    void onFailure(String msg);
    void onRegisterSuccess(String msg);
}
