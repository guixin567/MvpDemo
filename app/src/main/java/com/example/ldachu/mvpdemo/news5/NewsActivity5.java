package com.example.ldachu.mvpdemo.news5;


import android.support.v7.widget.LinearLayoutManager;

import com.example.ldachu.mvpdemo.R;
import com.example.ldachu.mvpdemo.common.adapter.NewsAdapter;
import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.databinding.ActivityMainBinding;
import com.example.ldachu.mvpdemo.news5.base.BaseBindActivity5;

import java.util.List;


public class NewsActivity5 extends BaseBindActivity5<ActivityMainBinding,NewsActivity5,NewsPresenter5> implements NewsContract.View{

    private NewsAdapter    mNewsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected NewsActivity5 createView() {
        return this;
    }

    @Override
    protected NewsPresenter5 createPresenter() {
        return new NewsPresenter5();
    }

    @Override
    protected void initData() {
        super.initData();
        mPresenter.getNewsList("top");

    }

    @Override
    protected void initAdapter() {
        super.initAdapter();
        mBinding.rvNews.setLayoutManager(new LinearLayoutManager(this));;
        mNewsAdapter = new NewsAdapter(R.layout.recycle_item_news, null);
        mBinding.rvNews.setAdapter(mNewsAdapter);

    }

    @Override
    public void showNewsList(List<NewsBean> data) {
        mNewsAdapter.setNewData(data);
        mNewsAdapter.notifyDataSetChanged();
    }
}
