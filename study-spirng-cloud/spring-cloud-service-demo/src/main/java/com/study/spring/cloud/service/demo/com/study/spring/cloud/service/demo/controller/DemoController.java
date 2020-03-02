package com.study.spring.cloud.service.demo.com.study.spring.cloud.service.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class DemoController {

    private static AtomicInteger hitCount = new AtomicInteger();

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/demo/hit",method = RequestMethod.GET)
    public String hitService(String name){
        return String.format("%s hit %d  port is %s",name,hitCount.getAndIncrement(),port);
    }
}
