package com.example.ldachu.mvpdemo.news3;

import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.common.net.BaseObserver;
import com.example.ldachu.mvpdemo.common.net.NetUtil;
import com.example.ldachu.mvpdemo.common.net.api.NewsProviders;

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

public class NewsPresenter3 {
    private NewsActivity3 mNewsActivity;
    private NewsProviders mProviders;

    public NewsPresenter3() {
        File cacheDir = mNewsActivity.getApplication().getCacheDir();

        mProviders = new RxCache.Builder()
                .persistence(cacheDir,new GsonSpeaker())
                .using(NewsProviders.class);
    }

    /**
     * 与View层进行绑定
     * @param view
     */
    public void attachView(NewsActivity3 view){
        mNewsActivity = view;
    }

    /**
     * 当Activity销毁的时候进行Presenter层与View层的解绑
     */
    public void detachView(){
        mNewsActivity = null;
    }

    public void getNewsList(String type) {
         mProviders.getNewsList(NetUtil.getInstance().getNewsApi().getNewsList(type))
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeOn(Schedulers.io())
                 .subscribe(new BaseObserver<List<NewsBean>>(mNewsActivity) {
                     @Override
                     protected void onSuccess(List<NewsBean> data) {
                         if(mNewsActivity!=null){
                             mNewsActivity.showNewsList(data);
                         }
                     }
                 });
    }
}
