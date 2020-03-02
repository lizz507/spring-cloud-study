package com.study.spring.cloud.ribbon.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class RibbonDemoApplication {
    /**
     * @EnableDiscoveryClient 启动发现服务
     * @EnableHystrix   启用服务熔断
     * @EnableHystrixDashboard 启用熔断监控仪表盘
     * 启用方法  http://localhost:8766/hystrix
     * 在输入栏中输入http://localhost:8766/hystrix.stream 进入监控页面
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(RibbonDemoApplication.class,args);
    }
}
