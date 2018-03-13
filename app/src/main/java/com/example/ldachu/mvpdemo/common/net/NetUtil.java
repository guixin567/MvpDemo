package com.example.ldachu.mvpdemo.common.net;

import android.text.TextUtils;

import com.example.ldachu.mvpdemo.common.net.api.NewsApi;
import com.example.ldachu.mvpdemo.common.util.NetConfig;


/**
 * @author zxKueen 2018/3/10 13:52
 *         email 4994766@qq.com
 *         创建不同类型的api
 *         可以根据不同的url
 *         也可以根据不同的分组
 */
public class NetUtil {
    //私有静态化成员变量
    private static volatile NetUtil instance;

    //私有化构造方法
    private NetUtil() {
    }

    //获取对象
    public static NetUtil getInstance() {
        if (instance == null) {
            synchronized (NetUtil.class) {
                if (instance == null) {
                    instance = new NetUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 新闻相关的网络请求
     * @return
     */
    public NewsApi getNewsApi(){
        return create(NewsApi.class);
    }

    /**
     * 创建api
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T create(Class<T> clazz){
        return create(clazz,"");
    }

    public <T> T create(Class<T> clazz,String url){
        if(TextUtils.isEmpty(url)){
            return RetrofitUtil.getInstance(NetConfig.BASE_URL).getRetrofit().create(clazz);
        }else{
            return RetrofitUtil.getInstance(url).getRetrofit().create(clazz);
        }

    }

}
