package com.raindown;

import cn.hutool.http.HttpUtil;
import sun.misc.Unsafe;

import java.io.IOError;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/10/31 23:20
 * @version: 1.0
 */
public abstract class TomcatTest {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息

    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        String str = in.nextLine();
//        System.out.println(getSum(str));
//        in.close();
/*
        Message message = new Message();
        message.setAppToken("AT_jAu2SfNk49Zi1BNCl7t2FHotNu8QBaGe");
        message.setContentType(Message.CONTENT_TYPE_MD);
        message.setContent("已拿下！！！ [斗鱼链接](https://www.douyu.com/topic/ymzxgc?rid=10075970&dyshid=13755d46-34875f100c40f4740d2794e200021601)");
        message.setUid("UID_8TmS0m9VKx8biQcP27u766xMbicR");
        message.setUrl("https://www.douyu.com/topic/ymzxgc?rid=10075970&dyshid=13755d46-34875f100c40f4740d2794e200021601"); //可选参数
        Result<List<MessageResult>> res = WxPusher.send(message);
        List<MessageResult> data = res.getData();
        System.out.println(data.size());
        MessageResult messageResult = data.get(0);
        System.out.println(messageResult.getStatus());
*/



    }

    @Deprecated
    public static int getSum(String str){
         str = str.replaceAll(" ", "");

        return str.length();


    }


}
