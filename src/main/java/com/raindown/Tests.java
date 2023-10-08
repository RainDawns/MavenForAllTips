package com.raindown;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.raindown.tests.hotdog.OkHttpUtils;
import okhttp3.Headers;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/21 9:14
 * @version: 1.0
 */
public class Tests {
//    public static void main(String[] args) {
////        Message message = new Message();
////        message.setAppToken("AT_jAu2SfNk49Zi1BNCl7t2FHotNu8QBaGe");
////        message.setContentType(Message.CONTENT_TYPE_MD);
////        message.setContent("已拿下！！！ [斗鱼链接](https://www.douyu.com/search/?kw=%E6%97%A0%E7%95%8F%E5%A5%91%E7%BA%A6)");
////        message.setUid("UID_yVLVr2FE7fU7Yh0tjlKzHKFumyiw");
////        message.setUrl("https://www.douyu.com/search/?kw=%E6%97%A0%E7%95%8F%E5%A5%91%E7%BA%A6");//可选参数
////        Result<List<MessageResult>> res = WxPusher.send(message);
////分页查询全部用户
//        Result<Page<WxUser>> wxUsers = WxPusher.queryWxUser("AT_jAu2SfNk49Zi1BNCl7t2FHotNu8QBaGe", 1, 50);
//        wxUsers.getData().getRecords().forEach(d-> System.out.println(d.getUid()));
//////根据查询指定UID用户
//        Result<Page<WxUser>> users = WxPusher.queryWxUser("AT_jAu2SfNk49Zi1BNCl7t2FHotNu8QBaGe", "UID_yVLVr2FE7fU7Yh0tjlKzHKFumyiw");
//        System.out.println(JSONObject.toJSONString(users));
//        RequestTaskDouYu task = new RequestTaskDouYu();
//        task.run();
//        System.out.println(60*60*8+60*49);
//    }

//    public static void main(String[] args) {
////        File file=new File("music.mp3");
////        FileInputStream stream= null;
////        try {
////            stream = new FileInputStream(file);
////            Player player=new Player(stream);
////            player.play();
////        } catch (FileNotFoundException e) {
////            throw new RuntimeException(e);
////        } catch (JavaLayerException e) {
////            throw new RuntimeException(e);
////        }
//
//        HashMap<String, String> headers = new HashMap<>();
//        headers.put("Sign", "8e8ba19ed2813414d8d5e29873490900");
//        headers.put("Timestamp", "1691175484412");
//        headers.put("Token", "d5c90530f8304ea9ac2d71eb65e8ad87");
//        HashMap<String, String> body = new HashMap<>();
////        body.put("nft_product_size_id", "1701");
////        body.put("product_id", "1019749");
////        body.put("prop_pack", "2");
////        body.put("unlock", "0");
//        body.put("follow", "0");
//        body.put("notice_type", "0");
//        body.put("page_num", "-1");
//        body.put("page_size", "20");
//        JSONObject result = null;
//        try {
//            result = OkHttpUtils.sendPostRequest("https://api.aichaoliuapp.cn/aiera/common/banner_index_v2/notice", JSON.toJSONString(body), Headers.of(headers));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(result);
////        JSONArray data = result.getJSONArray("data");
////        System.out.println(data.size());
//
//    }




    public static void main(String[] args) {
//        File file=new File("music.mp3");
//        FileInputStream stream= null;
//        try {
//            stream = new FileInputStream(file);
//            Player player=new Player(stream);
//            player.play();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (JavaLayerException e) {
//            throw new RuntimeException(e);
//        }

        HashMap<String, String> headers = new HashMap<>();
        headers.put("Sign", "26dc267d15d08b95ac569d746ec8d539");
        headers.put("Timestamp", "1695640569734");
        headers.put("Token", "113d9ef2917c4cc68974200fe98c6173");
        HashMap<String, String> body = new HashMap<>();
//        body.put("nft_product_size_id", "1701");
        body.put("product_id", "1020576");
        body.put("product_size_id", "2418");
//        body.put("unlock", "0");没有更多了~
        body.put("page_size", "20");
//        body.put("pageNumber", "1");
        body.put("page", "1");
        JSONObject result = null;
        try {
            result = OkHttpUtils.sendPostRequest("https://api.aichaoliuapp.cn/aiera/v2/hotdog/order/trade/list", JSON.toJSONString(body), Headers.of(headers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        JSONArray data = result.getJSONArray("trade_data");
        System.out.println(data.size());


    }
}
