package com.test.controller;

import com.test.model.request.RedisRequest;
import com.test.service.redis.CacheService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    private final CacheService cacheService;

    public RedisController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @RequestMapping(value = "/redis", method = RequestMethod.POST)
    public String setValue(@RequestBody RedisRequest redisRequest){
        System.out.println(redisRequest);
        cacheService.set("Key-Redis",redisRequest.toString());
        return "OK";
    }

    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public String getValue(){
        return cacheService.get("Key-Redis");
    }
}
