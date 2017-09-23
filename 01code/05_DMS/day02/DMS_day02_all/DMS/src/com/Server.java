package com;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 服务端应用程序
 * @author Administrator
 *
 */
public class Server {
	//服务端的Socket
	private ServerSocket server;
	
	//消息队列
	private LinkedBlockingDeque<String> messageQueue;
	
	//存放所有客户端输出流的集合
	private List<PrintWriter> allOut;
	
	//线程池
	ExecutorService threadPool;
	
	/**
	 * 构造方法，用于初始化属性
	 */
	public Server(){
		try {
			server
				= new ServerSocket(8088);
			messageQueue
				= new LinkedBlockingDeque<String>();
			
			allOut 
				= new ArrayList<PrintWriter>();
			
			threadPool
				= Executors.newCachedThreadPool();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 开始服务器的工作
	 */
	public void start(){
		try {
			
			/*
			 * 思路:
			 * 1:启动转发消息的线程,设置守护线程
			 * 2:接收客户端的连接
			 *   2.1:循环以下操作
			 *   2.2:调用accept方法等待客户端连接    
			 *   2.3:一旦客户端连接了，就启动一个与
			 *       该客户端交互的线程，并将该客户端
			 *       的Socket传入。
			 */
			
			//1
			Runnable sendHandler
				= new SendMessageHandler();
			
			Thread sendThread
				= new Thread(sendHandler);
			
			sendThread.setDaemon(true);
			
			sendThread.start();
			
			
			//2
			//2.1
			while(true){
				System.out.println("等待客户端连接");
				//2.2
				Socket socket
					= server.accept();
				System.out.println("客户端已连接");
				//2.3
				Runnable handler
					= new GetClientMessageHandler(
						socket
					  );
				threadPool.execute(handler);
				
//				Thread t = new Thread(handler);
//				t.start();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将给定的输出流存入共享集合中
	 * @param out
	 */
	public synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	/**
	 * 将给定的输出流从共享集合中删除
	 * @param out
	 */
	public synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	
	/**
	 * 将给定的消息转发给所有客户端
	 * @param message
	 */
	public synchronized void sendMessageToAllClient(String message){		
		for(PrintWriter pw:allOut){
			pw.println(message);
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
	
	/**
	 * 该线程的作用是接收给定的客户端的消息
	 * 并将其存入消息队列。
	 * @author Administrator
	 *
	 */
	class GetClientMessageHandler 
				  implements Runnable{
		//该线程处理的客户端的Socket
		private Socket socket;
		
		public GetClientMessageHandler(
							Socket socket){
			this.socket = socket;
		}
		
		public void run() {
			/*
			 * 思路:
			 * 1:将这个客户端的输出流存入共享集合
			 *  1.1:通过socket获取输出流
			 *  1.2:将字节流转化为字符输出流 
			 *      目的是设置字符集
			 *  1.3:将字符流转化为缓冲字符输出流
			 *  
			 * 2:接收客户端发送过来的消息并存入消息队列
			 *  2.1:通过socket获取输入流
			 *  2.2:将字节输入流转化为字符输入流
			 *  2.3:将字符输入流转化为缓冲字符输入流
			 *  2.4:循环以下操作
			 *  2.5:读取客户端发送过来的一个字符串
			 *  2.6:将该字符串存入消息队列
			 *  
			 * finally中要将该客户端的Socket关闭
			 *        并从共享集合中将该客户端的输出流删除          
			 */
			//先定义输出流，这样finally中也能看到
			PrintWriter pw = null;
			try {
				//1
				//1.1
				OutputStream out
					= socket.getOutputStream();
				//1.2
				OutputStreamWriter osw
					= new OutputStreamWriter(
						out,"utf-8"
					);
				//1.3
				pw = new PrintWriter(osw,true);
				//1.4
				addOut(pw);
				
				//2
				//2.1
				InputStream in
					= socket.getInputStream();
				//2.2
				InputStreamReader isr
					= new InputStreamReader(
						in,"utf-8"
					);
				//2.3
				BufferedReader br
					= new BufferedReader(isr);
				
				//2.4
				String message = null;
				//2.5
				while((message = br.readLine())!= null ){
					//2.6
					messageQueue.offer(message);
				}
				
			} catch (Exception e) {
				
			} finally{
				try {
					//将输出流从共享集合删除
					removeOut(pw);
					
					//将该客户端的Socket关闭
					socket.close();
				} catch (IOException e) {
				}
				
			}
		}
		
		
	}
	
	/**
	 * 该线程的作用是周期性的从消息队列中
	 * 取出消息并转发给所有客户端
	 * 广播
	 * @author Administrator
	 *
	 */
	class SendMessageHandler 
				  implements Runnable{

		public void run() {
			/*
			 * 思路:
			 * 1:循环以下操作
			 * 2:判断消息队列中是否还有消息
			 *   2.1:若有消息,就将信息按行写入文件
			 *   2.2:若没有消息了，则休息100ms
			 */
			PrintWriter pw = null;
			//1
			while(true){
				//2
				if(messageQueue.size()>0){
					//2.1
					String message 
						= messageQueue.poll();
//					sendMessageToAllClient(message);
					try{
						if(pw==null){
							//从文件末尾追加写操作
							FileOutputStream fos
								= new FileOutputStream(
									"server_logrec.txt"
									,
									true
								);
							pw = new PrintWriter(fos);
						}
						pw.println(message);
					}catch(Exception e){
						
					}	
				}else{
					//2.2
					try {
						if(pw!=null){
							pw.close();
							pw = null;
						}
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
	}
	
	
}






