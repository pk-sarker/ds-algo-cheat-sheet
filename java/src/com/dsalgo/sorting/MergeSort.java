package com.dsalgo.sorting;

import java.util.Arrays;

public class MergeSort {
    public int[] sort(int[] data) {
        sort(data, 0, data.length-1);
        return data;
    }

    public void sort(int[] data, int start, int end){
        if (start < end){
            int middle = start + (end-start)/2;

            sort(data, start, middle);
            sort(data, middle+1, end);
            merge(data, start, middle, end);
        }
    }

    /**
     * Merges two subarrays of data[].
     * First subarray is arr[start....middle]
     * Second subarray is arr[middle+1....end]
     * @param data
     * @param start
     * @param middle
     * @param end
     */
    public void merge(int[] data, int start, int middle, int end){
        int n1 = middle - start + 1;
        int n2 = end - middle;

        int L[] = new int[n1];
        int R[] = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i) {
            L[i] = data[start + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = data[middle + 1 + j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = start;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                data[k] = L[i];
                i++;
            }
            else {
                data[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            data[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            data[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String args[]) {
        MergeSort obj = new MergeSort();
        int[] data = new int[]{3,7,5,4,6,9,1,8,2,0};
        System.out.println(Arrays.toString(data));
        obj.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
