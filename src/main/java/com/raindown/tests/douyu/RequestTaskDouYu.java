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
    private static String url = "https://www.douyu.com/japi/carnival/nc/roomTask/getPrize";
    private static String ownCookie = "dy_did=34875f100c40f4740d2794e200021601; acf_did=34875f100c40f4740d2794e200021601; loginrefer=pt_2c486li72b91; dy_did=34875f100c40f4740d2794e200021601; dy_teen_mode=%7B%22uid%22%3A%22326458694%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_auth=65138EjuPzHkGfc%2BZ1cjAr%2FOE9LPo3kC4RdeenBABT15vh%2BIvsLEHRWsrWxI%2FRbPjsoxLooguvB%2FDNx4xdgniCundW7pSAWxisYFFIQTFdl1tothptTLIUY; dy_auth=86d3oKCe2P7Vic2jHcC71H6ZWILH7NXUJgMLreO3t%2FzrDi4mR0DESllnDjiJla5YjqOFs6kSSlAy%2Bw5kgVrYstsdDGo%2BAxOnCp%2F2cvO2Oryx7%2FLK8wnpXCg; wan_auth37wan=291ff50c9b8ehCHLGazg%2BiGws4xGJJYIHmZUTMmGnmc0s%2Byf7OUA3fWvtjZeT0AZHndBifiy4QQ8c0wrjx%2FhHAlI91K3HVNyAl60%2FbvXj5jKe5bNMD0; acf_uid=326458694; acf_username=326458694; acf_nickname=%E8%99%9A%E5%8C%96%E9%9B%A8%E6%99%93; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_ct=0; acf_ltkid=97185351; acf_biz=1; acf_stk=2638fdb6d50e7a4f; acf_avatar=//apic.douyucdn.cn/upload/avatar_v3/202112/6508e41a6e664d309f028d9215b7993d_; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1689744642,1689844093,1689844189,1689868396; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1689868402; cvl_csrf_token=95a8dacd733d4ed79e05a0878a32a49b";
    private static String otherCookie = "dy_did=1f33d4c92b92baf21b36f12200081601; acf_did=1f33d4c92b92baf21b36f12200081601; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1689898718,1689952170; PHPSESSID=vtsj2v2kij4cf98llqaec7k5a7; acf_auth=d07adECaC2FMmAF08ZgeFXul1bFaMvLDJDtDVF7Ce24VbGR85zoBgLC2So401sk8BfscwQz83xg6HpDwk8%2Ft4Nb4xW0Aj0If%2BhAbP1PLbK9fpQCaNDJ0ZS4; dy_auth=9e61YYGoqwGBey017I2hYpJyMDMjt8aTzIWhOkqDG3KdmbazHKZbIx%2BRcW2qSfIMBtu4KDzkkcn1FHPJ3kTqL9zRnTKH3Kf6%2B6BdeklHj%2B2UDB6SrfrL%2Bls; wan_auth37wan=a5aa82f916e8Tm0BFD1DzF9s7Bi7OVZBDPgIO4Ra%2F%2BoLM1e2jLZ%2BmdcWAtxdkM8dPAhXwzcsHMNBbj3lxcfN%2Fp2a6u5nfnGDsvaCgF8JnQ29LossOK8; acf_uid=325806624; acf_username=325806624; acf_nickname=%E7%9D%A1%E9%A3%8E%E6%9C%88; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F201910%2Fdfffd4e51b85480ca6b71d2e7811df18_; acf_ct=0; acf_ltkid=91805593; acf_biz=1; acf_stk=025fc69b0041fe35; dy_teen_mode=%7B%22uid%22%3A%22325806624%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_ccn=02ebcc8713fa8ae3b9228fe3065ac0ee; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1689952534; cvl_csrf_token=a93f134c4bc343cdbefcfb3ba6c61e39";
    public volatile boolean flag = false;

    @Override
    public void run() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        headers.put("Cookie", otherCookie);
        HashMap<String, Object> body = new HashMap<>();
        body.put("taskId", "224185");

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
            message.setContent("已拿下！！！ [斗鱼链接](https://www.douyu.com/search/?kw=%E6%97%A0%E7%95%8F%E5%A5%91%E7%BA%A6)");
            message.setUid("UID_1n8ainvqiEiaEOFD5w0vXvRp00cj");
            message.setUrl("https://www.douyu.com/search/?kw=%E6%97%A0%E7%95%8F%E5%A5%91%E7%BA%A6"); //可选参数
            Result<List<MessageResult>> res = WxPusher.send(message);
            if (!res.isSuccess()) {
                Result<List<MessageResult>> result1 = WxPusher.send(message);
                flag = true;
            }
            flag = true;
        }
    }

}
