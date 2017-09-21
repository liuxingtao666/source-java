package day05;

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
	//运行在客户端的Socket
	private Socket socket;
	
	public Client(){
		try {
			//初始化Socket
			/*
			 * 初始化需要传入两个参数
			 * 1:服务端IP地址
			 * 2:服务端的端口号
			 * 实例化Socket的过程就是发起连接的
			 * 过程。
			 */
			socket = new Socket(
						"localhost",8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 客户端与服务端交互的方法
	 */
	public void start(){
		try {
			/*
			 * 通过Socket获取输出流
			 * 可以向服务器 发送信息
			 */
			OutputStream out
				= socket.getOutputStream();
			
			//将字节流转为字符流,目的是设置字符集
			OutputStreamWriter osw
				= new OutputStreamWriter(
					out,"utf-8");
			
			//将字符流转为缓冲字符流，可以按行输出
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			/*
			 * 创建Scanner用于读取用户从键盘输入的
			 * 内容
			 */
			Scanner scanner 
				= new Scanner(System.in);
			//循环操作
			while(true){
				//从键盘读取一个字符串
				String message = scanner.nextLine();
				//将该字符串发送给服务器
				pw.println(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start();
	}
}







