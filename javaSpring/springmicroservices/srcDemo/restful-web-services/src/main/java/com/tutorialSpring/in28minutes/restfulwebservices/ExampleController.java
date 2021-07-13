package com.tutorialSpring.in28minutes.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @GetMapping(path = "/hello")
    public HelloWorldBean hello() {
        HelloWorldBean bean = new HelloWorldBean("Hello world");

        return bean;
    }

    @GetMapping(path = "hello/path-variable/{name}")
    public HelloWorldBean helloBean(@PathVariable String name) {
        HelloWorldBean bean = new HelloWorldBean(name);

        return bean;
    }
}
