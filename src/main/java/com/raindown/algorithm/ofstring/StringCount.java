package com.raindown.algorithm.ofstring;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/12/3 21:25
 * @version: 1.0
 */
public class StringCount {

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine();
//        int length=0;
//        for (int i = str.length()-1; i >=0 ; i--) {
//            if (str.charAt(i)==' '){
//                length=str.length()-1-i;
//                break;
//            }
//        }
//        if (length==0){
//            length=str.length();
//        }
//        System.out.println(length);
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String str = in.nextLine().toLowerCase();
//        String result=in.nextLine().toLowerCase();
//        int times=0;
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == result.charAt(0)){
//                times++;
//            }
//        }
//        System.out.println(times);
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int length = in.nextInt();
//        List<Integer> list=new ArrayList<>();
//        for (int i = 0; i < length; i++) {
//            int value = in.nextInt();
//            if (!list.contains(value)){
//                list.add(value);
//            }
//        }
//        list.sort(Integer::compareTo);
//        list.forEach(System.out::println);
//
//    }

//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        int i = s.length() % 8;
////        System.out.println(i);
//
//        int need=8-i;
//        if (i==0){
//            need=0;
//        }
//        StringBuilder stringBuilder = new StringBuilder(s);
//        for (int j = 0; j < need; j++) {
//            stringBuilder.append("0");
//        }
//        String s1 = stringBuilder.toString();
//        for (int j = 0; j < s1.length(); j=j+8) {
//            System.out.println(s1.substring(j,j+8));
//        }
//    }

    //    public static void main(String[] args) throws Exception{
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNextLine()){
//            String s = sc.nextLine();
//            System.out.println(Integer.parseInt(s.substring(2,s.length()),16));
//        }
//    }
//    public static void main(String[] args) {
//        // 处理输入
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String[] split = s.split("\\.");
//        if (split.length<2){
//            System.out.println(split[0]);
//            return;
//        }
//        String s1 = split[1];
//        if (Integer.parseInt(s1.substring(0, 1))>=5){
//            System.out.println(Integer.parseInt(split[0])+1);
//        }else {
//            System.out.println(split[0]);
//        }
//
////
//
//    }


//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        while (sc.hasNext()) {
//            int n = sc.nextInt();
//            for (int i = 0; i < n; i++) {
//                int key = sc.nextInt();
//                int value = sc.nextInt();
//                map.put(key, map.getOrDefault(key, 0) + value);
//            }
//            for (Integer i : map.keySet()) {
//                System.out.println(i + " " + map.get(i));
//            }
//        }
//    }


//    public static void main(String agrs[]) {
////        Scanner sc = new Scanner(System.in);
////        String line = sc.nextLine();
////        StringBuilder stringBuilder = new StringBuilder(line);
////        System.out.println(stringBuilder.reverse().toString());
////    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        while (in.hasNextLine()) { // 注意 while 处理多个 case
//            String s = in.nextLine();
//            String[] strArray = s.split(" ");
//            int i=0;
//            int j=strArray.length-1;
//            while (i<j){
//                String temp = strArray[i];
//                strArray[i]=strArray[j];
//                strArray[j]=temp;
//                i++;
//                j--;
//            }
//            for (int k = 0; k < strArray.length; k++) {
//                System.out.print(strArray[k]+" ");
//            }
//
//        }
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int size = in.nextInt();
//        ArrayList<Object> list = new ArrayList<>();
//        for (int i = 0; i < size; i++) {
//            list.add(in.nextLine());
//        }
//        list.stream().sorted().forEach(System.out::println);
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//
//        int values = in.nextInt();
//        String str = Integer.toString(values, 2);
//        int max = 0;
//        int count = 0;
//        for (int i = 0; i <str.length(); i++) {
//            char c = str.charAt(i);
//            if (c=='1'){
//                count++;
//                if (i==str.length()-1||(i!=str.length()-1 && str.charAt(i+1)=='0')){
//                    if (count>max){
//                        max=count;
//                    }
//                }
//            }else {
//                count=0;
//            }
//        }
//        System.out.println(max);
//
//    }





}
