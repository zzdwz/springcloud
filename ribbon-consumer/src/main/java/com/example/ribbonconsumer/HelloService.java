package com.example.ribbonconsumer;

import com.example.ribbonconsumer.vo.Person;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service("ribbonService")
public class HelloService {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private RestTemplate restTemplate;

    public String hello(String name) {
        String result = restTemplate.getForObject("http://serviceprovide/hi?name=" + name, String.class);
        return result;
    }

    @HystrixCommand(fallbackMethod = "hiclassError")  //指定的 备用方法 和 原方法 的参数要一致
    public String hiclass(Person person){
        return restTemplate.postForObject("http://serviceprovide/hiclass", person, String.class);
    }

    @HystrixCommand(fallbackMethod = "himapError")    //指定的 备用方法 和 原方法 的参数要一致
    public String himap(Map<String, Object> map){
        return restTemplate.postForObject("http://serviceprovide/himap", map, String.class);
    }

    @HystrixCommand(fallbackMethod = "hiintError")    //指定的 备用方法 和 原方法 的参数要一致
    public String hiint(Integer intValue){
        return restTemplate.postForObject("http://serviceprovide/hiint", intValue, String.class);
    }

    public String hiclassError(Person person){
        return "Sorry Hystrix is working:" + person.toString();
    }

    public String himapError(Map<String, Object> map){
        return "Sorry Hystrix is working:" + map.toString();
    }

    public String hiintError(Integer intValue){
        return "Sorry Hystrix is working:" + intValue;
    }
}
