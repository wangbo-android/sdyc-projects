package com.springboot2.important.exception;


/**
 * Created by Administrator on 2018/7/11.
 */
public class MyException extends Exception{

    public MyException(){

        super();
    }

    public MyException(String message){

        super(message);
    }

    public MyException(String message,Throwable throwable){

        super(message,throwable);
    }
}
