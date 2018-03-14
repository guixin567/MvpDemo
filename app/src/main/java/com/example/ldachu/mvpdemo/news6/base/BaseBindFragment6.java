package com.example.ldachu.mvpdemo.news6.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author zxKueen on 2018-03-14 9:14
 *         Email: 4994766@qq.com
 *         基类的封装和MVP中对attach和detach方法实现
 *         attach中用到的对象不确定的可以在子类实现
 */

public abstract class BaseBindFragment6<D extends ViewDataBinding,V extends BaseView6,P extends BasePresenter6<V>> extends Fragment{

    protected D mBinding;
    protected P mPresenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = createPresenter();
        if(mPresenter == null){
            throw  new NullPointerException("MVP Presenter is Null");
        }

        if(createView() == null){
            throw new NullPointerException("MVP View is Null");
        }

        mPresenter.attach(createView());
    }

    /**
     * 在子类创建View层的对象
     * @return
     */
    public abstract V createView();

    /**
     * 在子类创建Presenter
     * @return
     */
    public abstract P createPresenter();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return inflater.inflate(getLayoutId(),container,false);
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
}
