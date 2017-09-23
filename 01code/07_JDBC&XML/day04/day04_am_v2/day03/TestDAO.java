package day03;

import java.util.List;

public class TestDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		testFind();
		testFindAll();
	}
	
	public static void testFindAll(){
		B001Dao dao = new JdbcB001Dao();
		List<B001> list = dao.findAll();
		if(list != null){
			for(B001 b : list){
				System.out.println(b.getId()+" "+b.getName());
			}
		}else{
			System.out.println("未找到数据");
		}
	}
	
	public static void testFind(){
		B001Dao dao = new JdbcB001Dao();
		B001 b = dao.findById(1020);
		if(b != null){
			System.out.println(b.getName());
		}else{
			System.out.println("未找到数据");
		}
	}
	
	public static void testAdd(){
		B001 b = new B001();
		b.setId(101);
		b.setName("文章");
		//需要把b信息写入到B001
		B001Dao dao = new JdbcB001Dao();
		dao.save(b);
	}
	

}
