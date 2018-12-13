package com.springboot2.important.config;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public class MyWebDataBinder {

    @InitBinder
    protected void initBinder(WebDataBinder binder){

        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
