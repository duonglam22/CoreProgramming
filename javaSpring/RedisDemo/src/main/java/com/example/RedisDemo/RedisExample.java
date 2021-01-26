package com.example.RedisDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisExample implements CommandLineRunner {

    @Autowired
    private RedisTemplate template;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("redis example run");
        template.opsForValue().set("loda", "hello redis from loda tutorial");
//        template.opsForHash().put();

        System.out.println("value of key loda: " + template.opsForValue().get("loda"));
    }
}
