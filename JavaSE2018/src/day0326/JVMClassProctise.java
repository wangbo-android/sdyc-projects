package day0326;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

public class JVMClassProctise {

	public static void main(String[] args) throws MalformedURLException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		URL[] urls = {new URL("file:mysql-connector-5.1.30-bin.jar")};
		
		URLClassLoader ucl = new URLClassLoader(urls);
		
		Driver driver = (Driver)ucl.loadClass("com.mysql.jdbc.Driver").newInstance();
		
		Properties pro = new Properties();
		
		pro.setProperty("user", "root");
		
		pro.setProperty("password", "123");
		
		Connection conn = driver.connect("", pro);
	}

}
