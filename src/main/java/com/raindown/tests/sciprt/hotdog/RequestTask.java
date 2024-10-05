package com.raindown.tests.sciprt.hotdog;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import okhttp3.Headers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/14 23:05
 * @version: 1.0
 */
public class RequestTask implements Runnable {
    private static String url = "https://api.aichaoliuapp.cn/aiera/ai_match_trading/nft_second/sell_product/list";

    //    Sign:
//            89f90b29a51972851698ecd04b1ef323
//    Timestamp:
//            1689337499818
//    Token:
//            8785e89a23bf493d8009c0715878eca8
    @Override
    public void run() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Sign", "78fb2db1c69003dbe9eac864aa95be64");
        headers.put("Timestamp", "1690087450764");
        headers.put("Token", "782d4798a0da46fbb324102f233651f4");
        HashMap<String, String> body = new HashMap<>();
        body.put("nft_product_size_id", "1737");
        body.put("product_id", "1019795");
        body.put("prop_pack", "2");
        body.put("unlock", "1");
        body.put("pageSize", "1");
        body.put("pageNumber", "20");
        JSONObject result = null;
        try {
            result = OkHttpUtils.sendPostRequest("https://api.aichaoliuapp.cn/aiera/ai_match_trading/nft_second/sell_product/list", JSON.toJSONString(body), Headers.of(headers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String code = result.getString("code");
        if ("20002".equals(code)) {
            System.out.println(DateUtil.formatDateTime(new Date()) + "-----" + Thread.currentThread().getName() + "-----" + "令牌过期");
            File file = new File("music.mp3");
            FileInputStream stream = null;
            try {
                stream = new FileInputStream(file);
                Player player = new Player(stream);
                player.play();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (JavaLayerException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        JSONArray res = result.getJSONObject("data").getJSONArray("res");
        if (res.size() > 0) {
            System.out.println(DateUtil.formatDateTime(new Date()) + "-----" + Thread.currentThread().getName() + "-----" + "放货成功");
            String second_id = res.getJSONObject(0).getString("second_id");
            try {
                HashMap<String, String> bodys = new HashMap<>();
                bodys.put("operate_type", "buy");
                bodys.put("second_id", second_id);
                result = OkHttpUtils.sendPostRequest("https://api.aichaoliuapp.cn/aiera/ai_match_trading/nft_second/sell_order/pay", JSON.toJSONString(bodys), Headers.of(headers));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println(DateUtil.formatDateTime(new Date()) + "-----" + Thread.currentThread().getName() + "-----" + result);
            String codes = result.getString("code");
            if ("0".equals(codes)) {
                String order_id = result.getJSONObject("data").getString("order_id");
                HashMap<String, String> bodys = new HashMap<>();
                bodys.put("card_id", "OJKN");
                bodys.put("order_id", order_id);
                bodys.put("pay_channel", "3");
                try {
                    result = OkHttpUtils.sendPostRequest("https://api.aichaoliuapp.cn/aiera/v2/hotdog/order/prepay", JSON.toJSONString(bodys), Headers.of(headers));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(DateUtil.formatDateTime(new Date()) + "-----" + Thread.currentThread().getName() + "-----" + result);
                File file = new File("music.mp3");
                FileInputStream stream = null;
                try {
                    stream = new FileInputStream(file);
                    Player player = new Player(stream);
                    player.play();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (JavaLayerException e) {
                    throw new RuntimeException(e);
                }
            }

        } else {
            System.out.println(DateUtil.formatDateTime(new Date()) + "-----" + Thread.currentThread().getName() + "-----" + "暂无");
        }
    }
}
