package com.cache.mycache.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisTemplate;

public class TwoLevelCacheManager extends RedisCacheManager {

    private RedisTemplate redisTemplate;

    @Value("${springext.cache.redis.topic:cache}")
    private String topicName;

    public TwoLevelCacheManager(RedisTemplate redisTemplate,
                                RedisCacheWriter cacheWriter,
                                RedisCacheConfiguration defaultCacheConfiguration){
        super(cacheWriter,defaultCacheConfiguration);
        this.redisTemplate = redisTemplate;
    }

    protected Cache decorateCache(Cache cache){

        return new RedisAndLocalCache((RedisCache) cache,this);
    }

    public void publishMessage(String cacheName){

        this.redisTemplate.convertAndSend(topicName,cacheName);
    }

    public void receiver(String name){

        RedisAndLocalCache cache = (RedisAndLocalCache) this.getCache(name);

        if(cache != null){

            cache.clearLocal();
        }
    }
}
