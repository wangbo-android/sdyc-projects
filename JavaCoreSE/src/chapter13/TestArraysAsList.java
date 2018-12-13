package chapter13;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangbo
 */
public class TestArraysAsList {

    public static void main(String[] args){

        String[] strs = {"王波","李四"};

        List<String> astrs = Arrays.asList(strs);


        for(String str : astrs){

            System.out.println(str);
        }
    }
}
