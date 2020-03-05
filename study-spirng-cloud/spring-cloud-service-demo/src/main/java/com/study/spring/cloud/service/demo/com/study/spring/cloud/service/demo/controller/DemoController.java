package com.study.spring.cloud.service.demo.com.study.spring.cloud.service.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RefreshScope
@RestController
public class DemoController {

    private static AtomicInteger hitCount = new AtomicInteger();

    @Value("${server.port}")
    private String port;

    @Value("${form}")
    String form;

    @RequestMapping(value = "/demo/hit",method = RequestMethod.GET)
    public String hitService(String name){
        return String.format("get method %s hit %d  port is %s form is %s",name,hitCount.getAndIncrement(),port,form);
    }

    @RequestMapping(value = "/demo/hit",method = RequestMethod.POST)
    public String hit(@RequestBody String name){
        return String.format("post method %s hit %d  port is %s form is %s",name,hitCount.getAndIncrement(),port,form);
    }
}
