package com.example.ldachu.mvpdemo.news5.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author zxKueen 2018/3/10 14:28
 *         email 4994766@qq.com
 *         基于Databinding的基类
 */
public abstract class BaseBindActivity5<T extends ViewDataBinding,V extends BaseView5,P extends BasePresenter5<V>> extends AppCompatActivity {
    protected T mBinding;
    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =  DataBindingUtil.setContentView(this, getLayoutId());

        //在子类创建Presenter层的子类对象，在BaseBindingActivity中
        mPresenter = createPresenter();
        if(mPresenter==null){
            throw new NullPointerException("MVP Presenter is Null");
        }
        if(createView() == null){
            throw new NullPointerException("MVP View is Null");
        }
        //P层和V层的绑定
        mPresenter.attach(createView());


        initView();
        initAdapter();
        initData();
        initListener();

    }

    protected abstract V createView();

    /**
     * 创建V层绑定的P层
     * @return
     */
    protected abstract P createPresenter();

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
        mPresenter.detach();
    }
}
