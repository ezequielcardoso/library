package com.huan.library.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private String classString = "com.mysql.jdbc.Driver";
	private String username = "root";
	private String password = "root";
	private String url = "jdbc:mysql://localhost:3306/huan";
	private Connection con = null;

	public Connection getConnection() {
		try {
			Class.forName(classString);
			con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
