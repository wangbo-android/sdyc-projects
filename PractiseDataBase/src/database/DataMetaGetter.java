package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DataMetaGetter {
	
	private static Connection conn;
	
	private static PreparedStatement ps;
	
	private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException {
		
		conn = DataConnectionUtil.getConnection();
		
		ps = conn.prepareStatement("select * from item");
		
		rs = ps.executeQuery();
		
		ResultSetMetaData rsmt = rs.getMetaData();
		
		for(int i=0;i<rsmt.getColumnCount();i++){
			
			System.out.println(rsmt.getColumnName(i + 1));
		}
		
	}

}
