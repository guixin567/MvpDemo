package com.example.ldachu.mvpdemo.common.net;

/**
 * @author zxKueen 2018/3/10 13:23
 *         email 4994766@qq.com
 *         统一的网络返回结果
 */
public class BaseResponse <T>{

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[]}
     * error_code:0
     */

    public String reason;
    public ResultBean<T> result;
    public int error_code;

    public static class ResultBean<T> {
        /**
         * stat : 1
         * data : []
         */
        public String stat;
        public T data;
    }

    /**
     * 判断接口是否返回成功
     * @return
     */
    public boolean isSuccess(){
        return error_code==0;
    }
}
