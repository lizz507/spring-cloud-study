package com.study.spring.cloud.feign.demo.controller;

import com.study.spring.cloud.feign.demo.feign.ServiceDemoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignDemoController {


    @Autowired
    private ServiceDemoFeign serviceDemoFeign;

    @GetMapping("/feign/demo")
    public String feignDemo(String name){
        return serviceDemoFeign.hit(name);
    }
}
