package dao;

import java.util.List;

import org.junit.Test;

import entity.Employee;

public class EmployeeDAOTest {

	@Test
	public void testFindAll() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = 
			dao.findAll();
		System.out.println(employees);
	}

}
