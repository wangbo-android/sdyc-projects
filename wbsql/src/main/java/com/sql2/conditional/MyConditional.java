package com.sql2.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MyConditional implements Condition{

    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {

        Resource res = context.getResourceLoader().
                getResource("salt.txt");

        Environment env = context.getEnvironment();

        return res.exists() && env.containsProperty("mobile.encrypt.enable");
    }
}
