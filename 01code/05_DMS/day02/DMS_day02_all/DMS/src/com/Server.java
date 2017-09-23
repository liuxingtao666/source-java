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
 * �����Ӧ�ó���
 * @author Administrator
 *
 */
public class Server {
	//����˵�Socket
	private ServerSocket server;
	
	//��Ϣ����
	private LinkedBlockingDeque<String> messageQueue;
	
	//������пͻ���������ļ���
	private List<PrintWriter> allOut;
	
	//�̳߳�
	ExecutorService threadPool;
	
	/**
	 * ���췽�������ڳ�ʼ������
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
	 * ��ʼ�������Ĺ���
	 */
	public void start(){
		try {
			
			/*
			 * ˼·:
			 * 1:����ת����Ϣ���߳�,�����ػ��߳�
			 * 2:���տͻ��˵�����
			 *   2.1:ѭ�����²���
			 *   2.2:����accept�����ȴ��ͻ�������    
			 *   2.3:һ���ͻ��������ˣ�������һ����
			 *       �ÿͻ��˽������̣߳������ÿͻ���
			 *       ��Socket���롣
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
				System.out.println("�ȴ��ͻ�������");
				//2.2
				Socket socket
					= server.accept();
				System.out.println("�ͻ���������");
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
	 * ����������������빲������
	 * @param out
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
	 * ����������Ϣת�������пͻ���
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
	 * ���̵߳������ǽ��ո����Ŀͻ��˵���Ϣ
	 * �����������Ϣ���С�
	 * @author Administrator
	 *
	 */
	class GetClientMessageHandler 
				  implements Runnable{
		//���̴߳���Ŀͻ��˵�Socket
		private Socket socket;
		
		public GetClientMessageHandler(
							Socket socket){
			this.socket = socket;
		}
		
		public void run() {
			/*
			 * ˼·:
			 * 1:������ͻ��˵���������빲����
			 *  1.1:ͨ��socket��ȡ�����
			 *  1.2:���ֽ���ת��Ϊ�ַ������ 
			 *      Ŀ���������ַ���
			 *  1.3:���ַ���ת��Ϊ�����ַ������
			 *  
			 * 2:���տͻ��˷��͹�������Ϣ��������Ϣ����
			 *  2.1:ͨ��socket��ȡ������
			 *  2.2:���ֽ�������ת��Ϊ�ַ�������
			 *  2.3:���ַ�������ת��Ϊ�����ַ�������
			 *  2.4:ѭ�����²���
			 *  2.5:��ȡ�ͻ��˷��͹�����һ���ַ���
			 *  2.6:�����ַ���������Ϣ����
			 *  
			 * finally��Ҫ���ÿͻ��˵�Socket�ر�
			 *        ���ӹ������н��ÿͻ��˵������ɾ��          
			 */
			//�ȶ��������������finally��Ҳ�ܿ���
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
					//��������ӹ�����ɾ��
					removeOut(pw);
					
					//���ÿͻ��˵�Socket�ر�
					socket.close();
				} catch (IOException e) {
				}
				
			}
		}
		
		
	}
	
	/**
	 * ���̵߳������������ԵĴ���Ϣ������
	 * ȡ����Ϣ��ת�������пͻ���
	 * �㲥
	 * @author Administrator
	 *
	 */
	class SendMessageHandler 
				  implements Runnable{

		public void run() {
			/*
			 * ˼·:
			 * 1:ѭ�����²���
			 * 2:�ж���Ϣ�������Ƿ�����Ϣ
			 *   2.1:������Ϣ,�ͽ���Ϣ����д���ļ�
			 *   2.2:��û����Ϣ�ˣ�����Ϣ100ms
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
							//���ļ�ĩβ׷��д����
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






