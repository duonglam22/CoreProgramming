package com.basicAgorithm.sort;

public class QuickSort {
    public static int N = 10;
    public static void main(String args[]) {
        int[][] arr = {
                {20, 50, 50, 50, 90, 30, 20, 10, 50, 20},
                {20, 50, 20, 10, 30, 20, 10, 50, 10, 33},
                {10, 21, 11, 11, 20, 12, 20, 50, 20, 10}
        };
        System.out.println("original array: ");
        printArr(arr);

        quickSort(arr, 0, true, 0, N-1);
        System.out.println("quick sort level 0: ");
        printArr(arr);

        for(int i = 0; i < N; i++) {
            int index = findIndexEqualValue(arr, 0, i);
//            System.out.println("index: " + index);
            if(index > i) {
                quickSort(arr, 1,false, i, index);
                i = index + 1;
            }
        }
//        quickSort(arr, 1,true, 0, 4);
        System.out.println("quick sort level 1: ");
        printArr(arr);
    }

    public static int findIndexEqualValue(int[][] arr, int level, int index) {
        int value = arr[level][index];
        for(int i = index; i < N; i++){
            if(arr[level][i] != value )
                return i-1;
        }
        return N-1;
    }

    public static void printArr(int[][] arr) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < N; j++) {
                    System.out.print(" " + arr[i][j]);
                }
            System.out.println();
            }
    }

    public static void swap(int[][] arr, int left, int right)
    {
        int first = arr[0][left];
        int second = arr[1][left];
        int third = arr[2][left];

        arr[0][left] = arr[0][right];
        arr[1][left] = arr[1][right];
        arr[2][left] = arr[2][right];

        arr[0][right] = first;
        arr[1][right] = second;
        arr[2][right] = third;
    }


    public static int partition (int[][] arr, int level, boolean isIncrease, int low, int high)
    {
        int pivot = arr[level][high];    // pivot
        int left = low;
        int right = high - 1;
        if(isIncrease) {
            while(true){
                while(left <= right && arr[level][left] < pivot) left++;
                while(right >= left && arr[level][right] > pivot) right--;
                if (left >= right) break;
                swap(arr, left, right);
                left++;
                right--;
            }
            swap(arr, left, high);
            return left;
        }
        else {
            while(true){
                while(left <= right && arr[level][left] > pivot) left++;
                while(right >= left && arr[level][right] < pivot) right--;
                if (left >= right) break;
                swap(arr, left, right);
                left++;
                right--;
            }
            swap(arr, left, high);
            return left;
        }

    }

    public static void quickSort(int[][] arr, int level, boolean isIncrease, int low, int high)
    {
        if (low < high)
        {

            int pi = partition(arr,level, isIncrease, low, high);

            // recusive
            quickSort(arr, level, isIncrease, low, pi - 1);
            quickSort(arr, level, isIncrease, pi + 1, high);
        }
    }
}
