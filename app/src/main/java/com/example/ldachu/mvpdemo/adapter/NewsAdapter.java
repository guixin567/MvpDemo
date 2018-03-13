package com.example.ldachu.mvpdemo.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.ldachu.mvpdemo.R;
import com.example.ldachu.mvpdemo.bean.NewsBean;

import java.util.List;


/**
 * @author zxKueen 2018/3/10 14:33
 *         email 4994766@qq.com
 *         新闻适配器
 */
public class NewsAdapter extends BaseQuickAdapter<NewsBean,BaseViewHolder> {
    public NewsAdapter(int layoutResId, @Nullable List<NewsBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsBean item) {
        helper.setText(R.id.tv_title,item.title);
        helper.setText(R.id.tv_desc,item.url);
        Glide.with(mContext).load(item.thumbnail_pic_s).into((ImageView) helper.getView(R.id.iv_news));
    }
}
