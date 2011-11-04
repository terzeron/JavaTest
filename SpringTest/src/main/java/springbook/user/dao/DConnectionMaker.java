package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DConnectionMaker implements ConnectionMaker {

	public Connection makeConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.sqlite.JDBC");
		System.out.println("connecting to D");
		Connection c = DriverManager.getConnection("jdbc:sqlite:D.db");
		return c;
	}
	
}
