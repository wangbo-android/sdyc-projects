package converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConverter implements Converter<String,Date>{

    private String pattern;

    public MyConverter(String pattern){

        this.pattern = pattern;
    }

    public Date convert(String s) {

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);

        try {

            return sdf.parse(s);

        } catch (ParseException e) {

            e.printStackTrace();

            throw new IllegalArgumentException("invalid date format");
        }
    }
}
