package chapter4;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Chapter4Basic1 {

    public static void main(String[] args){

        System.out.println(new Date().toString());

        GregorianCalendar gc = new GregorianCalendar(2018,GregorianCalendar.DECEMBER,30);

        System.out.println(gc.toString());

        gc = new GregorianCalendar();

        System.out.println(gc.get(Calendar.MONTH));

        gc = null;
    }


}
