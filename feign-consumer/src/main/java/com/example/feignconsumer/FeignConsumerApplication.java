package com.example.feignconsumer;

import com.example.feignconsumer.feign.HelloFeign;
import com.example.feignconsumer.vo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.example.feignconsumer.feign"})
@RestController
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

    @Autowired
    private HelloFeign helloFeign;

    @GetMapping(value="/hello")
    public String hello(String name) {
        return helloFeign.hi(name);
    }

    @GetMapping(value="/hiclass")
    public String hiclass(Person person) {
        return helloFeign.hiclass(person);
    }

    @GetMapping("/himap")
    public String himap(@RequestParam Map<String, Object> map){
        return helloFeign.himap(map);
    }

    @GetMapping("/hiint")
    public String hiint(Integer intValue){
        return helloFeign.hiint(intValue);
    }


}
