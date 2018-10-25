package com.example.acer.jd.com.bwie.presenter;

import com.example.acer.jd.com.bwie.model.bean.LoginBean;
import com.example.acer.jd.com.bwie.model.bean.RegBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.ILoginOrRegisterView;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.ResourceObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by acer on 2018/10/18.
 */

public class RegisterOrLoginPresenter extends BasePresenter<ILoginOrRegisterView> {
    public void register(String mobile,String password){
        final Observable<RegBean> reg = HttpUtil.getHttpUtilInstence().apiClent.getReg(mobile, password);

        reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResourceObserver<RegBean>() {
                    @Override
                    public void onNext(RegBean regBean) {
                        String msg = regBean.getMsg();
                        getView().onRegisterSuccess(msg);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onFailure("失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void log(String username, String password) {
        final Observable<LoginBean> reg = HttpUtil.getHttpUtilInstence().apiClent.getLogin(username, password);

        reg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ResourceObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean regBean) {
                        getView().onLoginSuceess(regBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onFailure("失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
