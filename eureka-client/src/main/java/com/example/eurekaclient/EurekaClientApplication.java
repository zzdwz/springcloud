package com.example.eurekaclient;

import com.example.eurekaclient.vo.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
@RestController
public class EurekaClientApplication {

    @Value("${server.port}")
    private String port;
    @Value("${spring.application.name}")
    private String hostname;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    @GetMapping("/hi")
    public String hi(String name){
        return "你好，" + name + "。我是" + hostname + ",端口是" + port;
    }

    @PostMapping("/hiclass")
    public String hiclass(@RequestBody Person person){
        return "你好，" + person.getName() + "-" + person.getAge() + "。我是" + hostname + ",端口是" + port;
    }

    @PostMapping("/himap")
    public String himap(@RequestBody Map<String, Object> map){
        return "你好，" + map.get("name") + "-" + (String)map.get("age") + "。我是" + hostname + ",端口是" + port;
    }

    @PostMapping("/hiint")
    public String hiint(@RequestBody Integer intValue){
        return "数字:" + intValue;
    }

}
