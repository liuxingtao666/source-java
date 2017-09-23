package dao;

import java.util.List;

import org.junit.Test;

import entity.Employee;

public class EmployeeDAOTest {

	@Test
	public void testSave() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();
		for(int i=0;i<24;i++){
			Employee e = new Employee();
			e.setName("emp00" + (i + 1));
			e.setSalary(1000);
			e.setAge(22);
			dao.save(e);
		}
	}
	
	@Test
	public void testFindByPages() throws Exception{
		EmployeeDAO dao = new EmployeeDAO();
		List<Employee> employees = 
			dao.findByPages(2, 5);
		System.out.println(employees);
	}
	
	@Test
	public void testGetTotalPages() throws Exception{
		EmployeeDAO dao = new EmployeeDAO();
		System.out.println(dao.getTotalPages(5));
	}

}
