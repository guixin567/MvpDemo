package com.example.ldachu.mvpdemo.news5;

import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.news5.base.BasePresenter5;
import com.example.ldachu.mvpdemo.news5.base.BaseView5;

import java.util.List;

/**
 * @author zxKueen 2018/3/14 1:00
 *         email 4994766@qq.com
 */
public abstract class NewsContract{
    interface View extends BaseView5 {
        /**
         * 显示接口返回的数据
         * @param data
         */
        void showNewsList(List<NewsBean> data);
    }

    abstract static class Presenter<V extends View> extends BasePresenter5<V>{
        /**
         * 获取网络请求的数据
         * @param type
         */
       abstract void getNewsList(String type);
    }

}
