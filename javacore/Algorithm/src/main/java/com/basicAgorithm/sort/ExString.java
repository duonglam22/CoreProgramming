/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basicAgorithm.sort;

/**
 *
 * @author MSI
 */
public class ExString {
    
   public static void main(String args[]){

       String text = "+c63UC5MMa1lo9Ed8kYhRA==bctodayxyz";
       String first = "+c63U+C5MMa1lo9Ed8kYhRA==+";
       String second = "xyz";
       try {
           text = text.replaceAll(first, second);

           System.out.println(text);
       }
       catch (Exception ex) {
           System.out.println(ex.toString());
       }

   }
}
