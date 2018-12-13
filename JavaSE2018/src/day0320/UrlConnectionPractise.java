package day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class UrlConnectionPractise {

	public static void main(String[] args) {
		
		try {
			
			connectURL();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	private static void connectURL() throws IOException{
		
		String urlStr = "http://www.baidu.com";
		
		URL url = new URL(urlStr);
		
		URLConnection conn = url.openConnection();
		
		conn.setRequestProperty("accept", "/");
		
		conn.setRequestProperty("connection", "Keep-Alive");
		
		conn.connect();
		
		Map<String,List<String>> headers = conn.getHeaderFields();
		
		for(String key : headers.keySet()){
			
			System.out.println(key + "----->" + headers.get(key));
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
		
		String buff = null;
		
		String result = "";
		
		while((buff = br.readLine()) != null){
			
			result += buff + "\r\n";
		}
		
		System.out.println(result);
	}

}
