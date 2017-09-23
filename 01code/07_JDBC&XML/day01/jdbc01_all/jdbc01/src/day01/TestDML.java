package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDML {

	/**
	 * ����ִ��DML���
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
			//ִ��INSERT���,��ʾSQL��Ҫ������;
			String sql = "insert into emp " +
			"(empno,ename,job,sal,deptno) " +
			"values (1011,'Larry','CEO',10000,30)";
			//��ȡStatement,ִ��DML���
			Statement stat = 
					con.createStatement();
			stat.executeUpdate(sql);
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
