package com.demo.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkApplication {
    public static String[] str;
    public static void main(String[] args) {
        str = args;
        SpringApplication.run(WorkApplication.class, args);

    }
}
