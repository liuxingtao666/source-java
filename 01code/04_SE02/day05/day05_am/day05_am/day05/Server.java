package day05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端应用程序
 * @author Administrator
 *
 */
public class Server {
	//服务端的Socket
	private ServerSocket server;
	
	public Server(){
		try {
			/*
			 * 初始化ServerSocket
			 * 需要传入一个参数指定服务端口号
			 * 客户端就是根据这个端口连接上
			 * ServerSocket的
			 */
			server 
				= new ServerSocket(8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 启动服务端的方法
	 */
	public void start(){
		try{
			/*
			 * ServerSocket的一个很重要方法
			 * Socket accept()
			 * 该方法的作用是开始监听8088端口
			 * 等待客户端的连接，该方法是一个阻塞方法
			 * 直到一个客户端连接为止，该方法才会有返回值
			 * 而返回值则就是连接上的客户端Socket
			 */
			System.out.println("等待客户端连接...");
			Socket socket 
				= server.accept();
			System.out.println("一个客户端连接了!");
			
			/*
			 * Socket的一个重要方法
			 * InputStream getInputStream()
			 * 服务器通过该客户端的Socket获取输入流
			 * 来读取客户端发送过来的信息
			 */
			InputStream in
				= socket.getInputStream();
			InputStreamReader isr
				= new InputStreamReader(
					in,"utf-8");
			BufferedReader br
				= new BufferedReader(isr);
			while(true){
				//读取客户端发送过来的一行字符串
				String message 
					= br.readLine();
				
				System.out.println(
					"客户端说:"+message);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		//使服务端开始工作
		server.start();
	}
}





