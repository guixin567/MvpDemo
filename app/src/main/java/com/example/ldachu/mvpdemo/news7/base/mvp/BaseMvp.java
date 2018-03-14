package com.example.ldachu.mvpdemo.news7.base.mvp;

import com.example.ldachu.mvpdemo.news7.base.BasePresenter7;
import com.example.ldachu.mvpdemo.news7.base.BaseView7;

/**
 * @author zxKueen on 2018-03-14 14:24
 *         Email: 4994766@qq.com
 *         Mvp的基类，主要创建Presenter和创建View
 *         并作为Mvp里面的参数
 */

public interface BaseMvp<V extends BaseView7,P extends BasePresenter7<V>> {
    V createView();
    P createPresenter();
}
