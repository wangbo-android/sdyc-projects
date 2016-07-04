package com.highlight_spring4.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.highlight_spring4.aop")
@EnableAspectJAutoProxy
public class AopConfig {

}
