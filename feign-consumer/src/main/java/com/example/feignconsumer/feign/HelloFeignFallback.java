package com.example.feignconsumer.feign;

import com.example.feignconsumer.vo.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class HelloFeignFallback implements  HelloFeign {
    @Override
    public String hi(String name) {
        return "hi 降级";
    }

    @Override
    public String hiclass(Person person) {
        return "hiclass 降级:" + person.toString();
    }

    @Override
    public String himap(Map<String, Object> map) {
        return "himap降级:" + map;
    }

    @Override
    public String hiint(Integer intValue) {
        return "hiint降级：" + intValue;
    }
}
