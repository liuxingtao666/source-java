package day05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �����Ӧ�ó���
 * @author Administrator
 *
 */
public class Server {
	//����˵�Socket
	private ServerSocket server;
	
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
			 * ServerSocket��һ������Ҫ����
			 * Socket accept()
			 * �÷����������ǿ�ʼ����8088�˿�
			 * �ȴ��ͻ��˵����ӣ��÷�����һ����������
			 * ֱ��һ���ͻ�������Ϊֹ���÷����Ż��з���ֵ
			 * ������ֵ����������ϵĿͻ���Socket
			 */
			System.out.println("�ȴ��ͻ�������...");
			Socket socket 
				= server.accept();
			System.out.println("һ���ͻ���������!");
			
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
			while(true){
				//��ȡ�ͻ��˷��͹�����һ���ַ���
				String message 
					= br.readLine();
				
				System.out.println(
					"�ͻ���˵:"+message);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Server server = new Server();
		//ʹ����˿�ʼ����
		server.start();
	}
}





