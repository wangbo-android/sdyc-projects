package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Test {

	private static Connection conn;
	
	private static Statement stm;
	
	private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException {
		
		try {
			
			conn = DataConnectionUtil.getConnection();
			
			stm = conn.createStatement();
			
			rs = stm.executeQuery("select * from item");
			
			while(rs.next()){
				
				System.out.println(rs.getInt(1) + rs.getString(3));
			}
			
			boolean hasResultSet = stm.execute("select * from item");
			
			if(hasResultSet){
				
				rs = stm.getResultSet();
				
				ResultSetMetaData rsmd = rs.getMetaData();
				
				System.out.println("总共有" + rsmd.getColumnCount() + "列");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally{
			
			DataConnectionUtil.close(conn);
		}
	}

}
