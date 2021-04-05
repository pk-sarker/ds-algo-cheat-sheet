package com.dsalgo.sorting;

import java.util.Arrays;

public class ShellSort {

    public int[] sort(int[] data) {
        int gap = data.length/2;
        int n=data.length;

        while(gap > 0) {
            int i=gap;
            while(i < n) {
                int x = data[i];
                int j;
                for(j=i; j>=gap && data[j-gap] > x; j-=gap)  {
                    data[j]=data[j-gap];
                }
                data[j] = x;
                i++;
            }
            gap = gap/2;
        }

        return data;
    }

    public static void main(String args[]) {
        ShellSort obj = new ShellSort();
        int[] data = new int[]{3,7,5,4,6,9,1,8,2,0};
        System.out.println(Arrays.toString(data));
        obj.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
