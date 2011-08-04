package springbook.user.domain;

public class DaoFactory {
	public UserDao userDao() {
		ConnectionMaker connectionMaker = new NConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		return userDao;
	}
}