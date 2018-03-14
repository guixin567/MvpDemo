package com.example.ldachu.mvpdemo.common.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author zxKueen 2018/3/10 13:18
 *         email 4994766@qq.com
 *         retrofit的配置
 *         okhttpclient的配置
 */
public class RetrofitUtil {
    //私有静态化成员变量
    private static volatile RetrofitUtil instance;
    private final           OkHttpClient mOkHttpClient;
    private final           Retrofit     mRetrofit;

    //私有化构造方法
    private RetrofitUtil(String url) {
        //配置okhttpclient
        //日志拦截器
        HttpLoggingInterceptor log = new HttpLoggingInterceptor();
        log.setLevel(HttpLoggingInterceptor.Level.BODY);
        mOkHttpClient = new OkHttpClient.Builder()
                //日志拦截器
                .addInterceptor(log)
                .build();

        //Retrofit配置
        mRetrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
    }

    //获取对象
    public static RetrofitUtil getInstance(String url) {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil(url);
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
