package com.bo.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WangboApplication {

	public static void main(String[] args) {

		SpringApplication.run(WangboApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String showIndex(){

		return "Hello Spring Boot";
	}
}
