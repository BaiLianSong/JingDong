package com.example.acer.jd.com.bwie.presenter;

import com.example.acer.jd.com.bwie.model.bean.HomeBean;
import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.IHomeView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.http.HTTP;

/**
 * Created by acer on 2018/10/12.
 */

public class HomePresenter extends BasePresenter<IHomeView> {
    public void showImage(){
        Observable<ImageBean> image = HttpUtil.getHttpUtilInstence().apiClent.getImage();

        image.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ImageBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ImageBean imageBean) {
                        getView().onSuccess(imageBean);
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

    public void showJiu(){
        Observable<JiuBean> jiu = HttpUtil.getHttpUtilInstence().apiClent.getJiu();

        jiu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JiuBean jiuBean) {
                        getView().onJiuSuccess(jiuBean);
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

    public void showHome(){
        Observable<HomeBean> home = HttpUtil.getHttpUtilInstence().apiClent.getHome();

        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        getView().onHomeSuccess(homeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
