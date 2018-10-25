package com.example.acer.jd.com.bwie.presenter;

import com.example.acer.jd.com.bwie.model.bean.SouSuoBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.ISouSuo;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.SafeObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by acer on 2018/10/19.
 */

public class SouSuoPresenter extends BasePresenter<ISouSuo> {
    public void souSuo(String keywords, int page){
        final Observable<SouSuoBean> souSuo = HttpUtil.getHttpUtilInstence().apiClent.getSouSuo(keywords, page);

        souSuo.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SouSuoBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SouSuoBean souSuoBean) {
                        getView().onSuccess(souSuoBean);
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
