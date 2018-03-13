package com.example.ldachu.mvpdemo.news4.base;

/**
 * @author zxKueen 2018/3/13 23:15
 *         email 4994766@qq.com
 *             对Presenter层进行向上抽取
                通过泛型+抽象子类就不需要写attach和detach方法
 */
public  class BasePresenter4<T extends BaseView4> {
    protected T mView;

    public void attach(T view){
        mView = view;
        initProvider();
    };
    public  void detach(){
        mView = null;
    };

    /**
     * Rxcache缓存初始化
     */
    public void initProvider(){}
}
