package com.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 	映射关系接口的实现类：
 *	实现了资费的结果集与对象的转换。
 */
public class CostMapper 
	implements RowMapper {

	/* 
	 * 将一行结果集映射成一个实体对象。
	 * 相当于以前资费查询时写的createCost(rs)。
	 * @param rs 一行结果集
	 * @param index 循环次数
	 */
	public Object mapRow(
			ResultSet rs, int index) 
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

}
