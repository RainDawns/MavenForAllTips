package com.raindown;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.raindown.tests.hotdog.OkHttpUtils;
import okhttp3.Headers;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/3/25 20:42
 * @version: 1.0
 */
public class MavenForAllTipsMainApplication {
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
        headers.put("Sign", "02741392326306b857c259e9b34b027d");
        headers.put("Timestamp", "1695893022609");
        headers.put("Token", "113d9ef2917c4cc68974200fe98c6173");
        HashMap<String, String> body = new HashMap<>();
//        body.put("nft_product_size_id", "1701");
//        body.put("product_id", "1019749");
//        body.put("prop_pack", "2");
//        body.put("unlock", "0");没有更多了~
        body.put("pageSize", "100000");
        body.put("pageNumber", "1");
        body.put("page_type", "0");
        JSONObject result = null;
        try {
            result = OkHttpUtils.sendPostRequest("https://api.aichaoliuapp.cn/aiera/trade/withdraw_log/get", JSON.toJSONString(body), Headers.of(headers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(result);
        JSONArray data = result.getJSONArray("data");
        System.out.println(data.size());
        BigDecimal money = BigDecimal.ZERO;
        for (int i = 0; i < data.size(); i++) {

            JSONObject jsonObject = data.getJSONObject(i);
            if (jsonObject.getString("product_name").contains("提现") || jsonObject.getString("product_name").contains("充值") || jsonObject.getString("product_name").contains("收益已转入")) {
                continue;
            }
//            System.out.println(jsonObject.getString("amount"));
            Double amount = Double.valueOf(jsonObject.getString("fee"));

            BigDecimal m = BigDecimal.valueOf(amount);
            System.out.println(m + "-----" + jsonObject.getString("remark"));
            money = money.add(m);
        }

        System.out.println("last result" + money);
    }
}

