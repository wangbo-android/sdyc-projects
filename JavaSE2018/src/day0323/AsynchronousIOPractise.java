package day0323;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchronousIOPractise {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		try {
			
			AsynchronousServerSocketChannel serverSocketChannel = 
					AsynchronousServerSocketChannel.open();
			
			serverSocketChannel.bind(new InetSocketAddress(30000));
			
			while(true){
				
				Future<AsynchronousSocketChannel> future = serverSocketChannel.accept();
				
				AsynchronousSocketChannel channel = future.get();
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
