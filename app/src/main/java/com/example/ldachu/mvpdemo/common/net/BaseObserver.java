package com.example.ldachu.mvpdemo.common.net;

import android.content.Context;
import android.util.Log;

import com.example.ldachu.mvpdemo.common.util.ToastUtil;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author zxKueen 2018/3/10 13:31
 *         email 4994766@qq.com
 *         对返回数据进行二次抽取，并处理错误的逻辑
 */
public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    private static final String TAG = "BaseObserver";
    private Context mContext;

    public BaseObserver(Context context) {
        mContext = context;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(BaseResponse<T> response) {
        if(response.isSuccess()){
            onSuccess(response.result.data);
        }else{
            onFailed(response.reason,response.error_code,response.result.stat);
        }
    }




    @Override
    public void onError(Throwable e) {
        ToastUtil.show(mContext,"网络出小差了");
        Log.e(TAG, e.toString() );
    }

    @Override
    public void onComplete() {

    }


    /**
     * 接口返回成功时方法回调
     * @param data
     */
    protected abstract void onSuccess(T data);

    /**
     * 接口返回错误时
     * @param reason
     * @param error_code
     * @param stat
     */
    protected  void onFailed(String reason, int error_code, String stat){
        //业务逻辑错误的处理
        ToastUtil.show(mContext,reason);
    };
}
