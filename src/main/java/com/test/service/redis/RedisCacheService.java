package com.test.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisCacheService implements CacheService {
    private final ValueOperations<String, String> ops;

    @Autowired
    public RedisCacheService(StringRedisTemplate redisTemplate) {
        this.ops = redisTemplate.opsForValue();
    }

    @Override
    public void set(String key, String val) {
        ops.set(key, val);
    }

    @Override
    public void set(String key, String val, Long time, TimeUnit timeUnit) {
        ops.set(key, val, time, timeUnit);
    }

    @Override
    public String get(String key) {
        return ops.get(key);
    }

    @Override
    public boolean has(String key) {
        return get(key) != null;
    }

    @Override
    public void delete(String key) {
        ops.getOperations().delete(key);
    }
}
