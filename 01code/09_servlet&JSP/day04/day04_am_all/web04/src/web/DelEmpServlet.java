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

public class DelEmpServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(
				request.getParameter("id"));
		Connection conn = null;
		PreparedStatement stat = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/jsd1402db",
					"root","1234");
			stat = conn.prepareStatement(
					"delete from t_emp where id=?");
			stat.setInt(1, id);
			stat.executeUpdate();
			//重定向
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
