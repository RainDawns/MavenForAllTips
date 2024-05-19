package com.raindown.tests.douyu.zhudouyu;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.raindown.tests.hotdog.OkHttpUtils;
import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
import com.zjiecode.wxpusher.client.bean.Result;
import okhttp3.Headers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/14 23:05
 * @version: 1.0
 */
public class RequestTaskDouYu implements Runnable {
    private static String url = "https://www.douyu.com/japi/carnival/nc/web/roomTask/getPrize";
    private static String ownCookie = "dy_did=c5457f4a2a667c1f71ee5f1d00021601; dy_did=c5457f4a2a667c1f71ee5f1d00021601; acf_did=c5457f4a2a667c1f71ee5f1d00021601; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1702634066,1702639983; PHPSESSID=sl1gv83g8vg18hnpvbbrolq026; acf_auth=9ee0rQ28iUaMdae3tPlr%2FzJD5S3XtLkFmd5L1QDr1TyhsjmOc4VtCL6lm2l96%2BQ3Ug2BUO66XYBNTKKAwB7mIqx4zier1ZAPsOQs8rc3uLZbqJ%2F2GLjk2BI; dy_auth=22d3Bh5SUXNfLmTzb4QnvbrcUFp0TirgSkdgriA68XXaJqUxFf27w1d2MURpc2fWFYUPmr4eZ%2Blr2%2BSB901SQwwTJzE6nxvNBChsqcW3GcvIeXy0kFi5JC8; wan_auth37wan=5c1da37ef2a2dn1td8f2HqcDRzWJN90GFRYFM5gaGyt4E80TcIdTnEJXjSvu8qQNBGd54WU6UCrx9l5yT0niV42PAcX6dUL8oRuu3mmWF6ntSxtDD3E; acf_uid=357175696; acf_username=357175696; acf_nickname=%E7%94%A8%E6%88%B761933781; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F202103%2F2d09e20c9ccf4a1384915f1e03008083_; acf_ct=0; acf_ltkid=12302098; acf_biz=1; acf_stk=b5177944b26c54ca; dy_teen_mode=%7B%22uid%22%3A%22357175696%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1702640165; acf_ccn=89b7aec5a0e78c3da7164e0e1a60f4c1; cvl_csrf_token=9e4a692b18c4443e98e61284eadf3ba9";
    private static String otherCookie = "dy_did=1f33d4c92b92baf21b36f12200081601; acf_did=1f33d4c92b92baf21b36f12200081601; dy_teen_mode=%7B%22uid%22%3A%22325806624%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; PHPSESSID=229m24s7hup47618boddn3mfo5; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1702639769; acf_auth=6537vzibHmFU6s2o%2BIK%2BD9z0XkQQHexKdiOL01Bau6Dr6K3GGbnECVu6ECdG%2FTxhpKPbqBZFjRqCXi1jVctYH87yqIqE94hKy8aWW5lelEhT%2Bw4%2FJxhLmAU; dy_auth=0ba6mTwUFyksnVrltUgtEAY1bIbORQrDg3Av7NY0lD9X%2FT1ExKIxKSHIOYNsVoKKezbs9aqQNGBke5ZLcUWP4NRpVajodjiKZxHe2wLJvejOnZX44a9W5zQ; wan_auth37wan=62bd75684c97lgeMKFXM0sJzy70jK1upAGUrkrCU5ta714qRqQmVpELrAjfEtsJDqNPRQY0q0J4ygSfq9A9FZppRu9IJl0PN5XBr4F%2Brl0KkBQzYTCk; acf_uid=325806624; acf_username=325806624; acf_nickname=%E7%9D%A1%E9%A3%8E%E6%9C%88; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F201910%2Fdfffd4e51b85480ca6b71d2e7811df18_; acf_ct=0; acf_ltkid=91805593; acf_biz=1; acf_stk=4061c7911ba9fa11; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1702639772; dy_did=1f33d4c92b92baf21b36f12200081601; cvl_csrf_token=ca889a99d2b74a24892b4eccdf08ac36";
    public volatile boolean flag = false;

    @Override
    public void run() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", ownCookie);
        HashMap<String, Object> body = new HashMap<>();
        body.put("taskId", "247629");

        JSONObject result = null;
        try {
            result = OkHttpUtils.sendPostFormRequest(url, body, Headers.of(headers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(DateUtil.formatDateTime(new Date()) + "-----" + Thread.currentThread().getName() + result);
        if (result.getString("error").equals("0")) {
            Message message = new Message();
            message.setAppToken("AT_jAu2SfNk49Zi1BNCl7t2FHotNu8QBaGe");
            message.setContentType(Message.CONTENT_TYPE_MD);
            message.setContent("已拿下！！！ [斗鱼链接](https://www.douyu.com/topic/ymzxgc?rid=10075970&dyshid=13755d46-34875f100c40f4740d2794e200021601)");
            message.setUid("UID_8TmS0m9VKx8biQcP27u766xMbicR");
            message.setUrl("https://www.douyu.com/topic/ymzxgc?rid=10075970&dyshid=13755d46-34875f100c40f4740d2794e200021601"); //可选参数
            Result<List<MessageResult>> res = WxPusher.send(message);
            if (!res.isSuccess()) {
                Result<List<MessageResult>> result1 = WxPusher.send(message);
                flag = true;
            }
            flag = true;
        }

    }

}
