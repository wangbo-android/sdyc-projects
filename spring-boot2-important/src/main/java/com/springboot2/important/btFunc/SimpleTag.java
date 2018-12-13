package com.springboot2.important.btFunc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.beetl.core.Tag;

import java.io.IOException;
import java.util.Map;

public class SimpleTag extends Tag{

    private static final Log log = LogFactory.getLog(SimpleTag.class);

    @Override
    public void render() {

        log.info("自定义标签函数");

        String tagName = (String) this.args[0];
        Map attrs = (Map) this.args[1];
        String value = (String) attrs.get("attr");

        try {

            this.ctx.byteWriter.writeString(value);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
