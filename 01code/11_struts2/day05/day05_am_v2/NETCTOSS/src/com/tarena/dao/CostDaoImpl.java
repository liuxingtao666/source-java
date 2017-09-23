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
		//实例化用于封装资费数据的集合
		List<Cost> list = 
			new ArrayList<Cost>();
		//获取数据库连接 
		Connection con = DBUtil.getConnection();
		//定义查询的sql
		String sql = "select * from cost";
		try {
			//根据sql实例化PreparedStatement
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//执行查询
			ResultSet rs = ps.executeQuery();
			//遍历结果集
			while(rs.next()) {
				//将每一条数据封装成实体对象
				Cost c = createCost(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			/*
			 * 将捕获到的异常封装成同事可以识别的
			 * 自定义异常。
			 * */
			throw new DaoException(
				"查询资费数据失败！", e);
		} finally {
			//关闭连接
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
			//小于下页最小行
			int nextMin = page*pageSize+1;
			ps.setInt(1, nextMin);
			//大于上页最大行
			int lastMax = (page-1)*pageSize;
			ps.setInt(2, lastMax);
			//执行查询
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Cost c = createCost(rs);
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
					"分页查询失败！", e);
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
				// 查询出总行数rows
				int rows = rs.getInt(1);
				// 计算总页数rows/pageSize
				if(rows%pageSize==0) {
					//整除，返回相除结果
					return rows/pageSize;
				} else {
					//不整除，相除结果+1
					return rows/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"查询总行数失败！", e);
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
					"删除资费数据失败！", e);
		} finally {
			DBUtil.close(con);
		}
	}

}
