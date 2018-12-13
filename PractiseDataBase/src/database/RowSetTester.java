package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class RowSetTester {

	public static void main(String[] args) throws SQLException {
		
		/*
		InputStream is = DataConnectionUtil.class.getResourceAsStream("conf/dataBase.properties");
		
		Properties pro = new Properties();	
		
		try {
			
			pro.load(is);
			
			String driver = pro.getProperty("driver");
			String username = pro.getProperty("username");
			String password = pro.getProperty("password");
			String url = pro.getProperty("url");
			
			Class.forName(driver);
			
			RowSetFactory rsf = RowSetProvider.newFactory();
			
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			
			jrs.setUrl(url);
			jrs.setUsername(username);
			jrs.setPassword(password);
			
			jrs.setCommand("select * from item");
			
			jrs.execute();
			
		} catch (IOException | SQLException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		*/
		
		CachedRowSet rs = RowSetTester.query("select * from item",2,3);
		
		rs.afterLast();
		
		while(rs.previous()){
			
			System.out.println(rs.getString(1) + rs.getString(2) + rs.getString(3));
			
			if(rs.getString(3).equals("nihao")){
				
				rs.updateString(3, "wangbo");
				rs.updateRow();
			}
		}
		
		Connection conn = DataConnectionUtil.getConnection();
		
		conn.setAutoCommit(false);
		
		rs.acceptChanges(conn);
	}

	public static CachedRowSet query(String sql,int page,int pageSize) throws SQLException{
		
		Connection conn = DataConnectionUtil.getConnection();
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from item");
		
		RowSetFactory rsf = RowSetProvider.newFactory();
		
		CachedRowSet crs = rsf.createCachedRowSet();
		
		crs.setPageSize(pageSize);
		
		crs.populate(rs,(page - 1) * pageSize + 1);
		
		DataConnectionUtil.close(conn);
		
		return crs;
	}
}
