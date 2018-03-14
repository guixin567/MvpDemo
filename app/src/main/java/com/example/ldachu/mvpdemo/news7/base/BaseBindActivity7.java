package com.example.ldachu.mvpdemo.news7.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.ldachu.mvpdemo.news7.base.mvp.BaseMvp;
import com.example.ldachu.mvpdemo.news7.base.mvp.Mvp;

/**
 * @author zxKueen 2018/3/10 14:28
 *         email 4994766@qq.com
 *         基于Databinding的基类
 */
public abstract class BaseBindActivity7<T extends ViewDataBinding,V extends BaseView7,P extends BasePresenter7<V>> extends AppCompatActivity implements BaseMvp<V,P> {
    protected T mBinding;
    protected P mPresenter;
    private Mvp<V, P> mMvp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =  DataBindingUtil.setContentView(this, getLayoutId());
        //在构造方法将Presenter与View进行绑定
        mMvp = new Mvp<V, P>(this);

        initView();
        initAdapter();
        initData();
        initListener();

    }

    protected  void initView(){};
    protected  void initData(){};
    protected  void initListener(){};
    protected  void initAdapter(){};

    /**
     * 绑定视图
     * @return
     */
    protected abstract int getLayoutId();


    @Override
    protected void onDestroy() {
        super.onDestroy();
       if(mMvp!=null){
           mMvp.onDestroy();
       }
    }
}
