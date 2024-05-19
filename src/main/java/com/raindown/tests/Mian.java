package com.raindown.tests;

import com.google.common.collect.ForwardingIterator;
import com.google.errorprone.annotations.Var;

import java.util.*;

/**
 * @author: RainDown
 * @description: TODO
 * @date: 2023/12/14 19:00
 * @version: 1.0
 */
public class Mian {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int count = in.nextInt();
//        TreeMap<Integer, String> map = new TreeMap<>();
//        for (int i = 0; i < count; i++) {
//            String name = in.next();
//            int price = in.nextInt();
//            map.put(price, name);
//        }
//        Set<Map.Entry<Integer, String>> entries = map.entrySet();
//        for (Map.Entry<Integer, String> entry:entries){
//            System.out.println(entry.getValue());
//        }
//
//    }


//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s = in.nextLine();
//        boolean flag = isBalanced(s);
//        if (flag) {
//            System.out.println("YES");
//        } else {
//            System.out.println("NO");
//        }
//
//    }
//
//    public static boolean isBalanced(String str) {
//        int length = str.length();
//        if (length < 2) {
//            return false;
//        }
//        int index = length / 2;
//
//        int leftValue = getResult(str.substring(0, index));
//        int rightValue = getResult(str.substring(index, length));
//        while (index > 0 && index < length) {
//            int value = Integer.valueOf(str.substring(index, index + 1));
//            if (value==0 && leftValue==0){
//                return true;
//            }else if (value==0 && leftValue!=0){
//                return false;
//            }
//            if (leftValue == rightValue) {
//                return true;
//            } else if (leftValue > rightValue) {
//                index--;
//                leftValue=leftValue/value;
//                rightValue=rightValue*value;
//            } else if (leftValue < rightValue) {
//                index++;
//                leftValue=leftValue*value;
//                rightValue=rightValue/value;
//            }
//        }
//        return false;
//    }
//
//    public static int getResult(String str) {
//        int result = 1;
//        for (int i = 0; i < str.length(); i++) {
//            result = result * Integer.valueOf(str.substring(i, i + 1));
//        }
//
//        return result;
//    }

