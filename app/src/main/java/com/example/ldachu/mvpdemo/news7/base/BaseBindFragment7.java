package com.example.ldachu.mvpdemo.news7.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ldachu.mvpdemo.news7.base.mvp.BaseMvp;
import com.example.ldachu.mvpdemo.news7.base.mvp.Mvp;

/**
 * @author zxKueen on 2018-03-14 9:14
 *         Email: 4994766@qq.com
 *         基类的封装和MVP中对attach和detach方法实现
 *         attach中用到的对象不确定的可以在子类实现
 */

public abstract class BaseBindFragment7<D extends ViewDataBinding,V extends BaseView7,P extends BasePresenter7<V>> extends Fragment implements BaseMvp<V,P>{

    protected D mBinding;
    private Mvp<V, P> mMvp;
    protected P mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMvp = new Mvp<>(this);
        mPresenter = mMvp.mPresenter;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
        initAdapter();
    }

    protected void initAdapter() {}
    protected void initData() {}
    protected abstract int getLayoutId();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mMvp.onDestroy();
    }
}
