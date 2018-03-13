package com.example.ldachu.mvpdemo.news3.base;

/**
 * @author zxKueen 2018/3/13 23:15
 *         email 4994766@qq.com
 *             对Presenter层进行向上抽取
                通过泛型+抽象子类就不需要写attach和detach方法
 */
public  class BasePresenter<T> {
    protected T mView;

    void attach(T view){
        mView = view;
    };
    protected  void detach(){
        mView = null;
    };
}
