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

public class ModifyEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(
				request.getParameter("id"));
		String name = request.getParameter("name");
		String salary = request.getParameter("salary");
		String age = request.getParameter("age");
		//检查请求参数值，暂时不写。
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/jsd1402db",
					"root","1234");
			stat = conn.prepareStatement(
					"update t_emp set name=?,salary=?," +
					"age=? where id=?");
			stat.setString(1, name);
			stat.setDouble(2, Double.parseDouble(salary));
			stat.setInt(3, Integer.parseInt(age));
			stat.setInt(4, id);
			stat.executeUpdate();
			response.sendRedirect("list");
		}catch(Exception e){
			e.printStackTrace();
			out.println("系统繁忙，稍后重试");
		}finally{
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
