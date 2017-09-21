package day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务端应用程序
 * @author Administrator
 *
 */
public class Server {
	//服务端的Socket
	private ServerSocket server;
	
	//线程池
	private ExecutorService threadPool;
	
	/*
	 * 定义一个集合，用于保存所有客户端的
	 * 输出流，以便广播消息
	 */
	private List<PrintWriter> allOut;
	
	/*
	 * 消息队列，用于存放所有客户端发送给
	 * 服务器的消息。
	 */
	private Queue<String> messageQueue;
	
	
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
			
			/*
			 * 初始化线程池
			 */
			threadPool
				= Executors
				  .newCachedThreadPool();
			
			/*
			 * 初始化共享所有客户端输出流的集合
			 */
			allOut 
				= new ArrayList<PrintWriter>();
			
			
			/*
			 * 初始化消息队列
			 */
			messageQueue 
				= new LinkedList<String>();
			
			
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
			 * 将转发消息的线程启动起来
			 */
			Runnable sendHandler
					= new sendMessageHandler();
			Thread t = new Thread(sendHandler);
			t.setDaemon(true);//守护线程
			t.start();
			/*
			 * ServerSocket的一个很重要方法
			 * Socket accept()
			 * 该方法的作用是开始监听8088端口
			 * 等待客户端的连接，该方法是一个阻塞方法
			 * 直到一个客户端连接为止，该方法才会有返回值
			 * 而返回值则就是连接上的客户端Socket
			 */
			while(true){
				System.out.println("等待客户端连接...");
				Socket socket 
					= server.accept();
				System.out.println("一个客户端连接了!");	
				/*
				 * 当一个客户端连接后，启动一个线程
				 * 将该客户端的Socket传入。
				 * 使用线程来并发处理客户端的交互。
				 */
				Runnable handler
					= new ClientHandler(socket);
				/*
				 * 将任务交给线程池去处理
				 */
				threadPool.execute(handler);
				
//				Thread t = new Thread(handler);
//				t.start();
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 向共享集合中添加新的输出流
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
	 * 将给定的消息发送给所有的客户端
	 * @param message
	 */
	public synchronized void sendMessageToAllClent(
						 String message){
		for(PrintWriter out:allOut){
			out.println(message);
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		//使服务端开始工作
		server.start();
	}
	
	
	class ClientHandler 
				implements Runnable{
		private Socket socket;
		/*
		 * 创建线程时，要连同将该线程负责交互的
		 * 客户端的Socket传入
		 */
		public ClientHandler(
				Socket socket){
			this.socket = socket;
		}	
		public void run() {
			//对应该客户端的输出流
			PrintWriter pw = null;
			try {
				/*
				 * 创建对应该客户端的输出流，并
				 * 存入共享的集合中，以便广播
				 */
				OutputStream out
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(
						out,"utf-8"
					);
				pw = new PrintWriter(osw,true);
				
//				allOut.add(pw);
				//将客户端的输出流放入共享集合
				addOut(pw);
				System.out.println(
					"当前在线人数:"+allOut.size());
				
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
					
				String message = null;	
				//读取客户端发送过来的一行字符串	
				while( (message = br.readLine())!= null){
//					System.out.println(
//						"客户端说:"+message);
					//将信息存入消息队列
					messageQueue.offer(message);
				}
			} catch (Exception e) {
			} finally{
				/*
				 * 当客户端与服务器断开连接后
				 * 不同的操作系统存在差异:
				 * windows:br.readLine()方法会抛出异常
				 * linux:br.readLine()返回值为null
				 * 无论哪种，最后我们都应当将该客户端的连接关闭
				 * 释放资源
				 */
				try {
					System.out.println("一个客户端下线了");
					//将该客户端的输出流从共享集合中删除掉
					removeOut(pw);
					System.out.println(
							"当前在线人数:"+allOut.size());
					
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}	
	
	/**
	 * 该线程用于周期性的从消息队列中取出
	 * 消息转发给所有客户端
	 * @author Administrator
	 *
	 */
	class sendMessageHandler 
				implements Runnable{
		public void run(){
			String message = null;
			while(true){
				//判断队列中是否还有消息
				if(messageQueue.size()>0){
					//从消息队列中取出一个消息
					message 
						= messageQueue.poll();
					//转发
					sendMessageToAllClent(
									message);
				}else{
					/*
					 * 若队列中的消息都转发了
					 * 就休息一会
					 */
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}						
			}			
		}
	}
}





