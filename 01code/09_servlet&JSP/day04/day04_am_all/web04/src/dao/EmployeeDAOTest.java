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
	
	@Test
	public void testSave() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		Employee e = new Employee();
		e.setName("test1");
		e.setSalary(20000);
		e.setAge(22);
		dao.save(e);
	}

}
