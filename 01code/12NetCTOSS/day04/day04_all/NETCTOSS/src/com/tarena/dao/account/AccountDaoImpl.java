package com.tarena.dao.account;

import java.sql.Connection;
import java.sql.Date;
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
			String status,
			int page, int pageSize) 
			throws DaoException {
		List<Account> list = 
			new ArrayList<Account>();
		//获取连接
		Connection con = DBUtil.getConnection();
		//提供查询SQL
		String sql = "select * from (" +
				"select a.*,rownum r " +
				"from account a " +
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
		//拼分页条件
		sql += ") where r<? and r>? ";
		//小于下页最小行
		params.add(page*pageSize+1);
		//大于上页最大行
		params.add((page-1)*pageSize);
		
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
		Account a = 
			dao.findById(1011);
		System.out.println("ID："+a.getId());
		System.out.println("身份证："+a.getIdcardNo());
		System.out.println("推荐人ID："+a.getRecommenderId());
		System.out.println("推荐人身份证："+a.getRecommenderIdcardNo());
	}

	public int findTotalPage(
			String idcardNo, 
			String realName, 
			String loginName, 
			String status, 
			int pageSize) 
		throws DaoException {
		Connection con = DBUtil.getConnection();
		//定义查询sql
		String sql = "select count(*) from account " +
				"where 1=1 ";
		//用集合记录条件值
		List<Object> params = 
			new ArrayList<Object>();
		//拼查询条件
		if(idcardNo != null
				&& idcardNo.length() > 0) {
			sql += "and idcard_no=? ";
			params.add(idcardNo);
		}
		if(realName != null
				&& realName.length() > 0) {
			sql += "and real_name=? ";
			params.add(realName);
		}
		if(loginName != null
				&& loginName.length() > 0) {
			sql += "and login_name=?";
			params.add(loginName);
		}
		if(status != null
				&& status.length() > 0) {
			sql += "and status=? ";
			params.add(status);
		}
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//循环集合，给参数赋值
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			//查询总行数
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int rows = rs.getInt(1);
				// 计算总页数
				if(rows%pageSize==0) {
					return rows/pageSize;
				} else {
					return rows/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"查询总行数失败！",e);
		} finally {
			DBUtil.close();
		}
		
		//默认返回0页
		return 0;
	}

	public void delete(int id) 
		throws DaoException {
		// TODO 同学们自行完成
		
	}

	public void pause(int id) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		String sql = "update account " +
				"set status='1'," +
				"pause_date=sysdate " +
				"where id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"暂停账务账号失败！",e);
		} finally {
			DBUtil.close();
		}
	}

	public void start(int id) 
		throws DaoException {
		// TODO 同学们自行完成
		
	}

	public void add(Account acc) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		String sql = "insert into account " +
				"values(account_seq.nextval,?,?,?,'0',sysdate,null,null,?,?,?,?,?,?,?,?,?,?,null,null)";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//给参数赋值
			ps.setObject(1, acc.getRecommenderId());
			ps.setObject(2, acc.getLoginName());
			ps.setObject(3, acc.getLoginPassword());
			ps.setObject(4, acc.getRealName());
			ps.setObject(5, acc.getIdcardNo());
			ps.setObject(6, acc.getBirthdate());
			ps.setObject(7, acc.getGender());
			ps.setObject(8, acc.getOccupation());
			ps.setObject(9, acc.getTelephone());
			ps.setObject(10, acc.getEmail());
			ps.setObject(11, acc.getMailaddress());
			ps.setObject(12, acc.getZipcode());
			ps.setObject(13, acc.getQq());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"增加账务账号失败！",e);
		} finally {
			DBUtil.close();
		}
	}
	
	public Account findByIdcardNo(
			String idcardNo) 
		throws DaoException {
		if(idcardNo == null
				|| idcardNo.length() == 0) {
			return null;
		}
		
		Connection con = 
			DBUtil.getConnection();
		String sql = "select * from account " +
				"where idcard_no=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, idcardNo);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Account a = createAccount(rs);
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"根据身份证查询账务账号失败！",e);
		} finally {
			DBUtil.close();
		}
		
		return null;
	}
	
	public Account findById(int id) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		//查询账务账号
		String sql = "select * from account " +
				"where id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Account a = createAccount(rs);
				//查询推荐人身份证号
				if(a.getRecommenderId() != null) {
					//根据推荐人id查出推荐人身份证
					String sql2 = "select idcard_no from account " +
							"where id=?";
					PreparedStatement ps2 = 
						con.prepareStatement(sql2);
					ps2.setObject(1, a.getRecommenderId());
					ResultSet rs2 = ps2.executeQuery();
					if(rs2.next()) {
						String recommenderIdcardNo = 
							rs2.getString(1);
						a.setRecommenderIdcardNo(
								recommenderIdcardNo);
					}
				}
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"根据ID查询账务账号失败！",e);
		} finally {
			DBUtil.close();
		}
		return null;
	}
	
}
