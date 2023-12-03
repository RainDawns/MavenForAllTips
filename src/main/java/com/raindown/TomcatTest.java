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
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str = in.nextLine();
        System.out.println(getSum(str));
        in.close();
    }

    public static int getSum(String str){
         str = str.replaceAll(" ", "");

        return str.length();
    }


}
