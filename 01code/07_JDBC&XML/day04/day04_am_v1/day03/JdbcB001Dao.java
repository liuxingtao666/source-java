package day03;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
			//¹Ø±Õ
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
			//¹Ø±Õ
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
			//¹Ø±Õ
			DBUtil.close(con, pst);
		}
	}

}
