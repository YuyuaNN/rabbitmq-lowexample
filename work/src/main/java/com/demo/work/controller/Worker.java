package com.demo.work.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Worker {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! Worker";
    }

}