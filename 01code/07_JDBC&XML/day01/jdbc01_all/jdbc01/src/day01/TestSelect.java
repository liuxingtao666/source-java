package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {

	/**
	 * ���������ݿ������
	 * Ŀ��IP: 192.168.0.23  
	 * SID: tarena10g
	 * �û��������� jsd1402  jsd1402
	 * @param args
	 */
	public static void main(String[] args) {
		Connection con = null;
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
			con = DriverManager.getConnection(
					url,"jsd1402","jsd1402");
			//ִ��select���
			String sql = 
				"select empno,ename,sal " +
				"from emp " +
				"order by sal";
			//��ȡStatement
			Statement stat = 
				con.createStatement();
			//ִ��select����ȡ��ѯ���
			ResultSet rs = 
				stat.executeQuery(sql);
			//����rs�������
			while(rs.next()){
				int empno = 
					rs.getInt("empno");
				String ename = 
					rs.getString("ename");
				double sal = 
					rs.getDouble("sal");
				System.out.println(empno+" "+ename+" "+sal);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try {
				con.close();//�ͷ�������Դ
			} catch (SQLException e) {
			}
		}

	}

}
