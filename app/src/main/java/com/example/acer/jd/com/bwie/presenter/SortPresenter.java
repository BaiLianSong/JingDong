package com.example.acer.jd.com.bwie.presenter;

import android.util.Log;

import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.model.bean.SortBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.IBaseView;
import com.example.acer.jd.com.bwie.view.iview.ISortView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by acer on 2018/10/17.
 */

public class SortPresenter extends BasePresenter<ISortView>{
    public void show(){
        Observable<JiuBean> jiu = HttpUtil.getHttpUtilInstence().apiClent.getJiu();

        jiu.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JiuBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JiuBean jiuBean) {
                        getView().onSuccess(jiuBean);
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

    public void sortRight(int cid){
        final Observable<SortBean> sort = HttpUtil.getHttpUtilInstence().apiClent.getSort(cid);

        sort.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SortBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SortBean sortBean) {
                        /*String name = sortBean.getData().get(0).getName();
                        Log.i("aaa",name);*/
                        getView().onSortSuccess(sortBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
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
                        getView().onBannerSuccess(imageBean);
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
