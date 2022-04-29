package com.common;

public class QuickSort {
    public static void swap(int[] arr, int left, int right) {
        int first = arr[left];
        arr[left] = arr[right];
        arr[right] = first;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];    // pivot
        int left = low;
        int right = high - 1;

        while (true) {
            while (left <= right && arr[left] < pivot) left++;
            while (right >= left && arr[right] > pivot) right--;
            if (left >= right) break;
            swap(arr, left, right);
            left++;
            right--;
        }
        swap(arr, left, high);
        return left;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int par = partition(arr, low, high);
            // recusive
            quickSort(arr, low, par - 1);
            quickSort(arr, par + 1, high);
        }
    }

    public static void main(String[] args){
        int a[] = {12, 23, 4, 5, 7,2, 1, 12, 9, 10, 43, 12, 32, 14};
        quickSort(a, 0, 13);

        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
