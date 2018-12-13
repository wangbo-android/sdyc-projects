package chapter13;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 * @author wangbo
 */
public class TestProperties {

    private static File file = new File("." + File.separator +
            "pro.properties" + File.separator);

    public static void main(String[] args){

        Properties p = new Properties();
        p.setProperty("姓名","王波");

        try (OutputStream os = new FileOutputStream(file)) {

            if(!file.exists()){

                file.createNewFile();
            }

            p.store(os,"pro");

        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
