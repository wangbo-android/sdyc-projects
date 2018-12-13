package day0322;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class ASocketTransferInfo {

	private static Charset charset = Charset.forName("utf-8");
	
	private static CharsetDecoder decoder = charset.newDecoder();
	
	public static void main(String[] args) {
		
		transferWithAy();
	}
	
	private static void transferWithAy(){
		
		try {
			
			Selector sele = Selector.open();
			
			ServerSocketChannel ssc = ServerSocketChannel.open();
			
			InetSocketAddress address = new InetSocketAddress("127.0.0.1", 30000);
			
			ssc.bind(address);
			
			ssc.register(sele, SelectionKey.OP_ACCEPT);
			
			while(sele.select() > 0){
				
				for(SelectionKey sKey : sele.selectedKeys()){
					
					sele.selectedKeys().remove(sKey);
					
					if(sKey.isAcceptable()){
						
						SocketChannel sc = ssc.accept();
						
						sc.configureBlocking(false);
						
						sc.register(sele, SelectionKey.OP_READ);
						
						sKey.interestOps(SelectionKey.OP_ACCEPT);
						
					}else if(sKey.isReadable()){
						
						SocketChannel sc = (SocketChannel)sKey.channel();
						
						ByteBuffer bbuff = ByteBuffer.allocate(1024);
						
						String content = "";
						
						while(sc.read(bbuff) > 0){
							
							bbuff.flip();
							
							content += decoder.decode(bbuff);
							
							bbuff.clear();
						}
						
						System.out.println(content);
						
						sKey.interestOps(SelectionKey.OP_READ);
					}
				}
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
