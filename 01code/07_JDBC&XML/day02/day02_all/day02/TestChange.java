package day02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestChange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		change(1,8,5000);
	}
	
	/**
	 * 转账功能
	 * @param from 转出账号
	 * @param to 转入账号
	 * @param money 转账金额
	 */
	public static void change(
		int from,int to,double money){
		Connection con = null;
		try{
			//获取数据库连接connection
			Class.forName(
				"oracle.jdbc.OracleDriver");
			String url = 
				"jdbc:oracle:thin:@192.168.0.23:1521:tarena10g";
			con = DriverManager.getConnection(
				url,"jsd1402","jsd1402");
			//关闭事务自动提交
			con.setAutoCommit(false);
			//1.检测转出账号from金额是否大于等于转账money
			String sql1 = "select money " +
				"from d_account where no=?";
			PreparedStatement pst = 
				con.prepareStatement(sql1);
			pst.setInt(1, from);
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				//获取from账号金额
				double db_money = 
						rs.getDouble("money");
				//判断账户金额是否>=转账金额
				if(db_money >= money){
					//2.允许转账，将from转出账号减去
					String sql2 = "update D_ACCOUNT " +
						"set MONEY=MONEY-? where no=?";
					pst = con.prepareStatement(sql2);
					pst.setDouble(1, money);
					pst.setInt(2, from);
					pst.executeUpdate();//更新转出账号金额
					//将to转入账号加上
					String sql3 = "update D_ACCOUNT " +
						"set MONEY=MONEY+? where no=?";
					pst = con.prepareStatement(sql3);
					pst.setDouble(1, money);
					pst.setInt(2, to);
					//rows表示update了几行记录
					int rows = pst.executeUpdate();//更新转入账号金额
					if(rows == 0){
						con.rollback();//撤销前面DML操作
						System.out.println("转账失败,转入账号不存在");
					}else{
						con.commit();//提交前面DML操作
						System.out.println("转账成功!");
					}
				}else{
					System.out.println("账户金额不足！");
				}
			}else{
				System.out.println(from+"账号不存在!");
			}
			
		}catch(Exception ex){
			try {
				con.rollback();//撤销前面DML操作
			} catch (SQLException e) {
			}
			ex.printStackTrace();
		}finally{
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}

}
