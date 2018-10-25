package com.example.acer.jd.com.bwie.view.iview;

import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.model.bean.SortBean;

/**
 * Created by acer on 2018/10/17.
 */

public interface ISortView extends IBaseView{
    void onSuccess(JiuBean jiuBean);
    void onFailure(String msg);
    void onSortSuccess(SortBean sortBean);
    void onBannerSuccess(ImageBean imageBean);
}
