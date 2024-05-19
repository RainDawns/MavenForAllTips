package com.raindown.practise;

/**
 * date: 2024/4/30
 *
 * @author raindown
 */
public class Main3 {
    public static void main(String[] args) {
        int[] array = new int[500];
        for (int i = 0; i < 500; i++) {
            array[i] = i + 1;
        }
        System.out.println(last(array));
    }

    public static int last(int[] array){
        while (array.length > 1) {
            int[] newArray = new int[(array.length + 1) / 2];
            int newIndex = 0;
            for (int i = 1; i < array.length; i += 2) {
                newArray[newIndex] = array[i];
                newIndex++;
            }
            array = newArray;
        }

        int lastNumber = array[0];
        return lastNumber;
    }
}
