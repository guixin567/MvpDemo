package com.example.ldachu.mvpdemo.news3;

import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.common.net.BaseObserver;
import com.example.ldachu.mvpdemo.common.net.NetUtil;
import com.example.ldachu.mvpdemo.common.net.api.NewsProviders;
import com.example.ldachu.mvpdemo.news3.base.BasePresenter;

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

public class NewsPresenter3 extends BasePresenter<NewsActivity3> {
    private NewsProviders mProviders;

    public NewsPresenter3() {
        File cacheDir = mView.getApplication().getCacheDir();

        mProviders = new RxCache.Builder()
                .persistence(cacheDir,new GsonSpeaker())
                .using(NewsProviders.class);
    }


    public void getNewsList(String type) {
         mProviders.getNewsList(NetUtil.getInstance().getNewsApi().getNewsList(type))
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new BaseObserver<List<NewsBean>>(mView) {
                     @Override
                     protected void onSuccess(List<NewsBean> data) {
                         if(mView!=null){
                             mView.showNewsList(data);
                         }
                     }
                 });
    }

}
