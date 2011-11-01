package old;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.NConnectionMaker;
import springbook.user.dao.UserDao;

@Configuration
public class DaoFactory {
	
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}
	
//	public AccountDao accountDao() {
//		return new AccountDao(connectionMaker());
//	}
//	
//	public MessageDao messageDao() {
//		return new MessageDao(connectionMaker());
//	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new NConnectionMaker();
	}
}
