package com.example.acer.jd.com.bwie.view.iview;

import com.example.acer.jd.com.bwie.model.bean.HomeBean;
import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;

/**
 * Created by acer on 2018/10/12.
 */

public interface IHomeView extends IBaseView{
    void onSuccess(ImageBean imageBean);
    void onFailure(String msg);
    void onJiuSuccess(JiuBean jiuBean);
    void onHomeSuccess(HomeBean homeBean);
}
