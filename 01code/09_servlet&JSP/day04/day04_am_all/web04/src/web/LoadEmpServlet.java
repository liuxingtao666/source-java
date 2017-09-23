package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoadEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(
				request.getParameter("id"));
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/jsd1402db",
					"root","1234");
			stat = conn.prepareStatement(
					"select * from t_emp where id=?");
			stat.setInt(1, id);
			rst = stat.executeQuery();
			if(rst.next()){
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				int age = rst.getInt("age");
				//���һ����
				out.println("<form action='modify?id=" + id + "' method='post'>");
				out.println("id:" + id + "<br/>");
				out.println("����:<input name='name' value='" 
						+ name + "'/><br/>");
				out.println("нˮ:<input name='salary' value='" 
						+ salary + "'/><br/>");
				out.println("����:<input name='age' value='" 
						+ age + "'/><br/>");
//				out.println("<input type='hidden' name='id' value='" 
//						+ id + "'/>");
				out.println("<input type='submit' value='�ύ'/>");
				out.println("</form>");
			}
		}catch(Exception e){
			e.printStackTrace();
			out.println("ϵͳ��æ���Ժ�����");
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}
}
