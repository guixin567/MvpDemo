package com.example.ldachu.mvpdemo.news1;

import com.example.ldachu.mvpdemo.bean.NewsBean;
import com.example.ldachu.mvpdemo.net.BaseObserver;
import com.example.ldachu.mvpdemo.net.NetUtil;
import com.example.ldachu.mvpdemo.net.api.NewsProviders;

import java.io.File;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;

/**
 * @author zxKueen on 2018-03-13 15:08
 *         Email: 4994766@qq.com
 */

public class NewsPresenter {
    private NewsActivity mNewsActivity;
    private NewsProviders mProviders;

    public NewsPresenter(NewsActivity newsActivity) {
        mNewsActivity = newsActivity;
        File cacheDir = mNewsActivity.getApplication().getCacheDir();
        mProviders = new RxCache.Builder()
                .persistence(cacheDir,new GsonSpeaker())
                .using(NewsProviders.class);
    }

    public void getNewsList(String type) {
         mProviders.getNewsList(NetUtil.getInstance().getNewsApi().getNewsList(type))
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new BaseObserver<List<NewsBean>>(mNewsActivity) {
                     @Override
                     protected void onSuccess(List<NewsBean> data) {
                        mNewsActivity.showNewsList(data);
                     }
                 });
    }
}
