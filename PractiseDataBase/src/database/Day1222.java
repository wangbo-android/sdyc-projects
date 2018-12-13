package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Day1222 {
	
	private static Connection conn;
	
	private static PreparedStatement ps;
	
	private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException {
		
		conn = DataConnectionUtil.getConnection();
		
		ps = conn.prepareStatement("select * from item",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		
		rs = ps.executeQuery();
		
		rs.last();
		
		int rowNumber = rs.getRow();
		
		for(int i = rowNumber;i > 0;i--){
			
			rs.absolute(i);
			
			System.out.println(rs.getString(3));
			
			//rs.updateString(3, "nihao");
			
			//rs.updateRow();
			
			
		}
	}

}
