package com.springboot2.important.controller;

import com.springboot2.important.exception.MyException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


@Controller
public class ErrorController extends AbstractErrorController{

    private static final Log log = LogFactory.getLog(ErrorController.class);

    public ErrorController(){
        super(new DefaultErrorAttributes());
    }

    @RequestMapping(value = "/error")
    public String getErrorPath() {



        return "error";
    }

    private boolean isJsonRequest(HttpServletRequest request){

        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

        if(requestUri != null && requestUri.endsWith(".json")){

            return true;
        }else{

            request.getHeader("Accept").contains("application/json");
            return false;
        }
    }

    private String getErrorMessage(Throwable ex){

        if(ex instanceof MyException){

            MyException myException = (MyException) ex;

            return myException.getMessage();
        }

        return "服务器错误，请联系管理员";
    }

    private Throwable getCause(HttpServletRequest request){

        Throwable error = (Throwable) request.getAttribute("javax.servlet.error.exception");

        if(error != null){

            while(error instanceof ServletException && error.getCause() != null){

                error = ((ServletException)error).getCause();
            }
        }

        return error;
    }
}
