package com.raindown.tests.sciprt.douyu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class OkHttpUtils {
    private static final OkHttpClient client;

    static {
        client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS) // 设置连接超时时间
                .readTimeout(10, TimeUnit.SECONDS) // 设置读取超时时间z`
                .writeTimeout(10, TimeUnit.SECONDS) // 设置写入超时时间
                .build();
    }

    public static JSONObject sendPostFormRequest() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "taskAlias=20240912ITJRO_T5&rid=1457640&csrfToken=377516d058e8412283d2a8d5f1886359");
        Request request = new Request.Builder()
                .url("https://www.douyu.com/japi/carnival/nc/web/actTask/takePrize")
                .method("POST", body)
                .addHeader("accept", "application/json, text/plain, */*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en-US;q=0.8,en;q=0.7")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cookie", "dy_did=34875f100c40f4740d2794e200021601; dy_did=34875f100c40f4740d2794e200021601; dy_teen_mode=%7B%22uid%22%3A%22326458694%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_did=34875f100c40f4740d2794e200021601; m_did=bcebf4c0558bbb4970454615000617p1; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1728121940; HMACCOUNT=06AA6A0B58FCF524; acf_ssid=1729388853998033139; acf_web_id=7304219321440426761; acf_ab_pmt=20100212%23webnewhome%23B%2C20100254%23WebTool0703%23new%2C1479%23cover_select_web%23B%2C20100249%23webTagRank%23B%2C20100248%23webTagHover%23B; acf_ab_ver_all=20100212%2C20100254%2C1479%2C20100249%2C20100248; acf_ab_vs=webnewhome%3DB%2CWebTool0703%3Dnew%2Ccover_select_web%3DB%2CwebTagRank%3DB%2CwebTagHover%3DB; _clck=1pg9mvf%7C2%7Cfpr%7C0%7C1739; PHPSESSID=agoqrhdlrfpb0stmceivpmt9l4; acf_auth=f3013bZZKEOmUT4CkDLX4xreqi1Lk5%2F8xKrIzGALTAiEQ%2FgzH2BCM1%2BGbZ8SFU7%2FCgKli7q3sW6lyj2bUvL1HGswYiCmtDdW1gWTWaJyGvoFeu5LuRVclBM; acf_jwt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJtZDUifQ.eyJ1aWQiOjMyNjQ1ODY5NCwiY3QiOjAsInN1YiI6InN0IiwiYXVkIjpbImR5Iiwibm9uZSJdLCJiaXoiOjEsImx0a2lkIjo5NzE4NTM3Miwic3RrIjoiYzYxMGE5YzI2NGZiOTFkNCIsImV4cCI6MTcyODcyNjgxNywiaWF0IjoxNzI4MTIyMDIwLCJrZXkiOiJkeS1qd3QtbWQ1In0.MjBmYmQ4MDljOTZlMDQ0MTNjZTZmMDNhM2FjMjVhZDI; acf_dmjwt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJtZDUifQ.eyJ1aWQiOjMyNjQ1ODY5NCwiY3QiOjAsInN1YiI6InN0IiwiYXVkIjpbImRtIiwibm9uZSJdLCJiaXoiOjEsImx0a2lkIjo5NzE4NTM3Miwic3RrIjoiYzYxMGE5YzI2NGZiOTFkNCIsImV4cCI6MTcyODcyNjgxNywiaWF0IjoxNzI4MTIyMDIwLCJrZXkiOiJkeS1qd3QtbWQ1In0.ZDBlZjlkYzhhZTE1ZjMwNWQzYWM3NjM5NmQ0ZTZhYjM; dy_auth=91f9zH7dYUefHKy4AskrejEr29XBinTypEriXsc4CGbbDf3fTfiJj2yiZiuq2pgPGmfWGN5KODjETaoFrkOYqBtpxIBZmLJTLdEOnPFEJLxr9xoQBtwb0Jg; wan_auth37wan=fb4c8a50a9b9QhMMmZ8e2cUyVIl%2BwA7Ynsm7lx%2Fj71175xE4WQATpxt3m9aH4BlI94UaWJuVibl4X2DrWGrFJ4iOmY7wt7vBGnyv%2FmKdnX6vfztFKrI; acf_uid=326458694; acf_username=326458694; acf_nickname=%E8%99%9A%E5%8C%96%E9%9B%A8%E6%99%93; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F202112%2F6508e41a6e664d309f028d9215b7993d_; acf_ct=0; acf_ltkid=97185372; acf_biz=1; acf_stk=c610a9c264fb91d4; acf_ccn=a86938223f2778123eaf34f10e4c0d07; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1728122046; cvl_csrf_token=377516d058e8412283d2a8d5f1886359; _clsk=uenxpv%7C1728122693775%7C7%7C0%7Co.clarity.ms%2Fcollect")
                .addHeader("origin", "https://www.douyu.com")
                .addHeader("priority", "u=1, i")
                .addHeader("referer", "https://www.douyu.com/topic/pubgkx?dyshid=13755d46-34875f100c40f4740d2794e200021601")
                .addHeader("sec-ch-ua", "\"Google Chrome\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36")
                .addHeader("x-requested-with", "XMLHttpRequest")
                .build();
        Response response=null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String str = response.body().string();
                return JSON.parseObject(str);
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        } finally {
            response.body().close();
            response.close();
        }
    }




    public static JSONObject sendPostFormRequestZhu() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "taskAlias=20240912ITJRO_T7&rid=1457640&csrfToken=033a2b86135d4eb5b76cc16fd6c19625");
        Request request = new Request.Builder()
                .url("https://www.douyu.com/japi/carnival/nc/web/actTask/takePrize")
                .method("POST", body)
                .addHeader("accept", "application/json, text/plain, */*")
                .addHeader("accept-language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cookie", "dy_did=1f33d4c92b92baf21b36f12200081601; acf_did=1f33d4c92b92baf21b36f12200081601; dy_did=1f33d4c92b92baf21b36f12200081601; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1728124361; HMACCOUNT=9D928203BA00A0CF; acf_web_id=7312782116134081289; _ga=GA1.1.1705411940.1728124362; PHPSESSID=fast064kh5a8j46o095siarb26; acf_auth=4cb8hyxa8pIYt0hr%2BMCO0QEL7t1giVKgHO43x87PKU9tnHffMkWtsxW8Bzz2qsyXYjUdvQ%2FC4FpwLUCW4LEH8ctcUoTwLwM%2FXua2c3BgGqFgJmhJXBGhRhE; acf_jwt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJtZDUifQ.eyJ1aWQiOjM1NzE3NTY5NiwiY3QiOjAsInN1YiI6InN0IiwiYXVkIjpbImR5Iiwibm9uZSJdLCJiaXoiOjEsImx0a2lkIjoxMjMwMjEwNywic3RrIjoiNTA1MDQzYTYwZTRlNTU1NyIsImV4cCI6MTcyODcyOTIxOCwiaWF0IjoxNzI4MTI0NDIwLCJrZXkiOiJkeS1qd3QtbWQ1In0.Y2IxMDY0ZTI1N2Y2MTFhYWZkZjc1ODBlZDA5MTQwNzU; acf_dmjwt_token=eyJ0eXAiOiJKV1QiLCJhbGciOiJtZDUifQ.eyJ1aWQiOjM1NzE3NTY5NiwiY3QiOjAsInN1YiI6InN0IiwiYXVkIjpbImRtIiwibm9uZSJdLCJiaXoiOjEsImx0a2lkIjoxMjMwMjEwNywic3RrIjoiNTA1MDQzYTYwZTRlNTU1NyIsImV4cCI6MTcyODcyOTIxOCwiaWF0IjoxNzI4MTI0NDIwLCJrZXkiOiJkeS1qd3QtbWQ1In0.YjBlMTlkYjUxMDFiNjBjMjUzYjMwNTM5ZWY2N2M1Njk; dy_auth=bcf61dryqBApEGbHQU%2B%2FuM2ou6azcV3z%2BXnFik8rjt1RX%2FzJBiA6NPXfSJxB9%2BHGGDa4jrevGjtr2FBSRDHFwpPjS3yAnD3wuoM1knS9iwxr1YZ3cfU9ViQ; wan_auth37wan=72200398360bgDpzy6d58N0aIyhpAZaBA%2FFwsEtCX2FEJssQOZp1SnmYZJ9T9JVum%2FYXv2yl1zcbYw04G1nbNTlBm7TNbn1aPhE3xXgCT%2FD1P15gCv8; acf_uid=357175696; acf_username=357175696; acf_nickname=%E7%94%A8%E6%88%B761933781; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_avatar=https%3A%2F%2Fapic.douyucdn.cn%2Fupload%2Favatar_v3%2F202103%2F2d09e20c9ccf4a1384915f1e03008083_; acf_ct=0; acf_ltkid=12302107; acf_biz=1; acf_stk=505043a60e4e5557; dy_teen_mode=%7B%22uid%22%3A%22357175696%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_ssid=1729391053014298407; acf_ab_pmt=20100212%23webnewhome%23B%2C20100254%23WebTool0703%23new%2C1480%23cover_select_web%23C%2C20100249%23webTagRank%23B%2C20100248%23webTagHover%23B; acf_ab_ver_all=20100212%2C20100254%2C1480%2C20100249%2C20100248; acf_ab_vs=webnewhome%3DB%2CWebTool0703%3Dnew%2Ccover_select_web%3DC%2CwebTagRank%3DB%2CwebTagHover%3DB; acf_ccn=83a4c2ac01f4551785e523eefc2b7b3b; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1728124600; _ga_5JKQ7DTEXC=GS1.1.1728124362.1.1.1728124601.3.0.1165918560; cvl_csrf_token=033a2b86135d4eb5b76cc16fd6c19625")
                .addHeader("origin", "https://www.douyu.com")
                .addHeader("priority", "u=1, i")
                .addHeader("referer", "https://www.douyu.com/topic/pubgkx?dyshid=154a1190-1f33d4c92b92baf21b36f12200081601")
                .addHeader("sec-ch-ua", "\"Microsoft Edge\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129\"")
                .addHeader("sec-ch-ua-mobile", "?0")
                .addHeader("sec-ch-ua-platform", "\"Windows\"")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-site", "same-origin")
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/129.0.0.0 Safari/537.36 Edg/129.0.0.0")
                .addHeader("x-requested-with", "XMLHttpRequest")
                .build();
        Response response=null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String str = response.body().string();
                return JSON.parseObject(str);
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        } finally {
            response.body().close();
            response.close();
        }
    }
}
