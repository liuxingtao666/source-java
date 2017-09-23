package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcB001Dao implements B001Dao{

	@Override
	public void save(B001 b) {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = DBUtil.getConnection();
			String sql = "insert into B001(id,name) values (?,?)";
			pst = con.prepareStatement(sql);
			pst.setInt(1, b.getId());
			pst.setString(2, b.getName());
			pst.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//关闭
			DBUtil.close(con, pst);
		}
	}

	@Override
	public void update(B001 b) {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = DBUtil.getConnection();
			String sql = "update B001 set name=? where id=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, b.getName());
			pst.setInt(2, b.getId());
			pst.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//关闭
			DBUtil.close(con, pst);
		}
	}

	@Override
	public void delete(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		try{
			con = DBUtil.getConnection();
			String sql = "delete from B001 where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			//关闭
			DBUtil.close(con, pst);
		}
	}

	@Override
	public B001 findById(int id) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			String sql = "select id,name " +
				"from B001 where id=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				B001 b = new B001();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				return b;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.close(con, pst, rs);
		}
		return null;
	}

	@Override
	public List<B001> findAll() {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try{
			con = DBUtil.getConnection();
			String sql = "select id,name " +
				"from B001 order by id";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();//执行查询
			List<B001> list = new ArrayList<B001>();
			//循环将rs结果集记录封装成list集合
			while(rs.next()){
				B001 b = new B001();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				list.add(b);//将b对象放入list集合
			}
			return list;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			DBUtil.close(con, pst, rs);
		}
		return null;
	}

}
