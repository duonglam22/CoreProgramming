package com.leetcode;

import java.io.IOException;
import java.util.Scanner;

public class ContainerWithMostWater {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        int input[] =  {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(input));

        scanner.close();
    }

    public static int maxArea(int[] height) {
        int size = height.length;
        int indexHeightest = 0;
        int spread = 0;
        for(int i = 0; i < size; i++) {
            int tempSpread = (size - i)*height[i];
            if(tempSpread < spread) {
                continue;
            }
            if(i >= indexHeightest) {
                indexHeightest += 1;
            }
            for(int j = i+1; j < size; j++) {
                if(j < indexHeightest) {
                    j = indexHeightest;
                }
                if(height[indexHeightest] < height[j]) {
                    indexHeightest = j;
                }
                int currentSpread = getVolumeByIndex(i, j, height[i], height[j]);
                if(spread < currentSpread) {
                    spread = currentSpread;
                }
            }
        }

        return spread;
    }

    public static int getVolumeByIndex(int i, int j, int iHeight, int jHeight) {
        int height = iHeight < jHeight ? iHeight : jHeight;
        int width = j - i;
        int spread = height*width;
        return spread;
    }
}
