package com.cache.mycache.config;

import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class RedisAndLocalCache implements Cache {

    private RedisCache redisCache;

    private TwoLevelCacheManager twoLevelCacheManager;

    private ConcurrentHashMap<Object,Object> local = new ConcurrentHashMap<>();

    public RedisAndLocalCache(RedisCache redisCache,TwoLevelCacheManager twoLevelCacheManager){

        this.redisCache = redisCache;
        this.twoLevelCacheManager = twoLevelCacheManager;
    }

    @Override
    public String getName() {

        return redisCache.getName();
    }

    @Override
    public Object getNativeCache() {

        return redisCache.getNativeCache();
    }

    @Override
    public ValueWrapper get(Object key) {

        ValueWrapper wrapper = (ValueWrapper) local.get(key);

        if(wrapper != null){

            return wrapper;
        }else{

            wrapper = redisCache.get(key);

            if(wrapper != null){

                local.put(key,wrapper);
            }
        }

        return wrapper;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        return null;
    }

    @Override
    public <T> T get(Object o, Callable<T> callable) {
        return null;
    }

    @Override
    public void put(Object key, Object value) {

        System.out.println(value.getClass().getClassLoader());

        redisCache.put(key,value);

        clearOtherJVM();
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        return null;
    }

    @Override
    public void evict(Object key) {

        redisCache.evict(key);

        clearOtherJVM();
    }

    @Override
    public void clear() {

    }

    protected void clearOtherJVM(){

        twoLevelCacheManager.publishMessage(redisCache.getName());
    }

    public void clearLocal(){

        this.local.clear();
    }
}
