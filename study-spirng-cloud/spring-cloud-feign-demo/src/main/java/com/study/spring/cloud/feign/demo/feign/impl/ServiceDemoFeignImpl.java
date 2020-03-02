package com.study.spring.cloud.feign.demo.feign.impl;

import com.study.spring.cloud.feign.demo.feign.ServiceDemoFeign;
import org.springframework.stereotype.Component;

@Component
public class ServiceDemoFeignImpl implements ServiceDemoFeign {
    @Override
    public String hit(String name) {
        return String.format("%s feign调用失败,服务熔断降级",name);
    }
}
