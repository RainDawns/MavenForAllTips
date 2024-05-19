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
import java.util.concurrent.*;

public class ScheduledTaskWithReturnValueExample {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);
        Long millons=1000*1L;
        try {
            Thread.sleep(millons);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long periodInSeconds = 1; // 任务定时触发的周期，单位为秒

        // 设置定时任务，并获取任务返回值
        Future<Boolean> future = scheduledExecutor.schedule(() -> {
            String url = "https://www.douyu.com/japi/carnival/nc/roomTask/getPrize";
            HashMap<String, String> headers = new HashMap<>();
            headers.put("Content-Type", "application/x-www-form-urlencoded");
            headers.put("Cookie", "dy_did=34875f100c40f4740d2794e200021601; acf_did=34875f100c40f4740d2794e200021601; loginrefer=pt_2c486li72b91; dy_did=34875f100c40f4740d2794e200021601; dy_teen_mode=%7B%22uid%22%3A%22326458694%22%2C%22status%22%3A0%2C%22birthday%22%3A%22%22%2C%22password%22%3A%22%22%7D; acf_auth=65138EjuPzHkGfc%2BZ1cjAr%2FOE9LPo3kC4RdeenBABT15vh%2BIvsLEHRWsrWxI%2FRbPjsoxLooguvB%2FDNx4xdgniCundW7pSAWxisYFFIQTFdl1tothptTLIUY; dy_auth=86d3oKCe2P7Vic2jHcC71H6ZWILH7NXUJgMLreO3t%2FzrDi4mR0DESllnDjiJla5YjqOFs6kSSlAy%2Bw5kgVrYstsdDGo%2BAxOnCp%2F2cvO2Oryx7%2FLK8wnpXCg; wan_auth37wan=291ff50c9b8ehCHLGazg%2BiGws4xGJJYIHmZUTMmGnmc0s%2Byf7OUA3fWvtjZeT0AZHndBifiy4QQ8c0wrjx%2FhHAlI91K3HVNyAl60%2FbvXj5jKe5bNMD0; acf_uid=326458694; acf_username=326458694; acf_nickname=%E8%99%9A%E5%8C%96%E9%9B%A8%E6%99%93; acf_own_room=1; acf_groupid=1; acf_phonestatus=1; acf_ct=0; acf_ltkid=97185351; acf_biz=1; acf_stk=2638fdb6d50e7a4f; acf_avatar=//apic.douyucdn.cn/upload/avatar_v3/202112/6508e41a6e664d309f028d9215b7993d_; Hm_lvt_e99aee90ec1b2106afe7ec3b199020a7=1689744642,1689844093,1689844189,1689868396; Hm_lpvt_e99aee90ec1b2106afe7ec3b199020a7=1689868402; cvl_csrf_token=95a8dacd733d4ed79e05a0878a32a49b");
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
                return true;
            }
            return false;
        }, periodInSeconds, TimeUnit.SECONDS);

        try {
            while (!future.isDone()) {
                // 等待任务执行完成
                Thread.sleep(1000);
            }

            // 输出任务执行结果
            Boolean result = future.get();


            //调用API发送微信消息
            if (result){
//                File file = new File("music.mp3");
//                FileInputStream stream = null;
//                try {
//                    stream = new FileInputStream(file);
//                    Player player = new Player(stream);
//                    player.play();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                } catch (JavaLayerException e) {
//                    throw new RuntimeException(e);
//                }
                Message message = new Message();
                message.setAppToken("AT_jAu2SfNk49Zi1BNCl7t2FHotNu8QBaGe");
                message.setContentType(Message.CONTENT_TYPE_MD);
                message.setContent("已拿下！！！ [斗鱼链接](https://www.douyu.com/search/?kw=%E6%97%A0%E7%95%8F%E5%A5%91%E7%BA%A6)");
                message.setUid("UID_1n8ainvqiEiaEOFD5w0vXvRp00cj");
                message.setUrl("https://www.douyu.com/search/?kw=%E6%97%A0%E7%95%8F%E5%A5%91%E7%BA%A6"); //可选参数
                Result<List<MessageResult>> res = WxPusher.send(message);
                if (!res.isSuccess()){
                    Result<List<MessageResult>> result1 = WxPusher.send(message);
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            scheduledExecutor.shutdown(); // 关闭 ScheduledExecutorService
        }
    }
}
