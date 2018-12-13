package com.springboot2.important.btFormat;

import org.apache.commons.lang3.StringEscapeUtils;
import org.beetl.core.Format;

public class XXSDefenderFormat implements Format{

    @Override
    public Object format(Object o, String s) {

        if(o instanceof String){

            String js = (String) o;
            String str = StringEscapeUtils.escapeHtml4(js);

            return str;
        }else {

            return o;
        }
    }
}
