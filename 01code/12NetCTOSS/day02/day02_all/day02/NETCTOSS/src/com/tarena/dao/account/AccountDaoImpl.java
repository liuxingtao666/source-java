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
			String status,
			int page, int pageSize) 
			throws DaoException {
		List<Account> list = 
			new ArrayList<Account>();
		//��ȡ����
		Connection con = DBUtil.getConnection();
		//�ṩ��ѯSQL
		String sql = "select * from (" +
				"select a.*,rownum r " +
				"from account a " +
				"where 1=1 ";
		//��̬��װ����
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
		//ƴ��ҳ����
		sql += ") where r<? and r>? ";
		//С����ҳ��С��
		params.add(page*pageSize+1);
		//������ҳ�����
		params.add((page-1)*pageSize);
		
		//ʵ����PreparedStatement
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//�����������ϣ�������ֵ
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			//ִ�в�ѯ
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Account a = createAccount(rs);
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ѯ�����˺�ʧ�ܣ�",e);
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
		int pages = 
			dao.findTotalPage(
					"410381194302256528", null, null, null, 5);
		System.out.println(pages);
	}

	public int findTotalPage(
			String idcardNo, 
			String realName, 
			String loginName, 
			String status, 
			int pageSize) 
		throws DaoException {
		Connection con = DBUtil.getConnection();
		//�����ѯsql
		String sql = "select count(*) from account " +
				"where 1=1 ";
		//�ü��ϼ�¼����ֵ
		List<Object> params = 
			new ArrayList<Object>();
		//ƴ��ѯ����
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
			//ѭ�����ϣ���������ֵ
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			//��ѯ������
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int rows = rs.getInt(1);
				// ������ҳ��
				if(rows%pageSize==0) {
					return rows/pageSize;
				} else {
					return rows/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ѯ������ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
		//Ĭ�Ϸ���0ҳ
		return 0;
	}
	
}