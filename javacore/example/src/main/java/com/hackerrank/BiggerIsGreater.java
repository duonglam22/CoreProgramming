package com.hackerrank;

import java.util.Scanner;

public class BiggerIsGreater {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]){

        String testcaseStr = scanner.nextLine();
        int testcase = Integer.parseInt(testcaseStr);
        for(int i = 0; i < testcase; i++) {
            String input = scanner.nextLine();
            int arr[] = convertToArrInt(input);
            boolean flag = biggerThanGreater(arr);
            if(flag) {
                String result = convertArrIntToString(arr);
                System.out.println(result);
            }
            else {
                System.out.println("no answer");
            }
        }

    }

    public static boolean biggerThanGreater(int[] arr) {
        int size = arr.length;
        int indexEnd = size -1;
        boolean isFindIndexBigger = false;

        for(int i = indexEnd; i >=0; i--) {
            if(isIndexBigger(arr, i)) {
                isFindIndexBigger = true;
                quickSort(arr, i, indexEnd);
                break;
            }

        }


        return isFindIndexBigger;
    }

    public static String convertArrIntToString(int[] arr) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            char c = (char)arr[i];
            result.append(c);
        }

        return result.toString();
    }

    public static boolean isIndexBigger(int[] arr, int indexBegin) {
        if(indexBegin > 0 ) {
            if(arr[indexBegin] > arr[indexBegin-1]) {
                //swap
                int value = arr[indexBegin-1];
                int indexMinValueBiggerIndexBegin = indexBegin;
                for(int i = arr.length -1; i >=  indexBegin; i--) {
                    if(arr[i] > value && arr[i] < arr[indexMinValueBiggerIndexBegin]) {
                        indexMinValueBiggerIndexBegin = i;
                    }
                }
//                swap
                int temp = arr[indexBegin - 1];
                arr[indexBegin - 1] = arr[indexMinValueBiggerIndexBegin];
                arr[indexMinValueBiggerIndexBegin] = temp;
                return true;
            }
        }

        return false;
    }

    public static int[] convertToArrInt(String text) {
        int size = text.length();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            char c = text.charAt(i);
            arr[i] = (int)c;
        }

        return arr;
    }

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
