package day05;
/**
 * finally语句块:无论程序是否出异常，都要执行
 * @author Administrator
 *
 */
public class FinallyDemo {
	public static void main(String[] args) {
		try{
			System.out.println("与数据库建立连接");
			System.out.println("输入用户名");
			System.out.println("输入密码");
			System.out.println(
					"保存数据:" + 
					Integer.parseInt("a")
					);
		}catch(Exception e){
			throw new RuntimeException("出错了");
		}finally{
			System.out.println("与数据库断开连接");
		}
	}
}




