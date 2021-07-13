package com.hackerrank;

import java.util.Scanner;

public class EncryptString {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        String input = scanner.nextLine();
        int length = input.length();
        int row = (int)Math.sqrt(length);
        int col = 0;
        if(row*row < length) {
            col = row + 1;
        }
        else {
            col = row;
        }

        if(row*col < length) {
            row = col;
        }

        char[][] arr = stringToArrChar(input, row, col);
        String result = printResult(arr, row, col);
        System.out.println(result);
        scanner.close();
    }

    public static char[][] stringToArrChar(String text, int row, int col) {
        char[][] arr = new char[row][col];
        int leng = text.length();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int index = i*col + j;
                if(index < leng)
                    arr[i][j] = text.charAt(i*col + j);
            }
        }
        return arr;
    }

    public static String printResult(char[][] arr, int row, int col) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < col; i++) {
            for(int j = 0; j < row; j++) {
                if(arr[j][i] != 0)
                    result.append(arr[j][i]);
            }
            result.append(" ");
        }
        return result.toString();
    }
}
