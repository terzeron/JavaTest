package old;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.NConnectionMaker;
import springbook.user.dao.UserDao;

@Configuration
public class CountingDaoFactory {
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new CountingConnectionMaker(realConnectionMaker());
	}
	
	@Bean
	public ConnectionMaker realConnectionMaker() {
		return new NConnectionMaker();
	}
}
