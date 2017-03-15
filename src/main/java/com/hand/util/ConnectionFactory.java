package com.hand.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static ConnectionFactory factory = new ConnectionFactory();

	public ConnectionFactory() {

	}

	static {
		try {
			Properties pop = new Properties();
			InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream("dbconfig.properties");
			pop.load(input);
			driver = pop.getProperty("driver");
			url = pop.getProperty("url");
			username = pop.getProperty("username");
			password = pop.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ConnectionFactory getInstance() {
		return factory;
	}

	public Connection getconn() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
