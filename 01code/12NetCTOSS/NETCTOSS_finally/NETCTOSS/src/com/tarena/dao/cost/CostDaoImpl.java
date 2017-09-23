package com.tarena.dao.cost;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.Result;
import com.tarena.dao.DAOException;
import com.tarena.entity.Cost;
import com.tarena.util.DBUtil;

public class CostDaoImpl implements ICostDao {

	private String findAllSql = "select ID,NAME,BASE_DURATION,BASE_COST,UNIT_COST,STATUS,DESCR,CREATIME,STARTIME,COST_TYPE from cost";

	private String findTotalPageSql = "select count(*) from COST";

	private String deleteSql = "delete from COST where id=?";

	private final static String updateSQL = "update COST set NAME=?,BASE_DURATION=?,BASE_COST=?,UNIT_COST=?,"
			+ "DESCR=?,COST_TYPE=? where ID=?";

	private final static String findByIdSQL = "select ID,NAME,"
			+ "BASE_DURATION,BASE_COST,UNIT_COST,STATUS,DESCR,CREATIME,STARTIME,COST_TYPE "
			+ "from COST where ID = ?";

	@Override
	public List<Cost> findAll() throws DAOException {
		List<Cost> list = null;
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(findAllSql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cost c = createCost(rs);
				if (list == null)
					list = new ArrayList<Cost>();
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	private Cost createCost(ResultSet rs) throws SQLException {
		Cost c = new Cost();
		c.setId(rs.getInt("ID"));
		c.setName(rs.getString("name"));
		c.setBaseDuration(rs.getInt("BASE_DURATION"));
		c.setBaseCost(rs.getDouble("BASE_COST"));
		c.setUnitCost(rs.getDouble("UNIT_COST"));
		c.setStatus(rs.getString("STATUS"));
		c.setDescr(rs.getString("DESCR"));
		c.setCreateTime(rs.getDate("CREATIME"));
		c.setStartTime(rs.getDate("STARTIME"));
		c.setCostType(rs.getString("COST_TYPE"));
		return c;
	}

	public static void main(String[] args) throws Exception {
		Connection con = DBUtil.getConnection();
		String sql = "select * from cost";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println("CostName:" + rs.getString("name"));
		}
		sql = "select * from role_info";
		rs = ps.executeQuery(sql);
		while(rs.next()) {
			System.out.println("RoleName:" + rs.getString("name"));
		}
	}

	@Override
	public List<Cost> findByPage(int page, int pageSize, 
			String baseCostSort, String baseDurationSort) 
			throws DAOException {
		List<Cost> list = null;
		StringBuffer sb = new StringBuffer();
		sb.append("select * from (");
		
		sb.append("	select c.*,rownum r from (");
		
		sb.append("		select * from cost order by ");
		//追加排序，默认是正序
		if(baseCostSort == null 
				|| baseCostSort.length() == 0
				|| baseCostSort.equals("sort_asc")) {
			sb.append("BASE_COST asc");
		} else{
			sb.append("BASE_COST desc");
		}
		
		if(baseDurationSort == null 
				|| baseDurationSort.length() == 0
				|| baseDurationSort.equals("sort_asc")) {
			sb.append(",BASE_DURATION asc");
		} else{
			sb.append(",BASE_DURATION desc");
		}
		
		sb.append("	) c where rownum<? ");
		
		sb.append(") where r > ? ");
		
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sb.toString());
			int nextMin = page * pageSize + 1;
			int lastMax = (page - 1) * pageSize;
			ps.setInt(1, nextMin);
			ps.setInt(2, lastMax);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cost c = createCost(rs);
				if (list == null)
					list = new ArrayList<Cost>();
				list.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("分页查询失败！", e);
		} finally {
			DBUtil.closeConnection();
		}
		return list;
	}

	@Override
	public int findTotalPages(int pageSize) throws DAOException {
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(findTotalPageSql);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int rows = rs.getInt(1);
			if (rows % pageSize == 0) {
				return rows / pageSize;
			} else {
				return rows / pageSize + 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return 0;
	}

	@Override
	public void deleteFee(int id) throws DAOException {
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(deleteSql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
	}

	@Override
	public Cost findByName(Integer id, String name) throws DAOException {
		if (name == null)
			return null;
		String sql = "select * from COST where name=? ";
		if(id != null) {
			sql += "and id<>? ";
		}
		
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			if(id != null) {
				ps.setInt(2, id);
			}
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cost c = createCost(rs);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void update(Cost cost) throws DAOException {
		if (cost == null)
			return;
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(updateSQL);
			ps.setString(1, cost.getName());
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.setInt(7, cost.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
	}

	public Cost findById(Integer id) throws DAOException {
		if (id == null) {
			return null;
		}

		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(findByIdSQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Cost c = createCost(rs);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
		return null;
	}

	@Override
	public void insert(Cost cost) throws DAOException {
		if(cost == null)
			return;
		String sql = "insert into COST values(cost_seq.nextval,?,?,?,?,'1',?,SYSDATE,null,?)";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			int index = 1;
			ps.setObject(index++, cost.getName());
			ps.setObject(index++, cost.getBaseDuration());
			ps.setObject(index++, cost.getBaseCost());
			ps.setObject(index++, cost.getUnitCost());
			ps.setObject(index++, cost.getDescr());
			ps.setObject(index++, cost.getCostType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
	}

	@Override
	public void startCost(int id) throws DAOException {
		String sql = "update cost set status='0', startime=sysdate where id=?";
		Connection con = DBUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setObject(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection();
		}
	}

}