    //    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int times = in.nextInt();
//        int count = in.nextInt();
//        int length = in.nextInt();
//        ArrayList<Integer> list = new ArrayList<>(times);
//        for (int i = 0; i <times ; i++) {
//            list.add(in.nextInt());
//        }
//        int left= 0 ;
//        int right=length;
//        int result=0;
//        if (right<=list.size()){
//            System.out.println(getMax(list,left,list.size()-1,count));
//            return;
//        }
//        while (right<list.size()){
//            int values = getMax(list, left, right, count);
//            if (result<values){
//                result=values;
//            }
//            right++;
//            left++;
//        }
//        System.out.println(result);
//    }
//    public static int getMax(List<Integer> list,int left,int right,int count){
//        int result=1;
//        List<Integer> l = list.subList(left, right+1);
//        l.sort(Integer::compareTo);
//        for (int i = l.size()-count; i < l.size(); i++) {
//            result=result*list.get(i);
//        }
//        return result;
//    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] arr = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = in.nextInt();
            }
        }
        System.out.println(arr[1][2]);
        ArrayList<Integer> objects = new ArrayList<>();
        objects.sort(Integer::compareTo);
    }


    public static <T extends Comparable<T>> void quicklySort(T[] UN_SORTED_ARRAY, int start, int end) {
        //判断当前数组只会有一个元素或者没有元素
        if (start < end) {
            //得到当前基础存在数组的位置
            int currentPosition = calcCurrentBaseIndex(UN_SORTED_ARRAY, start, end);
            //向左递归
            quicklySort(UN_SORTED_ARRAY, start, currentPosition - 1);
            //向右递归
            quicklySort(UN_SORTED_ARRAY, currentPosition + 1, end);
        }
    }

    private static <T extends Comparable<T>> int calcCurrentBaseIndex(T[] CHILD_ARRAY, int start, int end) {
        //设置基数为当前数组最后一个数
        T base = CHILD_ARRAY[end];
        //记录数组开始位置
        int i = start;
        //从数组开始位置遍历，如果发现有比基数小的数，则和当前位置交换，将比基数小的数一到数组前面
        for (int j = start; j <= end - 1; j++) {
            if (CHILD_ARRAY[j].compareTo(base) <= 0) {
                T temp = CHILD_ARRAY[j];
                CHILD_ARRAY[j] = CHILD_ARRAY[i];
                CHILD_ARRAY[i] = temp;
                //确定基础应该在数组中的位置，每完成交换i就自增一次，当最后一次交换后那么i的位置就是基数应该在的位置
                i++;
            }
        }
        //最后将基数所在的位置跟i进行交换，保证此时基数有序
        T temp = CHILD_ARRAY[i];
        CHILD_ARRAY[i] = CHILD_ARRAY[end];
        CHILD_ARRAY[end] = temp;
        //最后将基数对应的位置返回
        return i;
    }


    public static <T extends Comparable<T>> void shellSort(T[] UN_SORTED_ARRAY){
        long startTime = System.currentTimeMillis();
        int incre = 1;
        //初始化当前增量
        while (incre < UN_SORTED_ARRAY.length >> 1){
            incre = (incre << 1) + 1;
        }
        while (incre >= 1){
            //每一段进行各自的插入排序
            for (int i = incre;i < UN_SORTED_ARRAY.length;i++){
                for (int j = i;j >= incre;j -= incre){
                    if (UN_SORTED_ARRAY[j - incre].compareTo(UN_SORTED_ARRAY[j]) <= 0){
                        break;
                    }
                    T temp = UN_SORTED_ARRAY[j - incre];
                    UN_SORTED_ARRAY[j - incre] = UN_SORTED_ARRAY[j];
                    UN_SORTED_ARRAY[j] = temp;
                }
            }
            //每一段插入排序完毕后减少增量，进一步提高咱们的查询效率
            incre = incre >> 1;
        }

        long endTime = System.currentTimeMillis();
        System.out.println("【使用希尔排序一共耗时】：" + (endTime - startTime) );
    }



//    public static void mergedSort(Long[] UN_SORTED_ARRAY){
//        //初始化辅助数组
//        Long[] assistArray = new Long[UN_SORTED_ARRAY.length];
//        int low = 0;
//        int high = UN_SORTED_ARRAY.length - 1;
//        //进行数组拆分
//        mergedSort(UN_SORTED_ARRAY,low,high);
//    }
//    private static void mergedSort(Long[] UN_SORT_ARRAY,int low,int high){
//        if (low >= high){
//            return;
//        }
//        int middle = low + ((high - low) >> 1);
//        //将原来数组按照中间值进行分解
//        mergedSort(UN_SORT_ARRAY,low,middle);
//        mergedSort(UN_SORT_ARRAY,middle + 1,high);
//        //拆分数组再进行合并操作
//        merge(UN_SORT_ARRAY,low,middle,high);
//    }

//    private static void merge(Long[] mergeArray,int low,int middle,int high){
//        //将排好序的数组元素填充到辅助数组对应的位置中去
//        int currentPosition = low;
//        int p1 = low;
//        int p2 = middle + 1;
//        while (p1 <= middle && p2 <= high){
//            if (mergeArray[p1] < mergeArray[p2]){
//                assistArray[currentPosition++] = mergeArray[p1++];
//            }else {
//                assistArray[currentPosition++] = mergeArray[p2++];
//            }
//        }
//
//        while (p1<= middle){
//            assistArray[currentPosition++] = mergeArray[p1++];
//        }
//
//        while (p2 <= high){
//            assistArray[currentPosition++] = mergeArray[p2++];
//        }
//        //将辅助数组对应的元素复制到原来数组对应的位置上
//        System.arraycopy(assistArray,low,mergeArray,low,high - low + 1);
//    }
}
