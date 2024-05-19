package com.raindown.tests.douyu.wenroudouyu;

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
    private static String ownCookie = "dy_did=8e58881d3ce3965a2a67c42200011601; acf_did=8e58881d3ce3965a2a67c42200011601; dy_teen_mode=%7B%22uid%22%3A%22325806624%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; dy_did=8e58881d3ce3965a2a67c42200011601; acf_auth=76d0GaVSx%2BQWOnNSCRXGAkH9JtXSRE9zeAiZrckNEfNAmkDxap1Orth%2BgOp41qSQmjnfFRX3q8AjtKbK5tNBr%2FMWTObr5wCCgcWO3B%2BQsgKgqtdKCI5wFZo; dy_auth=e7707orp25%2FprHyYUBOUO6rEyhktu%2FrYc4prYjzbGIXy4n5PlOvUA%2B41qKaH7cwNXHvxOEf4967crCYMV87kvKu%2FDtOrSAwYyZt58AGS5kv96k4%2FK2FnPSo; wan_auth37wan=7c10b9fbbc6a5vvStkfexMrkNRntBe85OxrhYBKl8duICzghl%2BYKSAMVj5pHGVb0oPrKYv0FQQB1i2lHdL7srhutZcBv70QNROkQOsfHiJPlumIyk1o; acf_uid=325806624; acf_username=325806624; acf_nickname=%E7%9D%A1%E9%A3%8E%E6%9C%88; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_ct=0; acf_ltkid=91805591; acf_biz=1; acf_stk=4c944b4183996a57; acf_avatar=//apic.douyucdn.cn/upload/avatar_v3/201910/dfffd4e51b85480ca6b71d2e7811df18_; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1702805009,1702805775,1702806340; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1702806340";
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
            message.setUid("UID_1n8ainvqiEiaEOFD5w0vXvRp00cj");
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
