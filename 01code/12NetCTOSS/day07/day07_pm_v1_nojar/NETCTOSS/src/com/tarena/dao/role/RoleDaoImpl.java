package com.tarena.dao.role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.dao.DaoException;
import com.tarena.entity.Role;
import com.tarena.util.DBUtil;
import com.tarena.util.PrivilegeReader;
import com.tarena.vo.RoleVO;

public class RoleDaoImpl implements IRoleDao {

	public List<RoleVO> findByPage(
			int page, int pageSize) 
			throws DaoException {
		List<RoleVO> list = 
			new ArrayList<RoleVO>();
		Connection con = DBUtil.getConnection();
		//先分页查询角色
		String sql = "select * from (" +
				"select i.*,rownum r " +
				"from role_info i" +
				") where r<? and r>?";
		try {
			PreparedStatement ps = 
				con.prepareStatement(sql);
			ps.setObject(1, page*pageSize+1);
			ps.setObject(2, (page-1)*pageSize);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RoleVO vo = new RoleVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				//查询每一个角色对应的全部模块
				String sql2 = "select privilege_id " +
						"from role_privilege " +
						"where role_id=?";
				PreparedStatement ps2 = 
					con.prepareStatement(sql2);
				ps2.setObject(1, vo.getId());
				ResultSet rs2 =
					ps2.executeQuery();
				//模块名称字符串
				String name = "";
				while(rs2.next()) {
					int pid = rs2.getInt(1);
					//根据pid取出模块名
					String pname = PrivilegeReader
							.getPrivilegeNameById(pid);
					name += "," + pname;
				}
				//去掉多余第一个，
				if(name.length() > 0) {
					name = name.replaceFirst(",", "");
				}
				//将得到的模块名字符串设置到VO
				vo.setModulesName(name);
				
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DaoException(
				"分页查询角色失败！",e);
		} finally {
			DBUtil.close();
		}
		
		return list;
	}

	public int findTotalPage(int pageSize) throws DaoException {
		// TODO 同学们自己完成，针对角色表进行计算，参考资费管理的findTotalPage
		return 0;
	}

	public void add(Role role) 
		throws DaoException {
		if(role == null)
			return;
		Connection con = 
			DBUtil.getConnection();
		//新增角色
		String sql = "insert into role_info " +
				"values(role_seq.nextval,?)";
		try {
			con.setAutoCommit(false);
			//执行完更新后，可以返回的列
			String[] columns = new String[] { "id" };
			PreparedStatement ps = 
				con.prepareStatement(sql, columns);
			ps.setObject(1, role.getName());
			ps.executeUpdate();
			
			//获取主键列，结果集中的列是实例化ps时指定的列
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int roleId = rs.getInt(1);
			
			// 新增角色模块中间表
			List<Integer> pids = 
				role.getPrivilegeIds();
			if(pids != null
					&& pids.size() > 0) {
				String sql2 = "insert into role_privilege " +
						"values(?,?)";
				PreparedStatement ps2 = 
					con.prepareStatement(sql2);
				for(Integer pid : pids) {
					ps2.setObject(1, roleId);
					ps2.setObject(2, pid);
					//加入批处理
					ps2.addBatch();
				}
				//执行批处理
				ps2.executeBatch();
				//提交事务
				con.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				//回滚事务
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DaoException(
				"新增角色失败！",e);
		} finally {
			DBUtil.close();
		}
		
	}
	
	public static void main(String[] args) throws DaoException {
		RoleDaoImpl dao = new RoleDaoImpl();
		Role r = new Role();
		r.setName("老板");
		List<Integer> list = 
			new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(7);
		r.setPrivilegeIds(list);
		dao.add(r);
	}
	
}
