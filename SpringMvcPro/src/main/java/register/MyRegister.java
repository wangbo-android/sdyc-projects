package register;

import formatter.MyFormatter;
import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class MyRegister implements FormatterRegistrar{

    private String pattern;

    public MyRegister(String pattern){

        this.pattern = pattern;
    }

    public void registerFormatters(FormatterRegistry formatterRegistry) {

        formatterRegistry.addFormatter(new MyFormatter(pattern));
    }
}
