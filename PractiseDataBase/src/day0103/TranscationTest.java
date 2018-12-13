package day0103;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import database.DataConnectionUtil;

public class TranscationTest {

	private static Connection conn;
	
	//private static PreparedStatement pstmt;
	
	//private static ResultSet rs;
	
	public static void main(String[] args) throws SQLException {
		
		conn = DataConnectionUtil.getConnection();
		
		DatabaseMetaData dmd = conn.getMetaData();
		
		ResultSet rs = dmd.getTableTypes();
		
		System.out.println(dmd.getDatabaseProductName() + dmd.getDatabaseProductVersion()
				+ dmd.getDriverName() + dmd.getDriverVersion());
		
		rs = dmd.getTables(null, null, "%", new String[]{"TABLE"});
		
		while(rs.next()){
			
			System.out.println(rs.getString(1));
		}
	}

}
