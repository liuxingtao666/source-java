package com.tarena.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.entity.Cost;
import com.tarena.util.DBUtil;

public class CostDaoImpl implements ICostDao {

	public List<Cost> findAll() 
		throws DaoException {
		//ʵ�������ڷ�װ�ʷ����ݵļ���
		List<Cost> list = 
			new ArrayList<Cost>();
		//��ȡ���ݿ����� 
		Connection con = DBUtil.getConnection();
		//�����ѯ��sql
		String sql = "select * from cost";
		try {
			//����sqlʵ����PreparedStatement
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//ִ�в�ѯ
			ResultSet rs = ps.executeQuery();
			//���������
			while(rs.next()) {
				//��ÿһ�����ݷ�װ��ʵ�����
				Cost c = createCost(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * �����񵽵��쳣��װ��ͬ�¿���ʶ���
			 * �Զ����쳣��
			 * */
			throw new DaoException(
				"��ѯ�ʷ�����ʧ�ܣ�", e);
		} finally {
			//�ر�����
			DBUtil.close(con);
		}
		return list;
	}

	private Cost createCost(ResultSet rs) 
		throws SQLException {
		Cost c = new Cost();
		c.setId(rs.getInt("id"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("base_duration"));
		c.setBaseCost(rs.getDouble("base_cost"));
		c.setUnitCost(rs.getDouble("unit_cost"));
		c.setStatus(rs.getString("status"));
		c.setDescr(rs.getString("descr"));
		c.setCreateTime(rs.getDate("creatime"));
		c.setStartTime(rs.getDate("startime"));
		c.setCostType(rs.getString("cost_type"));
		return c;
	}
	
	public static void main(String[] args) 
		throws Exception {
		CostDaoImpl dao = new CostDaoImpl();
		List<Cost> list = dao.findAll();
		for(Cost c : list) {
			System.out.println(
				c.getId() + " " +
				c.getName() + " " +
				c.getDescr()
			);
		}
	}

}
