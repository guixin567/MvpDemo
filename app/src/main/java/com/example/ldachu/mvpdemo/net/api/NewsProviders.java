package com.example.ldachu.mvpdemo.net.api;

import com.example.ldachu.mvpdemo.bean.NewsBean;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.rx_cache2.LifeCache;

/**
 * @author zxKueen 2018/3/10 20:12
 *         email 4994766@qq.com
 *         新闻相关接口的缓存
 */
public interface NewsProviders {
    @LifeCache(duration = 1,timeUnit = TimeUnit.MINUTES)
    Observable<NewsBean> getNewsList(Observable<NewsBean> news);
}
