package com.codeForce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Election {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int tc = Integer.parseInt(scanner.nextLine());
        for(int i = 0; i < tc; i++) {
            String[] abc = scanner.nextLine().split(" ");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);

            List<Integer> result = getResult(a, b, c);
            for(int j = 0; j < result.size(); j++) {
                System.out.print(result.get(j) + " ");
            }
            System.out.println();
        }
        scanner.close();
    }

    public static List<Integer> getResult(int a, int b, int c) {
        List<Integer> result = new ArrayList<>();
        int maxValue = getMaxValue(a, b, c);
        int tmp1;
        int tmp2;
        int tmp3;
        if(isMoreElementMax(a,b,c,maxValue)) {
            tmp1 = maxValue > a ? maxValue - a + 1 : 1;
            tmp2 = maxValue > b ? maxValue - b + 1 : 1;
            tmp3 = maxValue > c ? maxValue - c + 1 : 1;
        }
        else {
            tmp1 = maxValue > a ? maxValue - a + 1 : 0;
            tmp2 = maxValue > b ? maxValue - b + 1 : 0;
            tmp3 = maxValue > c ? maxValue - c + 1 : 0;
        }

        result.add(tmp1);
        result.add(tmp2);
        result.add(tmp3);

        return result;
    }

    public static int getMaxValue(int a, int b, int c) {
        int max = a > b ? a : b;
        max = max > c ? max : c;
        return max;
    }

    public static boolean isMoreElementMax(int a, int b, int c, int max) {
        int count = 0;
        if(max == a) {
            count++;
        }
        if(max == b) {
            count++;
        }
        if(max == c) {
            count++;
        }
        if(count >= 2) {
            return true;
        }
        return false;
    }
}
