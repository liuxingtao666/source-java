package day01;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	/**
	 * ���������ݿ������
	 * Ŀ��IP: 192.168.0.23  
	 * SID: tarena10g
	 * �û��������� jsd1402  jsd1402
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//��ojdbc6.jar��Դ�����������
			//ע��������
			Class.forName(
				"oracle.jdbc.OracleDriver");
			//��дһ�������ַ���
			//jdbc:oracle:thin:@IP:1521:SID
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			//��ȡConnection����
			//getConnection(�����ַ���,�û���,����)
			Connection con = 
				DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			System.out.println(con);
			con.close();//�ͷ�������Դ
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
