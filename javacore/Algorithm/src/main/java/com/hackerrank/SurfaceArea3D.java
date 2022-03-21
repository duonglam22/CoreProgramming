package com.hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.function.*;
        import java.util.regex.*;
        import java.util.stream.*;
        import static java.util.stream.Collectors.joining;
        import static java.util.stream.Collectors.toList;

public class SurfaceArea3D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int H = Integer.parseInt(firstMultipleInput[0]);

        int W = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> A = new ArrayList<>();

        IntStream.range(0, H).forEach(i -> {
            try {
                A.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = surfaceArea(A);

        System.out.println(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }

    public static int surfaceArea(List<List<Integer>> listTwoDimention) {
        // Write your code here
        int totalFreeSurface = 0;
        int row = listTwoDimention.size();
        for(int i = 0; i < row; i++) {
            int column = listTwoDimention.get(i).size();
            for(int j = 0; j < column; j++) {
                int tempHight = getFreeSurface(row, column, i, j, listTwoDimention);
                totalFreeSurface += tempHight;
            }
        }
        return totalFreeSurface;

    }

    public static int getFreeSurface(int row, int column, int i, int j, List<List<Integer>> listTwoDimention) {
        int totalFreeSurface = 2;
        int currentHight = listTwoDimention.get(i).get(j);
        //check front
        if(i-1 >= 0) {
            int frontHight = listTwoDimention.get(i-1).get(j);
            totalFreeSurface += currentHight > frontHight ? currentHight - frontHight : 0;
        }
        else {
            totalFreeSurface += currentHight;
        }

        //check behind
        if(i+1 <= row - 1) {
            int behindHight = listTwoDimention.get(i+1).get(j);
            totalFreeSurface += currentHight > behindHight ? currentHight - behindHight : 0;
        }
        else {
            totalFreeSurface += currentHight;
        }

        //check left
        if(j-1 >= 0) {
            int leftHight = listTwoDimention.get(i).get(j-1);
            totalFreeSurface += currentHight > leftHight ? currentHight - leftHight : 0;
        }
        else {
            totalFreeSurface += currentHight;
        }

        //check right
        if(j+1 <= column - 1) {
            int rightHight = listTwoDimention.get(i).get(j+1);
            totalFreeSurface += currentHight > rightHight ? currentHight - rightHight : 0;
        }
        else {
            totalFreeSurface += currentHight;
        }

        return totalFreeSurface;
    }
}
