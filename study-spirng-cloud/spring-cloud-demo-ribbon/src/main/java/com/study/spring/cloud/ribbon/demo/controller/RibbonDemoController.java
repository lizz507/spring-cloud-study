package com.study.spring.cloud.ribbon.demo.controller;

import com.study.spring.cloud.ribbon.demo.service.RibbonDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonDemoController {

    @Autowired
    private RibbonDemoService ribbonDemoService;


    @RequestMapping(value = "/send/hit",method = RequestMethod.GET)
    public String sendHit(String name){
        return ribbonDemoService.hit(name);
    }
}
