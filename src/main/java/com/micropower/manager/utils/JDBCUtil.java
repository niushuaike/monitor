package com.micropower.manager.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class JDBCUtil {
	private static String password;
	private static String user;
	private static String url;
	static {
		Properties properties = new Properties();

		try {
			//properties.load(JDBCUtil.class.getClassLoader().getResourceAsStream("DB.properties"));
			String driver = "com.mysql.jdbc.Driver";
			url = "jdbc:mysql:///monitor?characterEncoding=utf8&useSSL=true";
			user = "root";
			password = "root";
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	public static void relase(Connection conn, PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void relase(Connection conn, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
