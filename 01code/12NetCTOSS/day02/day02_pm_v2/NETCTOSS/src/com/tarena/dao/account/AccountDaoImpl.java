package com.tarena.dao.account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Account;
import com.tarena.util.DBUtil;

public class AccountDaoImpl 
	implements IAccountDao {

	public List<Account> findByCondition(
			String idcardNo, 
			String realName, 
			String loginName, 
			String status) 
			throws DaoException {
		List<Account> list = 
			new ArrayList<Account>();
		//获取连接
		Connection con = DBUtil.getConnection();
		//提供查询SQL
		String sql = "select * from account " +
				"where 1=1 ";
		//动态封装参数
		List<Object> params = 
			new ArrayList<Object>();
		if(idcardNo != null
				&& idcardNo.length() > 0) {
			sql += "and idcard_no=? ";
			params.add(idcardNo);
		}
		if(realName != null
				&& realName.length() > 0) {
			sql +="and real_name=? ";
			params.add(realName);
		}
		if(loginName != null
				&& loginName.length() > 0) {
			sql += "and login_name=? ";
			params.add(loginName);
		}
		if(status != null
				&& status.length() > 0) {
			sql += "and status=? ";
			params.add(status);
		}
		//实例化PreparedStatement
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//遍历参数集合，给？赋值
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			//执行查询
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account a = createAccount(rs);
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"查询账务账号失败！",e);
		} finally {
			DBUtil.close();
		}
		return list;
	}

	private Account createAccount(ResultSet rs) throws SQLException {
		Account a = new Account();
		a.setId(rs.getInt("id"));
		a.setRecommenderId(rs.getInt("recommender_id"));
		a.setLoginName(rs.getString("login_name"));
		a.setLoginPassword(rs.getString("login_passwd"));
		a.setStatus(rs.getString("status"));
		a.setCreateDate(rs.getDate("create_date"));
		a.setPauseDate(rs.getDate("pause_date"));
		a.setCloseDate(rs.getDate("close_date"));
		a.setRealName(rs.getString("real_name"));
		a.setIdcardNo(rs.getString("idcard_no"));
		a.setBirthdate(rs.getDate("birthdate"));
		a.setGender(rs.getString("gender"));
		a.setOccupation(rs.getString("occupation"));
		a.setTelephone(rs.getString("telephone"));
		a.setEmail(rs.getString("email"));
		a.setMailaddress(rs.getString("mailaddress"));
		a.setZipcode(rs.getString("zipcode"));
		a.setQq(rs.getString("qq"));
		a.setLastLoginTime(rs.getDate("last_login_time"));
		a.setLastLoginIp(rs.getString("last_login_ip"));
		return a;
	}

	public static void main(String[] args) 
		throws Exception {
		AccountDaoImpl dao = 
			new AccountDaoImpl();
		List<Account> list = 
			dao.findByCondition(
				"410381194302256528", "zhangsanfeng", "taiji001", "0");
		for(Account a : list) {
			System.out.println(
				a.getId() + " " +
				a.getIdcardNo() + " " +
				a.getRealName()  + " " +
				a.getLoginName() + " " +
				a.getStatus()
			);
		}
	}
	
}
