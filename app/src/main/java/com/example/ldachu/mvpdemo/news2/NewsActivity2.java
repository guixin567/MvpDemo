package com.example.ldachu.mvpdemo.news2;


import android.support.v7.widget.LinearLayoutManager;

import com.example.ldachu.mvpdemo.R;
import com.example.ldachu.mvpdemo.common.adapter.NewsAdapter;
import com.example.ldachu.mvpdemo.common.base.BaseBindActivity;
import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.databinding.ActivityMainBinding;

import java.util.List;


public class NewsActivity2 extends BaseBindActivity<ActivityMainBinding> {

    private NewsAdapter          mNewsAdapter;
    private NewsPresenter2 mNewsPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        mNewsPresenter = new NewsPresenter2();
        //P层和V层的绑定
        mNewsPresenter.attach(this);
        mNewsPresenter.getNewsList("top");

    }

    @Override
    protected void initAdapter() {
        super.initAdapter();
        mBinding.rvNews.setLayoutManager(new LinearLayoutManager(this));;
        mNewsAdapter = new NewsAdapter(R.layout.recycle_item_news, null);
        mBinding.rvNews.setAdapter(mNewsAdapter);

    }

    public void showNewsList(List<NewsBean> data) {
        mNewsAdapter.setNewData(data);
        mNewsAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除绑定
        mNewsPresenter.detach();
    }
}
