package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import entity.Employee;

public class ActionServlet extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 获得请求资源路径
		String uri = request.getRequestURI();
		System.out.println("uri:" + uri);
		// 分析请求资源路径，依据分析的结果来进行相应的
		// 处理。
		String action = uri.substring(uri.lastIndexOf("/"), uri
				.lastIndexOf("."));
		System.out.println("action:" + action);
		if (action.equals("/add")) {
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			/*
			 * 读取完请求参数之后，一定要做验证， 比如，检查salary是不是一个合法的数字。 此处略。
			 */
			// 将员工的信息插入到数据库
			try {
				// 使用dao来插入员工的信息
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				// 记日志
				e.printStackTrace();
				// 判断异常是否能够恢复，
				// 如果不能够恢复(比如,数据库服务暂时不
				// 可用,网络中断等等,一般把这样的异常称
				// 之为系统异常)，则提示用户稍后重试;
				// 如果能够恢复，则立即恢复。
				out.println("系统繁忙，稍后重试");
			}
			out.close();
		} else if (action.equals("/list")) {
			try {
				// 调用dao来访问数据库
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = dao.findAll();
				// 因为servlet不擅长展现数据，所以转发
				// 给jsp来处理。
				//step1,绑订数据到request对象上。
				request.setAttribute("employees", employees);
				//step2,获得转发器
				RequestDispatcher rd = 
					request.getRequestDispatcher("empList.jsp");
				//step3,转发
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		} else if (action.equals("/del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			// 调用dao删除指定id的记录
			EmployeeDAO dao = new EmployeeDAO();
			try {
				dao.delete(id);
				response.sendRedirect("list.do");
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		} else if (action.equals("/load")) {
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = dao.findById(id);
				if (e != null) {
					String name = e.getName();
					double salary = e.getSalary();
					int age = e.getAge();
					// 输出一个表单
					out.println("<form action='modify.do?id=" + id
							+ "' method='post'>");
					out.println("id:" + id + "<br/>");
					out.println("姓名:<input name='name' value='" + name
							+ "'/><br/>");
					out.println("薪水:<input name='salary' value='" + salary
							+ "'/><br/>");
					out.println("年龄:<input name='age' value='" + age
							+ "'/><br/>");
					out.println("<input type='submit' value='提交'/>");
					out.println("</form>");
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("系统繁忙，稍后重试");
			}
		} else if (action.equals("/modify")) {
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDAO dao = new EmployeeDAO();
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
				out.println("系统繁忙，稍后重试");
			}
		}
	}
}
