package com.example.acer.jd.com.bwie.model.net;

import com.example.acer.jd.com.bwie.model.bean.CarBean;
import com.example.acer.jd.com.bwie.model.bean.HomeBean;
import com.example.acer.jd.com.bwie.model.bean.ImageBean;
import com.example.acer.jd.com.bwie.model.bean.JiuBean;
import com.example.acer.jd.com.bwie.model.bean.LoginBean;
import com.example.acer.jd.com.bwie.model.bean.RegBean;
import com.example.acer.jd.com.bwie.model.bean.SortBean;
import com.example.acer.jd.com.bwie.model.bean.SouSuoBean;
import com.example.acer.jd.com.bwie.model.bean.XiangQingBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by acer on 2018/10/12.
 */

public interface Api {
    @GET("ad/getAd")
    Observable<ImageBean> getImage();
    @GET("product/getCatagory")
    Observable<JiuBean> getJiu();
    @GET("home/getHome")
    Observable<HomeBean> getHome();
    @GET("product/getProductCatagory")
    Observable<SortBean> getSort(@Query("cid") int cid);
    @GET("user/reg")
    Observable<RegBean> getReg(@Query("mobile") String mobile, @Query("password") String password);
    @GET("user/login")
    Observable<LoginBean> getLogin(@Query("mobile") String mobile, @Query("password") String password);
    @GET("product/searchProducts")
    Observable<SouSuoBean> getSouSuo(@Query("keywords") String keywords, @Query("page") int page);
    @GET("product/getProductDetail")
    Observable<XiangQingBean> getXiangQing(@Query("pid") int pid);
    @GET("product/getCarts")
    Observable<CarBean> getCar(@Query("uid") int uid);
}
