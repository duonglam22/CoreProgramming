package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class BeatifulDay {
    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
        int result = 0;
        for(int h = i; h <= j; h++) {
            int reserveNumber = reserveNumber(h);
            int different = specialSub(h, reserveNumber);
            if(different % k == 0) {
                result++;
            }
        }

        return result;
    }

    static int specialSub(int a, int b) {
        if(a > b)
            return a - b;
        else return b - a;
    }

    static int reserveNumber(int number) {
        String numberStr = String.valueOf(number);
        StringBuilder reserveStr = new StringBuilder();

        for (int i = numberStr.length() - 1; i >= 0 ; i--) {
            reserveStr.append(numberStr.charAt(i));
        }

        Integer reserveNumber = Integer.parseInt(reserveStr.toString());
        return reserveNumber;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] ijk = scanner.nextLine().split(" ");

        int i = Integer.parseInt(ijk[0]);

        int j = Integer.parseInt(ijk[1]);

        int k = Integer.parseInt(ijk[2]);

        int result = beautifulDays(i, j, k);

        System.out.println(result);;


        scanner.close();
    }
}
