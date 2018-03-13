package com.example.ldachu.mvpdemo.net.api;

import com.example.ldachu.mvpdemo.bean.NewsBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author zxKueen 2018/3/10 14:04
 *         email 4994766@qq.com
 *         新闻相关的api接口
 */
public interface NewsApi {
    @GET("index?key=56ebc185b95881f8ebdcd43b92507bc5&")
    Observable<NewsBean> getNewsList(@Query("type") String type);
}
