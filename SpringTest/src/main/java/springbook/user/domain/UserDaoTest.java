package springbook.user.domain;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDaoTest {
	public static void main(String [] args) throws ClassNotFoundException, SQLException {
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		UserDao dao = context.getBean("UserDao", UserDao.class);
		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("hellopass");
		dao.add(user);
		System.out.println(dao.get("whiteship").getName());
	}
}
