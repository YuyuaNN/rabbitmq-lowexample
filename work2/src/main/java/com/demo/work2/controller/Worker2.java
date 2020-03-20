package com.demo.work2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Worker2 {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! Worker2";
    }

}