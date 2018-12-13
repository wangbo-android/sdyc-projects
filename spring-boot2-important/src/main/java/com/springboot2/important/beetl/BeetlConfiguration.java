package com.springboot2.important.beetl;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;

public class BeetlConfiguration {

    public static void main(String[] args){

        StringTemplateResourceLoader stringTemplateResourceLoader = new StringTemplateResourceLoader();

        try {

            Configuration configuration = Configuration.defaultConfiguration();
            GroupTemplate groupTemplate = new GroupTemplate(stringTemplateResourceLoader,configuration);
            Template template = groupTemplate.getTemplate("hello,${name}");
            template.binding("name","wangbo");
            String str = template.render();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
