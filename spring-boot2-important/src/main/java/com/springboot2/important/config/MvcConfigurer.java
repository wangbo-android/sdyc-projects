package com.springboot2.important.config;

import com.springboot2.important.interceptor.SessionHandlerInterceptor;
import org.beetl.ext.simulate.WebSimulate;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class MvcConfigurer implements WebMvcConfigurer{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**").allowedOrigins("http://domain2.com").allowedMethods("POST","GET");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {

        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/error").setViewName("/error.html");
    }

    @Bean(name = "websimulate")
    public WebSimulate getWebSimulate(BeetlSpringViewResolver resolver){

        WebSimulate webSimulate = new WebSimulate(resolver.getConfig().getGroupTemplate()){

            public String getValuePath(HttpServletRequest request){
                return this.removePreffix( request.getServletPath());
            }


            protected String getRenderPath(HttpServletRequest request)
            {
                return this.removePreffix( request.getServletPath());
            }

            private String removePreffix(String path){
                return path.replaceFirst("/simulate", "");
            }
        };
        return webSimulate;
    }
}
