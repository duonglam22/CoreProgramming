package com.hackerrank;

import java.io.*;

public class CountValley {

    public static int countingValleys(int steps, String path) {
        int result = 0;
        int currentLevel = 0;
        boolean isStartValley = false;
        for (int i = 0; i < steps; i++) {
            if(path.charAt(i) == 'U') {
                currentLevel++;
                if(currentLevel == 0) {
                    isStartValley = false;
                    result++;
                }
            }
            else if(path.charAt(i) == 'D'){
                if(currentLevel == 0) {
                    isStartValley = true;
                }
                currentLevel--;
            }
            else
                System.out.println("path is invalide");
        }
        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = countingValleys(steps, path);

        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
