package com.tarena.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * 	ӳ���ϵ�ӿڵ�ʵ���ࣺ
 *	ʵ�����ʷѵĽ����������ת����
 */
public class CostMapper 
	implements RowMapper {

	/* 
	 * ��һ�н����ӳ���һ��ʵ�����
	 * �൱����ǰ�ʷѲ�ѯʱд��createCost(rs)��
	 * @param rs һ�н����
	 * @param index ѭ������
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
