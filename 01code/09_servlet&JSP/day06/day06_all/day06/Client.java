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
 * �ͻ���Ӧ�ó���
 * @author Administrator
 *
 */
public class Client {
	//�����ڿͻ��˵�Socket���������ӷ����
	private Socket socket;
	/**
	 * ���췽�������ڳ�ʼ�����Ե���Ϣ
	 */
	public Client(){
		try {
			//��ʼ��Socket,����������
			socket 
				= new Socket(
					"localhost",8088);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ʼ�ͻ��˹����ķ���
	 */
	public void start(){
		try {
			//�������շ�������Ϣ���߳�
			Runnable handler
				= new GetMessageHandler();
			Thread t = new Thread(handler);
			t.start();
			
			
			//������������Ϣ���߼�
			/*
			 * ˼·:
			 * 1:����Scanner,
			 *   Ŀ���ǻ�ȡ�û����������
			 * 2:ͨ��Socket��ȡ�����
			 * 3:���ֽ������ת��Ϊ�ַ��������
			 *   Ŀ���������ַ���
			 * 4:���ַ������ת��Ϊ�����ַ��������
			 *   Ŀ���ǰ�������ַ��������Ч��
			 * 5:ѭ�����²���  
			 *   ��Scanner��ȡһ���û����������
			 *   ����ͨ�������ַ���������͸�������  
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
	 * ���̵߳������ǲ������������շ���������
	 * ��������Ϣ�������������̨
	 * @author Administrator
	 *
	 */
	class GetMessageHandler 
				   implements Runnable{

		public void run() {
			/*
			 * ˼·:
			 * 1:ͨ��Socket��ȡ�ֽ������� 
			 *   Ŀ�������ڶ�ȡ���������͹�������Ϣ
			 *   
			 * 2:���ֽ���ת��Ϊ�ַ������� 
			 *   Ŀ���������ַ���
			 *   
			 * 3:���ַ���ת��Ϊ�����ַ�������
			 *   Ŀ���ǿ��԰��ж�ȡ�ַ�������߶�ȡЧ��
			 *   
			 * 4:ѭ�����²���
			 *   �ӻ����������ж�ȡһ���ַ���������
			 *   ���������̨.      
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






