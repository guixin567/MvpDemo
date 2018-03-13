package com.example.ldachu.mvpdemo.news1;


import android.support.v7.widget.LinearLayoutManager;

import com.example.ldachu.mvpdemo.R;
import com.example.ldachu.mvpdemo.adapter.NewsAdapter;
import com.example.ldachu.mvpdemo.base.BaseBindActivity;
import com.example.ldachu.mvpdemo.bean.NewsBean;
import com.example.ldachu.mvpdemo.databinding.ActivityMainBinding;

import java.util.List;


public class NewsActivity extends BaseBindActivity<ActivityMainBinding> {

    private NewsAdapter          mNewsAdapter;
    private NewsPresenter mNewsPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        mNewsPresenter = new NewsPresenter(this);
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
}
