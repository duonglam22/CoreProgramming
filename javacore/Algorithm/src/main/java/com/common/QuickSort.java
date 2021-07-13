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
            int pi = partition(arr, low, high);
            // recusive
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
