package com.hackerrank;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
/*
input
3
3
3 1 2
4
1 3 4 2
5
1 2 3 5 4
 */

public class LarryArrayRotate {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = larrysArray(A);

                System.out.println(result);
//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static String larrysArray(List<Integer> arrayLarry) {
        // Write your code here
        String result = "NO";
        int size = arrayLarry.size();

        for(int i = 0; i < size; i++) {
            boolean isRotated = false;
            for(int j = 0; j < size; j++) {
                boolean flag = isNeedRotate(arrayLarry, j);
                if(flag) {
                    rotateItem(arrayLarry, j);
                    isRotated = true;
                }
            }
            if(!isRotated) {
                if(arrayLarry.get(size-1) > arrayLarry.get(size-2)) {
                    result = "YES";
                }
                return result;
            }
        }

        return result;
    }

    public static boolean isNeedRotate(List<Integer> arrayLarry, int index) {
        if(index + 2 >= arrayLarry.size()) {
            return false;
        }
        if(arrayLarry.get(index) > arrayLarry.get(index+1) || arrayLarry.get(index) > arrayLarry.get(index + 2)) {
            return true;
        }
        return false;
    }

    public static void rotateItem(List<Integer> arrayLarry, int index) {
        rotate(arrayLarry, index);
        if(isNeedRotate(arrayLarry, index)) {
            rotateItem(arrayLarry, index);
        }
    }

    public static void rotate(List<Integer> arrayLarry, int index) {
        Integer first = arrayLarry.get(index);
        Integer second = arrayLarry.get(index+1);
        Integer three = arrayLarry.get(index+2);
        arrayLarry.set(index, second);
        arrayLarry.set(index+1, three);
        arrayLarry.set(index+2, first);
    }
}
