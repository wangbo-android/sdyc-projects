package com.springboot2.important.interceptor;

import com.springboot2.important.entity.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionHandlerInterceptor implements HandlerInterceptor{

    private static final Log log = LogFactory.getLog(SessionHandlerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                                HttpServletResponse response,
                                    Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute("user");

        if(user == null){

            response.sendRedirect("/login.html");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request
                , HttpServletResponse response
                    , Object handler
                        , @Nullable ModelAndView modelAndView) throws Exception {

        log.info("执行完controller后执行渲染页面之前");
    }

    @Override
    public void afterCompletion(HttpServletRequest request
                , HttpServletResponse response, Object handler
                    , @Nullable Exception ex) throws Exception {

        log.info("渲染页面完之后调用");
    }
}
