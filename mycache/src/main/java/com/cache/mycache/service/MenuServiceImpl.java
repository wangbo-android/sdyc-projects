package com.cache.mycache.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "menu")
public class MenuServiceImpl implements MenuService{

    @Override
    @Cacheable()
    public String getMenu(Long id) {

        return "hello world";
    }
}
