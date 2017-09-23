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
		Account a = 
			dao.findById(1011);
		System.out.println("ID��"+a.getId());
		System.out.println("���֤��"+a.getIdcardNo());
		System.out.println("�Ƽ���ID��"+a.getRecommenderId());
		System.out.println("�Ƽ������֤��"+a.getRecommenderIdcardNo());
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

	public void delete(int id) 
		throws DaoException {
		// TODO ͬѧ���������
		
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
				"��ͣ�����˺�ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
	}

	public void start(int id) 
		throws DaoException {
		// TODO ͬѧ���������
		
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
			//��������ֵ
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
				"���������˺�ʧ�ܣ�",e);
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
				"�������֤��ѯ�����˺�ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
		return null;
	}
	
	public Account findById(int id) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		//��ѯ�����˺�
		String sql = "select * from account " +
				"where id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Account a = createAccount(rs);
				//��ѯ�Ƽ������֤��
				if(a.getRecommenderId() != null) {
					//�����Ƽ���id����Ƽ������֤
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
				"����ID��ѯ�����˺�ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		return null;
	}
	
}
