package com.leetcode;

import java.io.IOException;
import java.util.Scanner;

public class RomanNumber {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int input = 58;
        System.out.println(intToRoman(input));

        scanner.close();
    }

    public static String intToRoman(int num) {
        String result = "";
        for(int i = 3; i >= 0; i--) {
            int temp = (int) Math.pow(10, i);
            int value = num / temp;
            if(value > 0) {
                result += getValueNumber(value, i);
                num = num % temp;
            }
        }

        return result;
    }

    public static String getValueNumber(int number, int index) {
        String result = "";
        switch (index) {
            case 3:
                result = getNumberThousand(number);
                break;
            case 2:
                result = getNumberHundred(number);
                break;
            case 1: result = getNumberTen(number);
                break;
            case 0: result = getNumberOne(number);
                break;
            default:
                break;
        }
        return result;
    }

    public static String getNumberThousand(int num) {
        String result = "";
        switch (num) {
            case 3:
                result = "MMM";
                break;
            case 2:
                result = "MM";
                break;
            case 1:
                result = "M";
                break;
            default:
                break;
        }
        return result;
    }

    public static String getNumberHundred(int num) {
        String result = "";
        switch (num) {
            case 9:
                result = "CM";
                break;
            case 8:
                result = "DCCC";
                break;
            case 7:
                result = "DCC";
                break;
            case 6:
                result = "DC";
                break;
            case 5:
                result = "D";
                break;
            case 4:
                result = "CD";
                break;
            case 3:
                result = "CCC";
                break;
            case 2:
                result = "CC";
                break;
            case 1:
                result = "C";
                break;
            default:
                break;
        }
        return result;
    }
    public static String getNumberTen(int num) {
        String result = "";
        switch (num) {
            case 9:
                result = "XC";
                break;
            case 8:
                result = "LXXX";
                break;
            case 7:
                result = "LXX";
                break;
            case 6:
                result = "LX";
                break;
            case 5:
                result = "L";
                break;
            case 4:
                result = "XL";
                break;
            case 3:
                result = "XXX";
                break;
            case 2:
                result = "XX";
                break;
            case 1:
                result = "X";
                break;
            default:
                break;
        }
        return result;

    }

    public static String getNumberOne(int num) {
        String result = "";
        switch (num) {
            case 9:
                result = "IX";
                break;
            case 8:
                result = "VIII";
                break;
            case 7:
                result = "VII";
                break;
            case 6:
                result = "VI";
                break;
            case 5:
                result = "V";
                break;
            case 4:
                result = "IV";
                break;
            case 3:
                result = "III";
                break;
            case 2:
                result = "II";
                break;
            case 1:
                result = "I";
                break;
            default:
                break;
        }
        return result;

    }

}
