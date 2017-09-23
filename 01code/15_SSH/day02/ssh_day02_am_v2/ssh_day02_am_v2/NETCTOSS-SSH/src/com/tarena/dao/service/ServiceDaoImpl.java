package com.tarena.dao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Service;
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
		// ��¼ƴд������ֵ
		List<Object> params = 
			new ArrayList<Object>();
		//ƴsql
		String sql = "select * from (" +
				"select s.*,a.idcard_no," +
				"a.real_name,c.name,c.descr," +
				"rownum r from service s " +
				"inner join account a " +
				"on a.id=s.account_id " +
				"inner join cost c " +
				"on s.cost_id=c.id " +
				"where 1=1 ";
		//ƴsql����
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
			//��������ֵ
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			//ִ�в�ѯ�����ؽ����
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ServiceVO vo = createServiceVO(rs);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ҳ��ѯҵ���˺�ʧ�ܣ�",e);
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

	private Service createService(ResultSet rs) throws SQLException {
		Service vo = new Service();
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
		return vo;
	}
	
	public static void main(String[] args) 
		throws Exception{
		ServiceDaoImpl dao = 
			new ServiceDaoImpl();
		Service s = dao.findById(3021);
		s.setCostId(3);
		dao.update(s);
	}
	
	public int findTotalPage(
			String osUserName, 
			String unixHost, 
			String idcardNo, 
			String status, 
			int pageSize) 
		throws DaoException {
		Connection con = DBUtil.getConnection();
		//��¼����ֵ
		List<Object> params = 
			new ArrayList<Object>();
		//ƴsql
		String sql = "select count(*) from service s " +
				"inner join account a " +
				"on a.id=s.account_id " +
				"inner join cost c " +
				"on c.id=s.cost_id " +
				"where 1=1 ";
		//ƴ����
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
		
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			//�������ϣ���������ֵ
			for(int i=0;i<params.size();i++) {
				ps.setObject(i+1, params.get(i));
			}
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				//��ѯ������
				int rows = rs.getInt(1);
				//������ҳ��
				if(rows%pageSize==0) {
					return rows/pageSize;
				} else {
					return rows/pageSize+1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ѯ��ҳ��ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		
		return 0;
	}

	public void delete(int id) 
		throws DaoException {
		// TODO ͬѧ���Լ����
		
	}

	public void pause(int id) throws DaoException {
		// TODO ͬѧ���Լ����
		
	}

	public void start(int id) throws DaoException {
		// TODO ͬѧ���Լ����
		
	}
	
	public void pauseByAccount(int accountId) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		String sql = "update service " +
				"set status='1'," +
				"pause_date=sysdate " +
				"where account_id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, accountId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"��ͣҵ���˺�ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
	}
	
	public void deleteByAccount(int accountId) 
		throws DaoException {
		// TODO �ο�pauseByAccount���
		
	}

	public Service findById(int id) 
		throws DaoException {
		Connection con = 
			DBUtil.getConnection();
		String sql = "select * from service " +
				"where id=?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Service s = createService(rs);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"����ID��ѯҵ���˺�ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
		return null;
	}
	
	public void update(Service service) 
		throws DaoException {
		if(service == null) {
			return;
		}
		
		Connection con = DBUtil.getConnection();
		String sql = "insert into service_update_bak " +
				"values(service_seq.nextval,?,?)";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, service.getId());
			ps.setObject(2, service.getCostId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"�޸�ҵ���˺�ʧ�ܣ�",e);
		} finally {
			DBUtil.close();
		}
	}
	
}
