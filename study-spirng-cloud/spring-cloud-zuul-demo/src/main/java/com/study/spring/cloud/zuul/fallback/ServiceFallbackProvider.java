package com.study.spring.cloud.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Component
public class ServiceFallbackProvider implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        //表明是为哪个微服务提供回退，"*"表示全部
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            /**
             * 网关向api服务请求是失败了，但是消费者客户端向网关发起的请求是成功的，
             * 所以不应该把api返回的404，500等问题抛给客户端
             * 网关和api服务集群d对于客户端来说是黑盒子。
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String,Object> map = new HashMap<>();
                map.put("status",200);
                map.put("message","连接失败，请检查网络");
                return new ByteArrayInputStream(objectMapper.writeValueAsString(map).getBytes("UTF-8"));
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
                return httpHeaders;
            }
        };
    }

    public static void main(String[] args) {
        String name  = null;
        System.out.println(Optional.ofNullable(name).orElse("-"));
        List<String> list = new ArrayList<>();
        list.add(Optional.ofNullable(name).orElse("-"));
        for (String s : list) {
            System.out.println(s);
        }
    }
}
