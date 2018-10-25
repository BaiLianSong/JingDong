package com.example.acer.jd.com.bwie.presenter;

import com.example.acer.jd.com.bwie.model.bean.XiangQingBean;
import com.example.acer.jd.com.bwie.model.net.HttpUtil;
import com.example.acer.jd.com.bwie.view.iview.IXiangQingView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by acer on 2018/10/20.
 */

public class XiangQingPresenter extends BasePresenter<IXiangQingView>{
    public void xiangQingShow(int pid){
        Observable<XiangQingBean> xiangQing = HttpUtil.getHttpUtilInstence().apiClent.getXiangQing(pid);

        xiangQing.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XiangQingBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(XiangQingBean xiangQingBean) {
                        getView().onSuccess(xiangQingBean);
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
