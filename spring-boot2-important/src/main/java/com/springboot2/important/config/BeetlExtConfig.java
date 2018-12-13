package com.springboot2.important.config;

import com.springboot2.important.btFunc.MyPrint;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Tag;
import org.beetl.core.TagFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;

@Configuration
public class BeetlExtConfig {

    @Autowired
    private GroupTemplate groupTemplate;

    @Autowired
    private MyPrint myPrint;

    @PostConstruct
    public void config(){

        groupTemplate.registerFunction("io.myPrint",myPrint);
//        groupTemplate.registerTagFactory("myVarTag", new TagFactory() {
//            @Override
//            public Tag createTag() {
//
//                return application
//            }
//        });
    }
}
