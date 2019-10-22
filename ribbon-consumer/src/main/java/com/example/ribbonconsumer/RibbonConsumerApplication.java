package com.example.ribbonconsumer;

import com.example.ribbonconsumer.vo.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@EnableHystrix
public class RibbonConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }

    @Autowired
    @Qualifier("ribbonService")
    HelloService helloService;

    @GetMapping("/hello")
    public String hello(String name) {
        String result = helloService.hello(name);
        return result;
    }

    @GetMapping("/hiclass")
    public String hiclass(Person person){
        return helloService.hiclass(person);
    }

    @GetMapping("/himap")
    public String himap(@RequestParam Map<String, Object> map){
        return helloService.himap(map);
    }

    @GetMapping("/hiint")
    public String hiint(Integer intValue){
        return helloService.hiint(intValue);
    }


}
