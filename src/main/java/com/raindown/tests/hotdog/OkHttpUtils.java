package com.raindown.tests.hotdog;

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

    public static String sendGetRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }

    public static JSONObject sendPostRequest(String url, String requestBody, Headers headers) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestBody);
        Request request = new Request.Builder().headers(headers)
                .url(url)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String str = response.body().string();
                response.close();
                return JSON.parseObject(str);
            } else {
                throw new IOException("Unexpected response code: " + response.code());
            }
        }
    }
    public static JSONObject sendPostFormRequest(String url, Map<String,Object> param, Headers headers) throws IOException {
//        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), requestBody);
        FormBody.Builder builder = new FormBody.Builder();

        for (String key : param.keySet()) {
            Object obj = param.get(key);
            if (obj != null) {
                builder.addEncoded(key, param.get(key).toString());
            } else {
                builder.addEncoded(key, "");
            }
        }
        FormBody  requestBody = builder.build();

        Request request = new Request.Builder().headers(headers)
                .url(url)
                .post(requestBody)
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
