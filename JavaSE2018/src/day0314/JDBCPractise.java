package day0314;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPractise {

	private static Connection conn = null;
	
	private static ResultSet rs = null;
	
	public static void main(String[] args){
		
		try {
			
			conn = MysqlConnectorService.getConnection();
			
			rs = conn.prepareStatement("select * from item",
					ResultSet.CONCUR_UPDATABLE,
					ResultSet.TYPE_SCROLL_INSENSITIVE).
					executeQuery();
			
			while(rs.next()){
				
				System.out.println(rs.getInt(1));
			}
			
			PreparedStatement pst = conn.prepareStatement("select * from img where IMG_ID = 1");
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				
				Blob blob = rs.getBlob(3);
				
				System.out.println(blob.getBytes(1L, (int)blob.length()));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
