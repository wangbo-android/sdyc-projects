package day0314;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnectorService {

	private static String URL;
	
	private static String USERNAME;
	
	private static String PASSWORD;
	
	private static String DRIVER;
	
	private static Connection conn;
	
	private static InputStream IMGSTREAM;
	
	static{
		
		IMGSTREAM = MysqlConnectorService.class.getResourceAsStream("111.png");
		
		Properties p = new Properties();
		
		try (InputStream is = MysqlConnectorService.class.getResourceAsStream("connection.properties");){
			
			p.load(is);
			
			DRIVER = p.getProperty("driver");
			URL = p.getProperty("url");
			USERNAME = p.getProperty("username");
			PASSWORD = p.getProperty("password");
			
			Class.forName(DRIVER);
			
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
		} catch (IOException | ClassNotFoundException e) {
			
			e.printStackTrace();
			
		} catch(SQLException e){
			
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException{
		
		return conn;
	}
	
	public static InputStream getImgStream(){
		
		return IMGSTREAM;
	}
}
