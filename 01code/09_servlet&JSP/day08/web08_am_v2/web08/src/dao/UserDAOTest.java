package dao;

import org.junit.Test;

import entity.User;

public class UserDAOTest {

	@Test
	public void testFindByUsername() throws Exception {
		UserDAO dao = new UserDAO();
		User user = dao.findByUsername("eric1");
		System.out.println(user);
	}

}
