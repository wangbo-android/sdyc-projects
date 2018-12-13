package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class DataConnectionUtil {

	private static String url;
	
	private static String driver;
	
	private static String username;
	
	private static String password;
	
	private static java.sql.Connection conn;
	
	static{
		
		InputStream is = DataConnectionUtil.class.getResourceAsStream("conf/dataBase.properties");
		
		Properties pro = new Properties();	
		
		try {
			
			pro.load(is);
			
			driver = pro.getProperty("driver");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			url = pro.getProperty("url");
			
			Class.forName(driver);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static final Connection getConnection() throws SQLException{
		
		conn = DriverManager.getConnection(url, username, password);
		
		return conn;
	}
	
	public static final void close(Connection conn) throws SQLException{
		
		if(conn != null){
			
			System.out.println("数据库连接即将关闭");
			conn.close();
		}
		
	}
}
