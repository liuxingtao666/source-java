package com.tarena.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.util.DBUtil;
import com.tarena.vo.ServiceVO;

public class ServiceDaoImpl implements IServiceDao {

	public List<ServiceVO> findByCondition(
			String osUserName, 
			String unixHost,
			String idcardNo, 
			String status, 
			int page, int pageSize)
			throws DaoException {
		List<ServiceVO> list = 
			new ArrayList<ServiceVO>();
		
		Connection con = DBUtil.getConnection();
		// 记录拼写的条件值
		List<Object> params = 
			new ArrayList<Object>();
		//拼sql
		String sql = "select * from (" +
				"select s.*,a.idcard_no," +
				"a.real_name,c.name,c.descr," +
				"rownum r from service s " +
				"inner join account a " +
				"on a.id=s.account_id " +
				"inner join cost c " +
				"on s.cost_id=c.id " +
				"where 1=1 ";
		//拼sql条件
		if(osUserName != null
				&& osUserName.length() > 0) {
			sql += "and s.os_username=? ";
			params.add(osUserName);
		}
		if(unixHost != null 
				&& unixHost.length() > 0) {
			sql += "and s.unix_host=? ";
			params.add(unixHost);
		}
		if(idcardNo != null
				&& idcardNo.length() > 0) {
			sql += "and a.idcard_no=? ";
			params.add(idcardNo);
		}
		if(status != null
				&& status.length() > 0) {
			sql += "and s.status=? ";
			params.add(status);
		}
		sql += ") where r<? and r>?";
		params.add(page*pageSize+1);
		params.add((page-1)*pageSize);
		
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//给参数赋值
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			//执行查询，返回结果集
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ServiceVO vo = createServiceVO(rs);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"分页查询业务账号失败！",e);
		} finally {
			DBUtil.close();
		}
		
		return list;
	}

	private ServiceVO createServiceVO(ResultSet rs) throws SQLException {
		ServiceVO vo = new ServiceVO();
		vo.setId(rs.getInt("id"));
		vo.setAccountId(rs.getInt("account_id"));
		vo.setUnixHost(rs.getString("unix_host"));
		vo.setOsUserName(rs.getString("os_username"));
		vo.setLoginPassword(rs.getString("login_passwd"));
		vo.setStatus(rs.getString("status"));
		vo.setCreateDate(rs.getDate("create_date"));
		vo.setPauseDate(rs.getDate("pause_date"));
		vo.setCloseDate(rs.getDate("close_date"));
		vo.setCostId(rs.getInt("cost_id"));
		vo.setIdcardNo(rs.getString("idcard_no"));
		vo.setRealName(rs.getString("real_name"));
		vo.setCostName(rs.getString("name"));
		vo.setCostDescr(rs.getString("descr"));
		return vo;
	}

	public static void main(String[] args) 
		throws Exception{
		ServiceDaoImpl dao = 
			new ServiceDaoImpl();
		List<ServiceVO> list = 
			dao.findByCondition(
				"luwsh", "192.168.0.20", "320211199307310346", "0", 1, 5);
		for(ServiceVO vo : list) {
			System.out.println(
				vo.getId() + " " +
				vo.getUnixHost() + " " +
				vo.getOsUserName() + " " +
				vo.getStatus() + " " +
				vo.getIdcardNo() + " "+
				vo.getRealName() + " " +
				vo.getCostName() + " " +
				vo.getCostDescr()
			);
		}
	}
	
}
