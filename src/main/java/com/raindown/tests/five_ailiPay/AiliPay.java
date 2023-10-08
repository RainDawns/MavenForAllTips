package com.raindown.tests.five_ailiPay;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.raindown.tests.hotdog.OkHttpUtils;
import okhttp3.Headers;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/7/17 12:40
 * @version: 1.0
 */
public class AiliPay implements Runnable {
    private static String url = "https://land.jfcar.com.cn/new-api/gacTrumpchiFeedbacks/YwhZDqAcqDUfVpm";

    //    Sign:
//            89f90b29a51972851698ecd04b1ef323
//    Timestamp:
//            1689337499818
//    Token:
//            8785e89a23bf493d8009c0715878eca8
    @Override
    public void run() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1");
        HashMap<String, String> body = new HashMap<>();
        body.put("data", "mF6R5oLpI449D62Wm91s2X2o0qmvxJRtG9uPJ+eedvNucnhYKn4CI6CQnbpyc1hhw1bLk+RE6TA1Pi2PsNEYjp67HgeXxpcGus25rtyO6ZMhRVGa0c6DO1s4DoisJiIMEYL8hVqo1DPrzMgMXGhL9hqSTH2wcIUc03XDLj2ufExtwyJAME4Rybp7awrHcqWT");

        JSONObject result = null;
        try {
            result = OkHttpUtils.sendPostRequest(url, JSON.toJSONString(body), Headers.of(headers));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(DateUtil.formatDateTime(new Date())+"-----"+Thread.currentThread().getName()+result);
    }


}
