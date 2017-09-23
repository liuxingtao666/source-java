package day03;

public class TestDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B001 b = new B001();
		b.setId(101);
		b.setName("文章");
		//需要把b信息写入到B001
		B001Dao dao = new JdbcB001Dao();
		dao.save(b);
	}

}
