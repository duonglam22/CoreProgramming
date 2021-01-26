package com.lamdn.Gson;

import lombok.Getter;
import lombok.Setter;

public class Employee {

    @Setter @Getter
    private String name;

    @Setter @Getter
    private String gen;

    @Setter @Getter
    private int age;

    @Setter @Getter
    private String position;

    @Setter @Getter
    private String address;

    public Employee(String name, String gen, int age, String position, String address) {
        this.name = name;
        this.gen = gen;
        this.age = age;
        this.position = position;
        this.address = address;
    }
}
