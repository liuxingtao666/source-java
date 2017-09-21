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
 * �����Ӧ�ó���
 * @author Administrator
 *
 */
public class Server {
	//����˵�Socket
	private ServerSocket server;
	
	//�̳߳�
	private ExecutorService threadPool;
	
	/*
	 * ����һ�����ϣ����ڱ������пͻ��˵�
	 * ��������Ա�㲥��Ϣ
	 */
	private List<PrintWriter> allOut;
	
	/*
	 * ��Ϣ���У����ڴ�����пͻ��˷��͸�
	 * ����������Ϣ��
	 */
	private Queue<String> messageQueue;
	
	
	public Server(){
		try {
			/*
			 * ��ʼ��ServerSocket
			 * ��Ҫ����һ������ָ������˿ں�
			 * �ͻ��˾��Ǹ�������˿�������
			 * ServerSocket��
			 */
			server 
				= new ServerSocket(8088);
			
			/*
			 * ��ʼ���̳߳�
			 */
			threadPool
				= Executors
				  .newCachedThreadPool();
			
			/*
			 * ��ʼ���������пͻ���������ļ���
			 */
			allOut 
				= new ArrayList<PrintWriter>();
			
			
			/*
			 * ��ʼ����Ϣ����
			 */
			messageQueue 
				= new LinkedList<String>();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��������˵ķ���
	 */
	public void start(){
		try{
			/*
			 * ��ת����Ϣ���߳���������
			 */
			Runnable sendHandler
					= new sendMessageHandler();
			Thread t = new Thread(sendHandler);
			t.setDaemon(true);//�ػ��߳�
			t.start();
			/*
			 * ServerSocket��һ������Ҫ����
			 * Socket accept()
			 * �÷����������ǿ�ʼ����8088�˿�
			 * �ȴ��ͻ��˵����ӣ��÷�����һ����������
			 * ֱ��һ���ͻ�������Ϊֹ���÷����Ż��з���ֵ
			 * ������ֵ����������ϵĿͻ���Socket
			 */
			while(true){
				System.out.println("�ȴ��ͻ�������...");
				Socket socket 
					= server.accept();
				System.out.println("һ���ͻ���������!");	
				/*
				 * ��һ���ͻ������Ӻ�����һ���߳�
				 * ���ÿͻ��˵�Socket���롣
				 * ʹ���߳�����������ͻ��˵Ľ�����
				 */
				Runnable handler
					= new ClientHandler(socket);
				/*
				 * �����񽻸��̳߳�ȥ����
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
	 * ������������µ������
	 */
	public synchronized void addOut(PrintWriter out){
		allOut.add(out);
	}
	/**
	 * ��������������ӹ�������ɾ��
	 * @param out
	 */
	public synchronized void removeOut(PrintWriter out){
		allOut.remove(out);
	}
	/**
	 * ����������Ϣ���͸����еĿͻ���
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
		//ʹ����˿�ʼ����
		server.start();
	}
	
	
	class ClientHandler 
				implements Runnable{
		private Socket socket;
		/*
		 * �����߳�ʱ��Ҫ��ͬ�����̸߳��𽻻���
		 * �ͻ��˵�Socket����
		 */
		public ClientHandler(
				Socket socket){
			this.socket = socket;
		}	
		public void run() {
			//��Ӧ�ÿͻ��˵������
			PrintWriter pw = null;
			try {
				/*
				 * ������Ӧ�ÿͻ��˵����������
				 * ���빲��ļ����У��Ա�㲥
				 */
				OutputStream out
					= socket.getOutputStream();
				OutputStreamWriter osw
					= new OutputStreamWriter(
						out,"utf-8"
					);
				pw = new PrintWriter(osw,true);
				
//				allOut.add(pw);
				//���ͻ��˵���������빲����
				addOut(pw);
				System.out.println(
					"��ǰ��������:"+allOut.size());
				
				/*
				 * Socket��һ����Ҫ����
				 * InputStream getInputStream()
				 * ������ͨ���ÿͻ��˵�Socket��ȡ������
				 * ����ȡ�ͻ��˷��͹�������Ϣ
				 */
				InputStream in
					= socket.getInputStream();
				InputStreamReader isr
					= new InputStreamReader(
						in,"utf-8");
				BufferedReader br
					= new BufferedReader(isr);
					
				String message = null;	
				//��ȡ�ͻ��˷��͹�����һ���ַ���	
				while( (message = br.readLine())!= null){
//					System.out.println(
//						"�ͻ���˵:"+message);
					//����Ϣ������Ϣ����
					messageQueue.offer(message);
				}
			} catch (Exception e) {
			} finally{
				/*
				 * ���ͻ�����������Ͽ����Ӻ�
				 * ��ͬ�Ĳ���ϵͳ���ڲ���:
				 * windows:br.readLine()�������׳��쳣
				 * linux:br.readLine()����ֵΪnull
				 * �������֣�������Ƕ�Ӧ�����ÿͻ��˵����ӹر�
				 * �ͷ���Դ
				 */
				try {
					System.out.println("һ���ͻ���������");
					//���ÿͻ��˵�������ӹ�������ɾ����
					removeOut(pw);
					System.out.println(
							"��ǰ��������:"+allOut.size());
					
					socket.close();
				} catch (IOException e) {
				}
			}
		}
	}	
	
	/**
	 * ���߳����������ԵĴ���Ϣ������ȡ��
	 * ��Ϣת�������пͻ���
	 * @author Administrator
	 *
	 */
	class sendMessageHandler 
				implements Runnable{
		public void run(){
			String message = null;
			while(true){
				//�ж϶������Ƿ�����Ϣ
				if(messageQueue.size()>0){
					//����Ϣ������ȡ��һ����Ϣ
					message 
						= messageQueue.poll();
					//ת��
					sendMessageToAllClent(
									message);
				}else{
					/*
					 * �������е���Ϣ��ת����
					 * ����Ϣһ��
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





