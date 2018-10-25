package com.example.acer.jd.com.bwie.presenter;

import com.example.acer.jd.com.bwie.model.bean.CarBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.ICarView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by acer on 2018/10/20.
 */

public class CarPresenter extends BasePresenter<ICarView> {
    public void carShow(int uid){
        final Observable<CarBean> car = HttpUtil.getHttpUtilInstence().apiClent.getCar(uid);

        car.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CarBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CarBean carBean) {
                        getView().onCarSuccess(carBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().onCarFailure("失败");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
