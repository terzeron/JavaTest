package old;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class NConnectionMaker implements ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		System.out.println("connecting to N");
		Connection c = DriverManager.getConnection("jdbc:sqlite:N.db");
		return c;
	}
	
}
