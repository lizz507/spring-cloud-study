package com.study.spring.cloud.service.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceDemoApplication.class,args);
    }
}
