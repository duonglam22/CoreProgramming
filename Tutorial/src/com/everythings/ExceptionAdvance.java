package com.everythings;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ExceptionAdvance {

    public static void main(String[] args) {
        int a = 10;
        try{
            if(a <= 10) {
                throw new ArithmeticException("this number: " + a + " is invalid");
            }
            System.out.println("end!");
            return;
        }
        catch (Exception ex) {
            System.out.println("excetion : " + ex.toString());
            return;
        }
        finally {
            System.out.println("finally");
        }

    }
}
