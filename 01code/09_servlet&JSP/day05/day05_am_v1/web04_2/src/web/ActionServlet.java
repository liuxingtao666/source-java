package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet{
	public void service(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//���������Դ·��
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		//����������Դ·�������ݷ����Ľ����������Ӧ��
		//����
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		System.out.println("action:" + action);
		if(action.equals("/add")){
			String name = 
				request.getParameter("name");
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
				response.sendRedirect("list.do");
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
		}else if(action.equals("/list")){
			try {
				//����dao���������ݿ�
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = 
					dao.findAll();
				//����dao���صĽ��������һ�����
				out.println("<table border='1' width='60%' " +
						"cellpadding='0' cellspacing='0'>");
				out.println("<tr><td>ID</td><td>����</td>" +
						"<td>нˮ</td><td>����</td><td>����</td></tr>");
				for(int i=0;i<employees.size();i++){
					Employee e = employees.get(i);
					int id = e.getId();
					String name = e.getName();
					double salary = e.getSalary();
					int age = e.getAge();
					out.println("<tr><td>" + id + "</td><td>" 
							+ name + "</td><td>" 
							+ salary + "</td><td>" 
							+ age + "</td><td>" +
									"<a href='del.do?id=" + id 
									+ "'>ɾ��</a>&nbsp;<a href='load.do?id=" + id + "'>�޸�</a></td></tr>");
				}
				out.println("</table>");
				out.println("<a href='addEmp.html'>���Ա��</a>");
			}catch(Exception e){
				e.printStackTrace();
				out.println("ϵͳ��æ���Ժ�����");
			}
			//������ִ����service����֮�󣬻����
			//out��close���������ԣ���дout.closeҲ��
			//���Եġ�
			out.close();
		}else if(action.equals("/del")){
			int id = Integer.parseInt(
					request.getParameter("id"));
			//����daoɾ��ָ��id�ļ�¼
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.delete(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("ϵͳ��æ���Ժ�����");
			}
		}else if(action.equals("/load")){
			int id = Integer.parseInt(
					request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = dao.findById(id);
				if(e != null){
					String name = e.getName();
					double salary = e.getSalary();
					int age = e.getAge();
					//���һ����
					out.println("<form action='modify.do?id=" + id + "' method='post'>");
					out.println("id:" + id + "<br/>");
					out.println("����:<input name='name' value='" 
							+ name + "'/><br/>");
					out.println("нˮ:<input name='salary' value='" 
							+ salary + "'/><br/>");
					out.println("����:<input name='age' value='" 
							+ age + "'/><br/>");
					out.println("<input type='submit' value='�ύ'/>");
					out.println("</form>");
				}
			}catch(Exception e){
				e.printStackTrace();
				out.println("ϵͳ��æ���Ժ�����");
			}
		}else if(action.equals("/modify")){
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDAO dao = 
				new EmployeeDAO();
			Employee e = new Employee();
			e.setName(name);
			e.setSalary(Double.parseDouble(salary));
			e.setAge(Integer.parseInt(age));
			e.setId(id);
			try {
				dao.update(e);
				response.sendRedirect("list.do");
			} catch (Exception e1) {
				e1.printStackTrace();
				out.println("ϵͳ��æ���Ժ�����");
			}
		}
	}
}
