package com.springboot2.important.btFunc;

import org.beetl.core.Context;
import org.beetl.core.Function;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MyPrint implements Function{

    @Override
    public Object call(Object[] objects, Context context) {

        for(Object obj : objects){

            if(obj != null){

                if(obj instanceof String){

                    String str = (String) obj;

                    try {

                        context.byteWriter.writeString(str);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{

                    try {

                        context.byteWriter.writeObject(obj);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }else{

                try {
                    context.byteWriter.writeString("参数不存在");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
