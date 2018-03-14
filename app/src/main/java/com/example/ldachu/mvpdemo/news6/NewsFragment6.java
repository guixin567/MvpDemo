package com.example.ldachu.mvpdemo.news6;

import android.support.v7.widget.LinearLayoutManager;

import com.example.ldachu.mvpdemo.R;
import com.example.ldachu.mvpdemo.common.adapter.NewsAdapter;
import com.example.ldachu.mvpdemo.common.bean.NewsBean;
import com.example.ldachu.mvpdemo.databinding.FragmentNewsBinding;
import com.example.ldachu.mvpdemo.news6.base.BaseBindFragment6;

import java.util.List;

/**
 * @author zxKueen on 2018-03-14 9:50
 *         Email: 4994766@qq.com
 */

public class NewsFragment6 extends BaseBindFragment6<FragmentNewsBinding,NewsFragment6,NewsPresenter6> implements NewsContract6.View{


    private NewsAdapter mNewsAdapter;

    @Override
    public NewsFragment6 createView() {
        return this;
    }

    @Override
    public NewsPresenter6 createPresenter() {
        return new NewsPresenter6();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_news;
    }



    @Override
    protected void initData() {
        super.initData();
        mPresenter.getNewsList("top");

    }

    @Override
    protected void initAdapter() {
        super.initAdapter();
        mBinding.rvNews.setLayoutManager(new LinearLayoutManager(this.getContext()));;
        mNewsAdapter = new NewsAdapter(R.layout.recycle_item_news, null);
        mBinding.rvNews.setAdapter(mNewsAdapter);

    }

    @Override
    public void showNewsList(List<NewsBean> data) {
        mNewsAdapter.setNewData(data);
        mNewsAdapter.notifyDataSetChanged();
    }


}
