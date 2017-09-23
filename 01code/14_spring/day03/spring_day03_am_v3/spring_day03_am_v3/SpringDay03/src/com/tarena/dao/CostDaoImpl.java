package com.tarena.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.tarena.entity.Cost;
import com.tarena.entity.CostMapper;

public class CostDaoImpl 
	extends JdbcDaoSupport implements ICostDao {

	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	public List<Cost> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

}
