package com.cache.mycache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MycacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycacheApplication.class, args);
    }
}
