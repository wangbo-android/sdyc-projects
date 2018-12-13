package com.rest.config;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestConfig implements RestTemplateCustomizer{

    @Override
    public void customize(RestTemplate restTemplate) {

        SimpleClientHttpRequestFactory jdkHttp =
                (SimpleClientHttpRequestFactory) restTemplate.getRequestFactory();

        jdkHttp.setConnectTimeout(1000);
    }
}
