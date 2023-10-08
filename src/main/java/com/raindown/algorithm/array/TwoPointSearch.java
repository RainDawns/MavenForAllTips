package com.raindown.algorithm.array;

/**
 * @author: RainDown
 * @description: 二分查找
 * @date: 2023/5/22 20:39
 * @version: 1.0
 */
public class TwoPointSearch {

    public int search(int[] arr, int target) {

        if (arr.length < 1 || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else if (arr[mid] > target)
                right = mid - 1;
        }

        return -1;
    }
}
