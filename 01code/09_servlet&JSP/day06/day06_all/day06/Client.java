package day06;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端应用程序
 * @author Administrator
 *
 */
public class Client {
	//运行在客户端的Socket，用于连接服务端
	private Socket socket;
	/**
	 * 构造方法，用于初始化属性等信息
	 */
	public Client(){
		try {
			//初始化Socket,创建即连接
			socket 
				= new Socket(
					"localhost",8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 开始客户端工作的方法
	 */
	public void start(){
		try {
			//启动接收服务器消息的线程
			Runnable handler
				= new GetMessageHandler();
			Thread t = new Thread(handler);
			t.start();
			
			
			//给服务器发消息的逻辑
			/*
			 * 思路:
			 * 1:创建Scanner,
			 *   目的是获取用户输入的内容
			 * 2:通过Socket获取输出流
			 * 3:将字节输出流转化为字符输出流，
			 *   目的是设置字符集
			 * 4:将字符输出流转化为缓冲字符输出流，
			 *   目的是按行输出字符串，提高效率
			 * 5:循环以下操作  
			 *   从Scanner获取一行用户输入的内容
			 *   将其通过缓冲字符输出流发送给服务器  
			 */
			//1
			Scanner scanner 
				= new Scanner(System.in);
			
			//2
			OutputStream out
				= socket.getOutputStream();
			
			//3
			OutputStreamWriter osw
				= new OutputStreamWriter(
					out,"utf-8"
				);
			
			//4
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			//5
			while(true){
				pw.println(
				  scanner.nextLine());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
	
	/**
	 * 该线程的作用是并发运行来接收服务器发送
	 * 过来的信息，并输出到控制台
	 * @author Administrator
	 *
	 */
	class GetMessageHandler 
				   implements Runnable{

		public void run() {
			/*
			 * 思路:
			 * 1:通过Socket获取字节输入流 
			 *   目的是用于读取服务器发送过来的信息
			 *   
			 * 2:将字节流转换为字符输入流 
			 *   目的是设置字符集
			 *   
			 * 3:将字符流转化为缓冲字符输入流
			 *   目的是可以按行读取字符串，提高读取效率
			 *   
			 * 4:循环以下操作
			 *   从缓冲输入流中读取一个字符串，将其
			 *   输出到控制台.      
			 */
			try {
				//1
				InputStream in
					= socket.getInputStream();
				
				//2
				InputStreamReader isr
					= new InputStreamReader(
						in,"utf-8"
					);
				
				//3
				BufferedReader br
					= new BufferedReader(isr);
				
				String message = null;
				
				//4
				while( (message = br.readLine()) !=null ){
					System.out.println(message);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	
}






