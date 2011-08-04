package springbook.user.domain;

import java.sql.SQLException;

public class UserDaoTest {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new DaoFactory().userDao();
		User user = new User();
		user.setId("whiteship");
		user.setName(" 백기선");
		user.setPassword("hellopass");
		dao.add(user);
		System.out.println(dao.get("whiteship").getName());
	}
}
