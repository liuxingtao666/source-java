package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = 
			request.getParameter("name");
		System.out.println("name:" + name);
		String salary = 
			request.getParameter("salary");
		String age = 
			request.getParameter("age");
		/*
		 * ��ȡ���������֮��һ��Ҫ����֤��
		 * ���磬���salary�ǲ���һ���Ϸ������֡�
		 * �˴��ԡ�
		 */
		//��Ա������Ϣ���뵽���ݿ�
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/jsd1402db",
					"root","1234");
			stat = conn.prepareStatement(
					"insert into t_emp(name,salary,age) " +
					"values(?,?,?)");
			stat.setString(1, name);
			stat.setDouble(2, Double.parseDouble(salary));
			stat.setInt(3, Integer.parseInt(age));
			stat.executeUpdate();
			out.println("<h1>����ɹ�</h1>");
		} catch (Exception e) {
			//����־
			e.printStackTrace();
			//�ж��쳣�Ƿ��ܹ��ָ���
			//������ܹ��ָ�(����,���ݿ������ʱ��
			//����,�����жϵȵ�,һ����������쳣��
			//֮Ϊϵͳ�쳣)������ʾ�û��Ժ�����;
			//����ܹ��ָ����������ָ���
			out.println("ϵͳ��æ���Ժ�����");
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
		out.close();
	}
}
