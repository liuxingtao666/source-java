package day03;

public class TestDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B001 b = new B001();
		b.setId(101);
		b.setName("����");
		//��Ҫ��b��Ϣд�뵽B001
		B001Dao dao = new JdbcB001Dao();
		dao.save(b);
	}

}
