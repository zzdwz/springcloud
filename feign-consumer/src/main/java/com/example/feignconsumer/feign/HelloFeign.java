package com.example.feignconsumer.feign;

import com.example.feignconsumer.vo.Person;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Component
@FeignClient(name = "serviceprovide", fallback = HelloFeignFallback.class)
public interface HelloFeign {
    @RequestMapping(value="/hi")
    String hi(@RequestParam("name") String name);

    @RequestMapping(value="/hiclass")
    String hiclass(@RequestBody Person person);

    @RequestMapping(value="/himap")
    String himap(@RequestBody Map<String, Object> map);

    @RequestMapping(value="/hiint")
    String hiint(@RequestBody Integer intValue);

}
