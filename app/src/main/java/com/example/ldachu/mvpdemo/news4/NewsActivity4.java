package com.example.ldachu.mvpdemo.news4;


import android.support.v7.widget.LinearLayoutManager;

import com.example.ldachu.mvpdemo.R;
import com.example.ldachu.mvpdemo.common.adapter.NewsAdapter;
import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.databinding.ActivityMainBinding;
import com.example.ldachu.mvpdemo.news3.base.BaseView3;
import com.example.ldachu.mvpdemo.news4.base.BaseBindActivity4;

import java.util.List;


public class NewsActivity4 extends BaseBindActivity4<ActivityMainBinding,NewsPresenter4> implements BaseView3 {

    private NewsAdapter    mNewsAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected NewsPresenter4 createPresenter() {
        return new NewsPresenter4();
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

    public void showNewsList(List<NewsBean> data) {
        mNewsAdapter.setNewData(data);
        mNewsAdapter.notifyDataSetChanged();
    }
}
