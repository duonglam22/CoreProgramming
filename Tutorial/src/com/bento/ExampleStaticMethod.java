package com.bento;

import java.io.*;

class Geek {

    public static String geekName = "";

    public static void geek(String name)
    {
        geekName = name;
    }
}

class GFG {
    public static void main(String[] args)
    {

        // Accessing the static method geek()
        // and field by class name itself.
        String name = "vaibhav";
        Geek.geek(name);
        System.out.println(Geek.geekName);

        // Accessing the static method geek()
        // by using Object's reference.
        Geek obj = new Geek();
        obj.geek(name);
        System.out.println(obj.geekName);
    }
}

public class ExampleStaticMethod {

}
