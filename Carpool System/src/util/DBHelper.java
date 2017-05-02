package util;

import java.sql.*;

public class DBHelper {
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/carpool";
	private static final String username = "root";
	private static final String password = "123456";

	private static Connection conn = null;

	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	public static void closeConnection() {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			Statement cmd = conn.createStatement();
			rs = cmd.executeQuery(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int executeUpdate(String sql, Object[] params) {
		return 0;
	}

	public static int executeUpdate(String sql) {
		int r = 0;
		try {
			Connection conn = DriverManager.getConnection(url, username,
					password);
			Statement cmd = conn.createStatement();
			r = cmd.executeUpdate(sql);
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return r;
	}

	/*public static void main(String[] args) {
		try {
			conn = getConnection();
			if (conn != null) {
				System.out.println("连接正常");
			} else {
				System.out.println("连接出错");
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	*/

}
