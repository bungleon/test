package com.test.service.redis;

import java.util.concurrent.TimeUnit;

public interface CacheService {
    void set(String key, String val);

    void set(String key, String val, Long time, TimeUnit timeUnit);

    String get(String key);

    boolean has(String key);

    void delete(String key);
}
