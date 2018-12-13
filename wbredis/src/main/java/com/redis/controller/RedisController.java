package com.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RedisController {

    @Autowired
    private RedisTemplate<String,String> rt;

    @GetMapping(path = "/redis-test/{para}")
    public @ResponseBody String env(@PathVariable String para){

        rt.opsForValue().set("testenv",para);
        rt.opsForList().leftPush("platform:message","hello,xiandafu");
        rt.opsForList().leftPush("platform:message","hello,spring boot");

        return rt.opsForValue().get("testenv") +
                rt.opsForValue().get("platform:message");
    }
}
