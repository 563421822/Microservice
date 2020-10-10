package com.qf.java2004.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Show {
    @Value(value = "${server.port}")
    private Integer port;

    @GetMapping("/hij")
    public String show() {
        return "OK了" + port;
    }
}
