package day05;

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
}







