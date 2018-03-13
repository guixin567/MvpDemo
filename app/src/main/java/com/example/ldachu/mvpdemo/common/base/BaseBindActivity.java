package com.example.ldachu.mvpdemo.common.base;

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
public abstract class BaseBindActivity<T extends ViewDataBinding> extends AppCompatActivity {
    protected T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =  DataBindingUtil.setContentView(this, getLayoutId());
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
}
