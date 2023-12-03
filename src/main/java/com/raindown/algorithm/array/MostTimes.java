package com.raindown.algorithm.array;

import com.sun.tools.javac.Main;

import java.util.Arrays;

/**
 * @author: RainDown
 * @description: 找出数组中出现次数超一半的值
 * @date: 2023/12/3 20:00
 * @version: 1.0
 */
public class MostTimes {
    public static void main(String[] args) {
        int[] arr={123,12312,21,12,21,3,21,3123,123,21,12};
        System.out.println(getMostTimes(arr));
    }

    public static int getMostTimes(int[] arr) {

        if (arr.length < 1){
            throw new RuntimeException("illage input");
        }
        int result = arr[0];
        int times = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==result){
                times++;
            }else {
                times--;
            }
            if (times ==0){
                result= arr[i+1];
                times++;
            }
        }
        return result;

    }

}
