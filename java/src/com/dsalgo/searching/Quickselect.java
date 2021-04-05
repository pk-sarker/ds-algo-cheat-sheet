package com.dsalgo.searching;

/**
 * Find K-th smallest element in an unsorted array.
 *
 * Time complexity: O(N) in the average case, O(N^2) in the worst case.
 * Space complexity: O(1).
 */
public class Quickselect {
    public int  qSelect(int[] ar, int k) {
        return qSelect(ar, 0, ar.length-1, k);
    }
    public int qSelect(int ar[], int left, int right, int smallestPos) {
        // If the list contains only one element, return that element
        if (left == right) {
            return ar[left];
        }

        // can chose random pivot or last element in the list
        // Random rand = new Random();
        // int pivot_index = left + rand.nextInt(right-left);
        // pivot_index = partition(left, right, pivot_index);

        int pivot_index = partition(ar, left, right);
        // The pivot is in its final sorted position
        if (smallestPos == pivot_index) {
            return ar[pivot_index];
        } else if (smallestPos < pivot_index) {
            return qSelect(ar, left, pivot_index-1, smallestPos);
        } else {
            return qSelect(ar, pivot_index+1, right, smallestPos);
        }
    }

    public void swap(int ar[], int i, int j) {
        int t = ar[i];
        ar[i] = ar[j];
        ar[j] = t;
    }

    public int partition(int[] ar, int  low, int high) {
        int pivot = ar[high];
        int i = low;

        for (int j=low; j<high; j++) {
            if  (ar[j] < pivot) {
                swap(ar, i, j);
                i++;
            }
        }
        swap(ar, i, high);
        return i;
    }

    public static void main(String args[]) {
        Quickselect ob = new Quickselect();
        int[] ar = new int[]{1,4,9,6,5,8,2,7};
        System.out.println("\nInput: [1,4,9,6,5,8,2,7] k=0 \nOutput: " + ob.qSelect(ar, 0));
        System.out.println("\nInput: [1,4,9,6,5,8,2,7] k=1 \nOutput: " + ob.qSelect(ar, 1));
        System.out.println("\nInput: [1,4,9,6,5,8,2,7] k=2 \nOutput: " + ob.qSelect(ar, 2));
        System.out.println("\nInput: [1,4,9,6,5,8,2,7] k=6 \nOutput: " + ob.qSelect(ar, 6));
        System.out.println("\nInput: [1,4,9,6,5,8,2,7] k=7 \nOutput: " + ob.qSelect(ar, 7));
    }
}
