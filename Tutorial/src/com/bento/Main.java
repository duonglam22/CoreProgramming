package com.bento;

public class Main {

    public static void main(String[] args) {
        String text = "10#0919616320#VNP#10004514301087#Yg3Cd5blu0EAnZylgGtXuw==#01-09-2018";
        String[] arrText = text.split("#");
        System.out.println("size: " + arrText[5]);

        System.out.println("end");
        return;
    }
}
