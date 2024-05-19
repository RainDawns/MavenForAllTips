package com.raindown.tests.douyu;

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
    private static String ownCookie = "dy_did=34875f100c40f4740d2794e200021601; dy_teen_mode=%7B%22uid%22%3A%22326458694%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; m_did=bcebf4c0558bbb4970454615000617p1; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1702801109,1702815183,1703259440,1704892908; dy_auth=ab3e8G7ibRHZXWQueC1Z29bw5u%2BWn7LYr1AX9FDlY8lR6WemsL624Y4bNzXgFNOhYXEE0%2B%2FMwJoOOblE7Klm7rI6dUPFMjHjhSye91XUnLga7oBagU4AnhU; wan_auth37wan=993f1112814eXN7DxUK2SMRzfKG8EcUwNHevvkc7m6I696GrnzxTkkSEzvmtz%2BA7bJL5bBZ2Ttv4ee6GekoYiSt%2FuOuzgUavdKeJcJgZ9nXq%2FrMU3aE; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1704892917; msgUnread=waiting; post-csrfToken=a4844af4e59159bba8af10; msg_auth=a15746c2f3053d9a91bb5561aab0668af87714d7; msg_uid=EqAvP96gZ8w5";
    private static String otherCookie = "dy_did=1f33d4c92b92baf21b36f12200081601; acf_did=1f33d4c92b92baf21b36f12200081601; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1689898718,1689952170; PHPSESSID=vtsj2v2kij4cf98llqaec7k5a7; acf_auth=d07adECaC2FMmAF08ZgeFXul1bFaMvLDJDtDVF7Ce24VbGR85zoBgLC2So401sk8BfscwQz83xg6HpDwk8%2Ft4Nb4xW0Aj0If%2BhAbP1PLbK9fpQCaNDJ0ZS4; dy_auth=9e61YYGoqwGBey017I2hYpJyMDMjt8aTzIWhOkqDG3KdmbazHKZbIx%2BRcW2qSfIMBtu4KDzkkcn1FHPJ3kTqL9zRnTKH3Kf6%2B6BdeklHj%2B2UDB6SrfrL%2Bls; wan_auth37wan=a5aa82f916e8Tm0BFD1DzF9s7Bi7OVZBDPgIO4Ra%2F%2BoLM1e2jLZ%2BmdcWAtxdkM8dPAhXwzcsHMNBbj3lxcfN%2Fp2a6u5nfnGDsvaCgF8JnQ29LossOK8; acf_uid=325806624; acf_username=325806624; acf_nickname=%E7%9D%A1%E9%A3%8E%E6%9C%88; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F201910%2Fdfffd4e51b85480ca6b71d2e7811df18_; acf_ct=0; acf_ltkid=91805593; acf_biz=1; acf_stk=025fc69b0041fe35; dy_teen_mode=%7B%22uid%22%3A%22325806624%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_ccn=02ebcc8713fa8ae3b9228fe3065ac0ee; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1689952534; cvl_csrf_token=a93f134c4bc343cdbefcfb3ba6c61e39";
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
            message.setUid("UID_0HiFkPHl97gMxfJmqgMzKiCwcIt3");
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
