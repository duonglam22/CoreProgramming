package com.leetcode;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringToIntegerAtoi {
    public static ArrayList<String> listNumber = new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
    public static int myAtoi(String s) {
        int result = 0;
        s = s.trim();
        String[] arrStr = s.split(" ");
        int size = arrStr.length;
        for(int i = 0; i < size; i++) {
            String text = arrStr[i];
            if(!text.isEmpty() ) {
                Integer numberConverted = convertStringToInteger(text);
                if(numberConverted != null) {
                    result = numberConverted;
                    break;
                }
            }
            break;
        }
        return result;
    }

    public static Integer convertStringToInteger(String str) {

        String numberStr = str;
        int typeOfNumber = 1;
        int result;
        if(str.charAt(0) == '-' || str.charAt(0) == '+') {
            numberStr = str.substring(1);
            if(str.charAt(0) == '-') {
                typeOfNumber = -1;
            }
        }

            String intNumberStr = getNumber(numberStr);
            for(int i = 0; i < intNumberStr.length(); i++) {
                if (intNumberStr.charAt(i) == '.') {
                    intNumberStr = intNumberStr.substring(0, i);
                    break;
                }
            }

            intNumberStr = formatStringNumber(intNumberStr);
            if(intNumberStr.length() > 10) {
                if(typeOfNumber == 1) {
                    return Integer.MAX_VALUE;
                }
                else {
                    return Integer.MIN_VALUE;
                }
            }
            else if(intNumberStr.length() > 0) {
                Long number = Long.parseLong(intNumberStr);
                if(number > Integer.MAX_VALUE) {
                    if(typeOfNumber == 1) {
                        return Integer.MAX_VALUE;
                    }
                    else {
                        return Integer.MIN_VALUE;
                    }
                }
                else {
                    if(typeOfNumber == 1) {
                        result = number.intValue();
                        return result;
                    }
                    else {
                        result = 0 - number.intValue();
                        return result;
                    }
                }
            }


        return null;
    }


    public static String getNumber(String value) {
        String result = value;
        for(int i = 0; i < value.length(); i++) {
            if(!listNumber.contains(String.valueOf(value.charAt(i))) && value.charAt(i) != '.') {
                result = value.substring(0, i);
                break;
            }
        }
        return result;
    }

    public static String formatStringNumber(String value) {
        String result = value;
        for(int i = 0; i < value.length(); i++) {
            if(value.charAt(i) == '0') {
                result = value.substring(i);
            }
            else {
                break;
            }

        }
        return result;
    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int result = myAtoi(input);
        System.out.println(result);;

        scanner.close();
    }
}
