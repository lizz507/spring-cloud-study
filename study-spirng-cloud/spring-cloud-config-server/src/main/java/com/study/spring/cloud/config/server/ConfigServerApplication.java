package com.study.spring.cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
/**
 * 配置中心：
 * 将配置文件托管在github、gitlab等仓库中，可以动态的更新配置文件
 * 注意：
 *      在地址栏打开配置文件时要遵从以下格式：
 *          /{application}/{profile}[/label]
 *
 *          例：test-client.yml
 *          application: 配置文件的名称 test
 *          profile: 代码的环境 client
 *          label: 分支 默认为master分支
 *          则在地址栏访问时如下：
 *          http://localhost:8888/test/client/master
 */
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}
