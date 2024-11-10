package com.raindown.tests.sciprt.douyu;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
import com.zjiecode.wxpusher.client.bean.Result;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/14 23:05
 * @version: 1.0
 */
public class RequestTaskDouYu1005plus implements Runnable {
    private static String url = "https://www.douyu.com/japi/carnival/nc/web/actTask/takePrize";
    private static String ownCookie = "dy_did=34875f100c40f4740d2794e200021601; dy_did=34875f100c40f4740d2794e200021601; dy_teen_mode=%7B%22uid%22%3A%22326458694%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_did=34875f100c40f4740d2794e200021601; m_did=bcebf4c0558bbb4970454615000617p1; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1728121940; HMACCOUNT=06AA6A0B58FCF524; acf_ssid=1729388853998033139; acf_web_id=7304219321440426761; acf_ab_pmt=20100212%23webnewhome%23B%2C20100254%23WebTool0703%23new%2C1479%23cover_select_web%23B%2C20100249%23webTagRank%23B%2C20100248%23webTagHover%23B; acf_ab_ver_all=20100212%2C20100254%2C1479%2C20100249%2C20100248; acf_ab_vs=webnewhome%3DB%2CWebTool0703%3Dnew%2Ccover_select_web%3DB%2CwebTagRank%3DB%2CwebTagHover%3DB; _clck=1pg9mvf%7C2%7Cfpr%7C0%7C1739; PHPSESSID=agoqrhdlrfpb0stmceivpmt9l4; acf_auth=f3013bZZKEOmUT4CkDLX4xreqi1Lk5%2F8xKrIzGALTAiEQ%2FgzH2BCM1%2BGbZ8SFU7%2FCgKli7q3sW6lyj2bUvL1HGswYiCmtDdW1gWTWaJyGvoFeu5LuRVclBM; acf_jwt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJtZDUifQ.eyJ1aWQiOjMyNjQ1ODY5NCwiY3QiOjAsInN1YiI6InN0IiwiYXVkIjpbImR5Iiwibm9uZSJdLCJiaXoiOjEsImx0a2lkIjo5NzE4NTM3Miwic3RrIjoiYzYxMGE5YzI2NGZiOTFkNCIsImV4cCI6MTcyODcyNjgxNywiaWF0IjoxNzI4MTIyMDIwLCJrZXkiOiJkeS1qd3QtbWQ1In0.MjBmYmQ4MDljOTZlMDQ0MTNjZTZmMDNhM2FjMjVhZDI; acf_dmjwt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJtZDUifQ.eyJ1aWQiOjMyNjQ1ODY5NCwiY3QiOjAsInN1YiI6InN0IiwiYXVkIjpbImRtIiwibm9uZSJdLCJiaXoiOjEsImx0a2lkIjo5NzE4NTM3Miwic3RrIjoiYzYxMGE5YzI2NGZiOTFkNCIsImV4cCI6MTcyODcyNjgxNywiaWF0IjoxNzI4MTIyMDIwLCJrZXkiOiJkeS1qd3QtbWQ1In0.ZDBlZjlkYzhhZTE1ZjMwNWQzYWM3NjM5NmQ0ZTZhYjM; dy_auth=91f9zH7dYUefHKy4AskrejEr29XBinTypEriXsc4CGbbDf3fTfiJj2yiZiuq2pgPGmfWGN5KODjETaoFrkOYqBtpxIBZmLJTLdEOnPFEJLxr9xoQBtwb0Jg; wan_auth37wan=fb4c8a50a9b9QhMMmZ8e2cUyVIl%2BwA7Ynsm7lx%2Fj71175xE4WQATpxt3m9aH4BlI94UaWJuVibl4X2DrWGrFJ4iOmY7wt7vBGnyv%2FmKdnX6vfztFKrI; acf_uid=326458694; acf_username=326458694; acf_nickname=%E8%99%9A%E5%8C%96%E9%9B%A8%E6%99%93; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F202112%2F6508e41a6e664d309f028d9215b7993d_; acf_ct=0; acf_ltkid=97185372; acf_biz=1; acf_stk=c610a9c264fb91d4; acf_ccn=a86938223f2778123eaf34f10e4c0d07; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1728122046; cvl_csrf_token=377516d058e8412283d2a8d5f1886359; _clsk=uenxpv%7C1728122693775%7C7%7C0%7Co.clarity.ms%2Fcollect\n";
    public volatile boolean flag = false;

    @Override
    public void run() {
        JSONObject result = null;
        try {
            result = OkHttpUtils.sendPostFormRequestZhu();
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
