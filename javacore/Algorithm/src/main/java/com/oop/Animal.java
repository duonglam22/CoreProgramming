package com.oop;

public class Animal {
    public void speak() {
        System.out.println("animal speak");
    }

    public void doTask() {
        System.out.println("animal do some task");
    }

    public void work() {
        doTask();
    }

    public void sleep() {
        System.out.println("animal go sleep");
    }
}
