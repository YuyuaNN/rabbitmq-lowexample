package com.demo.newtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NewTaskApplication {
    public static String[] str;
    public static void main(String[] args) {
        str = args;
        SpringApplication.run(NewTaskApplication.class, args);
    }
}