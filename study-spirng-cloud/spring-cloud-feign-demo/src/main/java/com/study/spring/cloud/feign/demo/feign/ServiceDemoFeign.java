package com.study.spring.cloud.feign.demo.feign;

import com.study.spring.cloud.feign.demo.feign.impl.ServiceDemoFeignImpl;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 这里通过注解指定当前接口为feign接口，同时指定了服务不可用时的降级类
 */
@FeignClient(value = "spring-cloud-service-demo",fallback = ServiceDemoFeignImpl.class)
public interface ServiceDemoFeign {


    //这里的请求路径需要和目标服务的请求路径保持一致
    //猜测：通过feign发出的请求eureka服务器会将请求映射到相应的服务上。
    //feign中集成了ribbon，因此自带负载均衡，默认情况下会轮询目标服务。
    @RequestMapping(value = "/demo/hit",method = RequestMethod.GET)
    public String hit(@RequestParam("name") String name);
}
