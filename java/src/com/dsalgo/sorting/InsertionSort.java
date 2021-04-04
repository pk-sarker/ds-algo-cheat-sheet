package com.dsalgo.sorting;

import java.util.Arrays;

public class InsertionSort {

    public int[] sort(int[] data) {
        int i=1, n=data.length;
        while(i < n) {
            int x = data[i];
            int j=i-1;
            while(j>=0 && data[j] > x) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = x;
            i++;
        }
        return data;
    }
    public static void main(String args[]) {
        InsertionSort obj = new InsertionSort();
        int[] data = new int[]{3,7,5,4,6,9,1,8,2,0};
        System.out.println(Arrays.toString(data));
        obj.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
