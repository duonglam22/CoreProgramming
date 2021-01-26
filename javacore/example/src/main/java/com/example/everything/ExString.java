/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.everything;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author MSI
 */
public class ExString {
    
   public static void main(String args[]){
//       String dateString =  "2020-12-08@06:30:30";
//           SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd@HH:mm:ss");
       String dateString =  "2020-12-08@06:31:30";
       SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd@HH:mm:ss");
           Date date = null;
           try {
               date = df.parse(dateString);
               System.out.println("date: " + date.toString());
               System.out.println("date: " + date.getDate());
               System.out.println("year: " + date.getYear());
               System.out.println("month: " + date.getMonth());
               System.out.println("hour: " + date.getHours());
               System.out.println("minus: " + date.getMinutes());

           } catch (ParseException e) {
           }
           long epoch = date.getTime();

       System.out.println(epoch);
   }
}
