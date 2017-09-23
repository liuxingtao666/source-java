package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

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
		try {
			//ʹ��dao������Ա������Ϣ
			EmployeeDAO dao = new EmployeeDAO();
			Employee e = new Employee();
			e.setName(name);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			dao.save(e);
			out.println("<h1>����ɹ�</h1>");
			//�ض���
			response.sendRedirect("list");
		} catch (Exception e) {
			//����־
			e.printStackTrace();
			//�ж��쳣�Ƿ��ܹ��ָ���
			//������ܹ��ָ�(����,���ݿ������ʱ��
			//����,�����жϵȵ�,һ����������쳣��
			//֮Ϊϵͳ�쳣)������ʾ�û��Ժ�����;
			//����ܹ��ָ����������ָ���
			out.println("ϵͳ��æ���Ժ�����");
		}
		out.close();
	}
}
