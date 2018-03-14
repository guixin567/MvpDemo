package com.example.ldachu.mvpdemo.news7.base.mvp;

import com.example.ldachu.mvpdemo.news7.base.BasePresenter7;
import com.example.ldachu.mvpdemo.news7.base.BaseView7;

/**
 * @author zxKueen on 2018-03-14 14:25
 *         Email: 4994766@qq.com
 *         对BaseBindActivity和BaseBindFragment中的共有方法
 *         和Presenter和View绑定逻辑进行向上抽取
 */

public class Mvp <V extends BaseView7,P extends BasePresenter7<V>>{
    private BaseMvp<V, P> mMvp;
    public P mPresenter;

    public Mvp(BaseMvp<V,P> mvp) {
        mMvp = mvp;
        initMvp();
    }

    /**
     *  初始化MVP，主要是Presenter对View的绑定
     */
    private void initMvp() {
        mPresenter = mMvp.createPresenter();
        if(mPresenter == null){
            throw new NullPointerException("MVP Presenter is null");
        }

        if(mMvp.createView() == null){
            throw new NullPointerException("MVP View is null");
        }
        mPresenter.attach(mMvp.createView());
    }

    public void onDestroy(){
        if(mPresenter!=null){
            mPresenter.detach();
        }
    }
}
