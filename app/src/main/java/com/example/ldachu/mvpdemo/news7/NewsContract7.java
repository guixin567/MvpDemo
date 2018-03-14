package com.example.ldachu.mvpdemo.news7;

import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.news7.base.BasePresenter7;
import com.example.ldachu.mvpdemo.news7.base.BaseView7;

import java.util.List;

/**
 * @author zxKueen 2018/3/14 1:00
 *         email 4994766@qq.com
 */
public abstract class NewsContract7 {
    interface View extends BaseView7 {
        /**
         * 显示接口返回的数据
         * @param data
         */
        void showNewsList(List<NewsBean> data);

    }

    abstract static class Presenter<V extends View> extends BasePresenter7<V> {
        /**
         * 获取网络请求的数据
         * @param type
         */
       abstract void getNewsList(String type);
    }

}
