package com.study.spring.cloud.ribbon.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonDemoService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallBackHit")
    public String hit(String user){
        return restTemplate.getForObject("http://spring-cloud-service-demo/demo/hit?name=" + user,String.class);
    }

    public String fallBackHit(String user){
        return String.format("user：%s 请求失败，服务降级",user);
    }
}
