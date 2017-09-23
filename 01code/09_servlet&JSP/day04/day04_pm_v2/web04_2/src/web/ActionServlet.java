package web;

import java.io.IOException;
import java.io.PrintWriter;
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
		//����������Դ·�������ݷ����Ľ����������Ӧ��
		//����
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
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
									"<a href='del?id=" + id 
									+ "'>ɾ��</a>&nbsp;<a href='load?id=" + id + "'>�޸�</a></td></tr>");
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
		}else{
			System.out.println("û��ƥ��Ĵ���...");
		}
	}
}
