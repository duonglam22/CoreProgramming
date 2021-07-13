package com.oop;

public class Dog extends Animal {
    @Override
    public void doTask() {
        System.out.println("dog do task");
        sleep();
    }
}
