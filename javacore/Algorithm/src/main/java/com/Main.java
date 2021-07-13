package com;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        String code = "|1#VNP|";
        String[] list = code.split("\\|");
        System.out.println(list.length);
        for (String item : list) {
            String[] text = item.split("#");
            if(text.length > 1) {
                System.out.println(item);
            }
        }


        return;
    }
}
