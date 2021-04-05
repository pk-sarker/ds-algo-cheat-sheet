package com.dsalgo.sorting;

import java.util.Arrays;

/**
 * Algorithm:
 * Quicksort is a divide and conquer algorithm. It first divides the input array into two smaller sub-arrays:
 * the low elements and the high elements. It then recursively sorts the sub-arrays. The steps for in-place
 * Quicksort are:
 *
 *      1. Pick an element, called a pivot, from the array.
 *      2. Partitioning: reorder the array so that all elements with values less than the pivot
 *          come before the pivot, while all elements with values greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. This is called the partition operation.
 *      3. Recursively apply the above steps to the sub-array of elements with smaller values and
 *          separately to the sub-array of elements with greater values.
 *
 * Pseudocode
 * quicksort(A, lo, hi) is
 *     if lo < hi then
 *         p := partition(A, lo, hi)
 *         quicksort(A, lo, p - 1)
 *         quicksort(A, p + 1, hi)
 *
 * partition(A, lo, hi) is
 *     pivot := A[hi]
 *     i := lo
 *     for j := lo to hi do
 *         if A[j] < pivot then
 *             swap A[i] with A[j]
 *             i := i + 1
 *     swap A[i] with A[hi]
 *     return i
 */
public class Quicksort {

    public int[] sort(int[] ar) {
        return this.sort(ar, 0, ar.length-1);
    }
    public int[] sort(int[] ar, int low, int high) {
        if (low < high) {
            int p = partition(ar, low, high);
            sort(ar, low, p-1);
            sort(ar, p+1, high);
        }

        return ar;
    }

    public int partition(int[] ar, int low, int high){
        int pivot  = ar[high];
        int i = low;
        for(int j=low;  j<high;  j++) {
            if (ar[j] < pivot) {
                swap(ar, i, j);
                i++;
            }
        }
        swap(ar, i, high);
        return i;
    }

    public void swap(int ar[], int i, int j) {
        int temp  = ar[j];
        ar[j] = ar[i];
        ar[i] = temp;
    }
    public static void main(String args[]) {
        int[] ar = new int[]{10, 7, 8, 9, 1, 5};
        System.out.println("Input array: "+ Arrays.toString(ar));
        Quicksort qs = new Quicksort();
        qs.sort(ar, 0, ar.length-1);
        System.out.println("Sorted array: " + Arrays.toString(ar));
    }
}