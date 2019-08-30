package com.springrest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AbstractDBConnection {
	Connection connection = null;
	public Connection getConnection() throws SQLException {
		if (connection == null) {
			synchronized (AbstractDBConnection.class) {
				if (connection == null) { // two level locking
					String url = "jdbc:mysql://localhost:3306/database2";
					String user = "root";
					String password = "root";
					connection = DriverManager.getConnection(url, user, password);
				}
			}
		}
		return connection;
	}
}
