package com.example.ldachu.mvpdemo.news6;

import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.news6.base.BasePresenter6;
import com.example.ldachu.mvpdemo.news6.base.BaseView6;

import java.util.List;

/**
 * @author zxKueen 2018/3/14 1:00
 *         email 4994766@qq.com
 */
public abstract class NewsContract6 {
    interface View extends BaseView6 {
        /**
         * 显示接口返回的数据
         * @param data
         */
        void showNewsList(List<NewsBean> data);

        int getLayoutId();
    }

    abstract static class Presenter<V extends View> extends BasePresenter6<V> {
        /**
         * 获取网络请求的数据
         * @param type
         */
       abstract void getNewsList(String type);
    }

}
