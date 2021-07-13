package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class DesignPdf {

    static int designerPdfViewer(int[] h, String word) {
        int result = 0;
        int length = word.length();
        int maxValueIndex = 0;
        for(int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int index = c - 97;
            if(h[index] > maxValueIndex) {
                maxValueIndex = h[index];
            }
        }
        result = maxValueIndex*length;
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] h = new int[26];
//        char a = 'a';
//        char z =  'z';
//        System.out.println("char at a: " + a);
//        System.out.println("char at z: " + z);

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 26; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        String word = scanner.nextLine();

        int result = designerPdfViewer(h, word);

        System.out.println(result);
        scanner.close();
    }
}
