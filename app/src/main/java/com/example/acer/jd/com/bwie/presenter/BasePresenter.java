package com.example.acer.jd.com.bwie.presenter;

import android.util.Log;
import android.view.View;

import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.IBaseView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by acer on 2018/10/12.
 */

public class BasePresenter<V extends IBaseView>{
    private V iv;

    public void attachView(V v){
        this.iv = v;
    }

    public void dettachView(){
        this.iv = null;
    }

    public V getView(){
        return iv;
    }
}
