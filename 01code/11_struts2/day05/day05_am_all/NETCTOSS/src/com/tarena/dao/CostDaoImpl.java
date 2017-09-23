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
		dao.delete(6);
	}

	public List<Cost> findByPage(
		int page, int pageSize) 
		throws DaoException {
		List<Cost> list = 
			new ArrayList<Cost>();
		Connection con = 
			DBUtil.getConnection();
		String sql = "select * from (" +
				"select c.*,rownum r from cost c" +
				") where r<? and r>?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//С����ҳ��С��
			int nextMin = page*pageSize+1;
			ps.setInt(1, nextMin);
			//������ҳ�����
			int lastMax = (page-1)*pageSize;
			ps.setInt(2, lastMax);
			//ִ�в�ѯ
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
					"��ҳ��ѯʧ�ܣ�", e);
		} finally {
			DBUtil.close(con);
		}
		return list;
	}

	public int findTotalPage(int pageSize) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		String sql = "select count(*) from cost";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				// ��ѯ��������rows
				int rows = rs.getInt(1);
				// ������ҳ��rows/pageSize
				if(rows%pageSize==0) {
					//����������������
					return rows/pageSize;
				} else {
					//��������������+1
					return rows/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ѯ������ʧ�ܣ�", e);
		} finally {
			DBUtil.close(con);
		}
		
		return 0;
	}

	public void delete(int id) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		String sql = "delete from cost " +
				"where id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
					"ɾ���ʷ�����ʧ�ܣ�", e);
		} finally {
			DBUtil.close(con);
		}
	}

}
