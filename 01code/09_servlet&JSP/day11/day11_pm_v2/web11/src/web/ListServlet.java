package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Employee;

public class ListServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employees = 
			new ArrayList<Employee>();
		for(int i=0;i<8;i++){
			Employee e = new Employee();
			e.setName("emp00" + ( i  + 1));
			e.setGender("m");
			employees.add(e);
		}
		request.setAttribute(
				"employees", employees);
		request.getRequestDispatcher("a7.jsp")
		.forward(request, response);
	}

}
