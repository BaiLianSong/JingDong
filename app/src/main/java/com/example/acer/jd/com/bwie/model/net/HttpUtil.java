package com.example.acer.jd.com.bwie.model.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by acer on 2018/10/12.
 */

public class HttpUtil {
    public final Api apiClent; private HttpUtil(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.GET_IMAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient) .build();
        apiClent = retrofit.create(Api.class);
    }

    public static class GetHttpUtilInstence{
        private static HttpUtil httpUtil = new HttpUtil();
    }

    public static HttpUtil getHttpUtilInstence(){
        return GetHttpUtilInstence.httpUtil;
    }

}
