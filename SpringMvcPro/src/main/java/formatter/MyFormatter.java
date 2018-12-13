package formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyFormatter implements Formatter<Date>{

    private String pattern;

    private SimpleDateFormat sdf;

    public MyFormatter(String pattern){

        this.pattern = pattern;

        sdf = new SimpleDateFormat(pattern);
    }

    public Date parse(String s, Locale locale) throws ParseException {

        return sdf.parse(s);
    }

    public String print(Date date, Locale locale) {

        return sdf.format(date);
    }
}
