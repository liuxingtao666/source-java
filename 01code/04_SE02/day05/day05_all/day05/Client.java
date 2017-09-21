package day05;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * �ͻ���Ӧ�ó���
 * @author Administrator
 *
 */
public class Client {
	//�����ڿͻ��˵�Socket
	private Socket socket;
	
	public Client(){
		try {
			//��ʼ��Socket
			/*
			 * ��ʼ����Ҫ������������
			 * 1:�����IP��ַ
			 * 2:����˵Ķ˿ں�
			 * ʵ����Socket�Ĺ��̾��Ƿ������ӵ�
			 * ���̡�
			 */
			socket = new Socket(
						"localhost",8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * �ͻ��������˽����ķ���
	 */
	public void start(){
		try {
			/*
			 * �����̣߳�������ȡ����������
			 * ��������Ϣ
			 */
			Runnable handler
				= new GetServerMessageHandler();
			Thread t = new Thread(handler);
			t.start();
			
			/*
			 * ͨ��Socket��ȡ�����
			 * ����������� ������Ϣ
			 */
			OutputStream out
				= socket.getOutputStream();
			
			//���ֽ���תΪ�ַ���,Ŀ���������ַ���
			OutputStreamWriter osw
				= new OutputStreamWriter(
					out,"utf-8");
			
			//���ַ���תΪ�����ַ��������԰������
			PrintWriter pw
				= new PrintWriter(osw,true);
			
			/*
			 * ����Scanner���ڶ�ȡ�û��Ӽ��������
			 * ����
			 */
			Scanner scanner 
				= new Scanner(System.in);
			//ѭ������
			while(true){
				//�Ӽ��̶�ȡһ���ַ���
				String message = scanner.nextLine();
				//�����ַ������͸�������
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
	
	/**
	 * ���ڽ��շ��������͹�������Ϣ���߳�
	 * @author Administrator
	 *
	 */
	class GetServerMessageHandler
				implements Runnable{
		public void run(){
			try {
				
				InputStream in 
					= socket
					  .getInputStream();
				InputStreamReader isr
					= new InputStreamReader(
						in,"utf-8"
					);
				BufferedReader br
					= new BufferedReader(isr);
				
				String message = null;
				while((message = br.readLine())!=null){
					System.out.println(message);
				}
				
			} catch (Exception e) {
				
			}
		}
	}
	
}







