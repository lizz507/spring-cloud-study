package com.study.spring.cloud.ribbon.demo.config;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixDashboardConfiguration {


    /**
     * 默认的监控Stream：http://localhost:8766/hystrix.stream
     * 通过下面的Bean可以更改设置：http://localhost:8766/hystrix.stream1
     * 此时，默认的监控Stream仍然可以使用。
     * @return
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream1");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
