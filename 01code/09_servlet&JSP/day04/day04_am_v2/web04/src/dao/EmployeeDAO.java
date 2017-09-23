package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBUtil;

import entity.Employee;

public class EmployeeDAO {
	public List<Employee> findAll() throws Exception{
		List<Employee> employees = 
			new ArrayList<Employee>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rst = null;
		try {
			conn = DBUtil.getConnection();
			stat = conn.prepareStatement(
					"select * from t_emp");
			rst = stat.executeQuery();
			while(rst.next()){
				int id = rst.getInt("id");
				String name = rst.getString("name");
				double salary = rst.getDouble("salary");
				int age = rst.getInt("age");
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(salary);
				e.setAge(age);
				employees.add(e);
			}
		} catch (Exception e) {
			//记日志
			e.printStackTrace();
			//属于系统异常，应该要提示用户稍后重试,
			//但只是一个服务类，只需要抛出该异常即可，
			throw e;
		}finally{
			//关闭connection，则对应的
			//statement会自动关闭，statement
			//对应的resultSet也会自动关闭。
			//所以，一般情况下，只需要关闭connection
			//即可。但是,如果使用了数据库连接池，
			//从连接池拿到的连接，在使用完之后，
			//并不会真正的关闭，所以，对应的statement,
			//resultSet也不会关闭。
			//比较严谨的写法:应该最好都关闭。
			DBUtil.close(conn);
		}
		return employees;
	}
}
