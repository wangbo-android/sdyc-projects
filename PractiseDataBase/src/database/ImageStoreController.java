package database;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ImageStoreController {

	private static Connection conn;
	
	private static PreparedStatement ps;
	
	private static PreparedStatement getImg;
	
	private static ResultSet rs;
	
	private static InputStream is;
	
	static{
		
		try {
			
			conn = DataConnectionUtil.getConnection();
			
			ps = conn.prepareStatement("insert into img values(null,?,?)",Statement.RETURN_GENERATED_KEYS);
			
			is = ImageStoreController.class.getResourceAsStream("conf/111.png");
			
			getImg = conn.prepareStatement("select * from img where IMG_ID = 1");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		
		
		ps.setString(1, "ͼƬ");
		ps.setBinaryStream(2, is,is.available());
		
		int affect = ps.executeUpdate();
		
		//System.out.println(affect);
		
		
		rs = getImg.executeQuery();
		
		while(rs.next()){
			
			Blob imgBlob = rs.getBlob(3);
			
			System.out.println(imgBlob.getBytes(1L, (int)imgBlob.length()));
		}
	}

}
