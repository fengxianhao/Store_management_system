package com.hkj.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection1 {
	// 驱动类的类名
	private static final String DRIVERNAME = "com.mysql.jdbc.Driver";
	// 连接数据的URL路径
	private static final String URL = "jdbc:mysql://localhost:3306/store_management_system";
	// 数据库登录账号
	private static final String USER = "root";
	// 数据库登录密码
	private static final String PASSWORD = "root";
	// 1.加载驱动，驱动仅需加载一次就可
	static {
		try {
			Class.forName(DRIVERNAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	// 2.获取数据库连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			return conn = (Connection) DriverManager.getConnection(URL, USER,
					PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection(PreparedStatement ps, Connection connection) {
		closePreparedStatement(ps);
		closeConnection(connection);
	}
	

	public static void closeConnection(ResultSet rs, Statement stmt,
			Connection con) {
		closeResultSet(rs);
		closeStatement(stmt);
		closeConnection(con);
	}
	
	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			if(ps != null) 
				ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection(Statement stmt, Connection con) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		closeConnection(con);
	}

	public static void closeConnection(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeStatement(Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeResultSet(ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * SQL语句中字符型数据若不为null，则添加引号
	 */
	public static String quote(String s) {
		if (s == null)
			return "null";
		else
			return "'" + s + "'";
	}

	public static void main(String[] args) {
		Connection conn = DbConnection1.getConnection();
		System.out.print("数据库连接=" + conn);
	}
}
