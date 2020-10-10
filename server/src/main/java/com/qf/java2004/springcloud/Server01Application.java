package com.qf.java2004.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server01Application {
    public static void main(String[] args) {
        SpringApplication.run(Server01Application.class, args);
        System.out.println("一号服务器启动");
    }
}
