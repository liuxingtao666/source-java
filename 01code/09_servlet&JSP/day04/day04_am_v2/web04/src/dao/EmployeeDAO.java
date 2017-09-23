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
			//����־
			e.printStackTrace();
			//����ϵͳ�쳣��Ӧ��Ҫ��ʾ�û��Ժ�����,
			//��ֻ��һ�������ֻ࣬��Ҫ�׳����쳣���ɣ�
			throw e;
		}finally{
			//�ر�connection�����Ӧ��
			//statement���Զ��رգ�statement
			//��Ӧ��resultSetҲ���Զ��رա�
			//���ԣ�һ������£�ֻ��Ҫ�ر�connection
			//���ɡ�����,���ʹ�������ݿ����ӳأ�
			//�����ӳ��õ������ӣ���ʹ����֮��
			//�����������Ĺرգ����ԣ���Ӧ��statement,
			//resultSetҲ����رա�
			//�Ƚ��Ͻ���д��:Ӧ����ö��رա�
			DBUtil.close(conn);
		}
		return employees;
	}
}
