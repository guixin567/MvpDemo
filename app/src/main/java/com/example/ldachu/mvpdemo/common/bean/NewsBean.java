package com.example.ldachu.mvpdemo.common.bean;

import com.example.ldachu.mvpdemo.common.net.BaseResponse;

import java.util.List;


/**
 * @author zxKueen 2018/3/10 13:16
 *         email 4994766@qq.com
 *         新闻
 */
public class NewsBean extends BaseResponse<List<NewsBean>> {

    /**
     * uniquekey : e493743419ffc38a00da026678fc03a6
     * title : 中国发展网中国产业发展研究院与重庆猪八戒网有限公司签约战略合作框架协议
     * date : 2018-03-10 12:07
     * category : 头条
     * author_name : 中国发展网
     * url : http://mini.eastday.com/mobile/180310120735332.html
     * thumbnail_pic_s : http://03.imgmini.eastday.com/mobile/20180310/20180310120735_a456f0c4cb2e3c1fc319a386e4586070_5_mwpm_03200403.jpg
     * thumbnail_pic_s02 : http://03.imgmini.eastday.com/mobile/20180310/20180310120735_a456f0c4cb2e3c1fc319a386e4586070_1_mwpm_03200403.jpg
     * thumbnail_pic_s03 : http://03.imgmini.eastday.com/mobile/20180310/20180310120735_a456f0c4cb2e3c1fc319a386e4586070_4_mwpm_03200403.jpg
     */

    public String uniquekey;
    public String title;
    public String date;
    public String category;
    public String author_name;
    public String url;
    public String thumbnail_pic_s;
    public String thumbnail_pic_s02;
    public String thumbnail_pic_s03;

}
