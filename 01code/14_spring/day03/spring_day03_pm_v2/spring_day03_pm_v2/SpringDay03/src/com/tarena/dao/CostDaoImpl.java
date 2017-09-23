package com.tarena.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.tarena.entity.Cost;
import com.tarena.entity.CostMapper;

@Repository("costDao")
public class CostDaoImpl 
	extends JdbcDaoSupport implements ICostDao {

	@Resource
	public void setDS(DataSource ds) {
		System.out.println("注入DataSource...");
		super.setDataSource(ds);
	}
	
	public void delete(int id) {
		String sql = "delete from cost " +
				"where id=?";
		Object[] params = 
			new Object[] { id };
		getJdbcTemplate().update(sql, params);
	}

	public List<Cost> findAll() {
		String sql = "select * from cost";
		return getJdbcTemplate()
			.query(sql, new CostMapper());
	}

	public Cost findById(int id) {
		String sql = "select * from cost " +
				"where id=?";
		Object[] params = new Object[] { id };
		return (Cost) getJdbcTemplate()
			.queryForObject(
				sql, params, new CostMapper());
	}

	public void save(Cost cost) {
		if(cost == null)
			return;
		// 定义插入的sql
		String sql = "insert into cost " +
				"values(cost_seq.nextval,?,?,?,?,'0',?,sysdate,null,?)";
		// 构建参数数组，顺序与？一致
		Object[] params = new Object[] {
				cost.getName(),
				cost.getBaseDuration(),
				cost.getBaseCost(),
				cost.getUnitCost(),
				cost.getDescr(),
				cost.getCostType()
		};
		getJdbcTemplate().update(sql, params);
	}

	public void update(Cost cost) {
		if(cost == null)
			return;
		String sql = "update cost " +
				"set name=?,base_duration=?," +
				"base_cost=?,unit_cost=?," +
				"descr=?,cost_type=? where id=?";
		Object[] params = new Object[] {
				cost.getName(),
				cost.getBaseDuration(),
				cost.getBaseCost(),
				cost.getUnitCost(),
				cost.getDescr(),
				cost.getCostType(),
				cost.getId()
		};
		getJdbcTemplate()
			.update(sql, params);
	}

}
