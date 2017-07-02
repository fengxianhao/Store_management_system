package com.hkj.db;

import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	//驱动类名称
	private static final String DRIVERNAME="com.mysql.jdbc.Driver";
	//连接数据库的URL路径
	private static final String URL="jdbc:mysql://localhost:3306/store_management_system";
	//数据库登录帐号
	private static final String USER="root";
	//数据库登录密码
	private static final String PASSWORD="root";
	//加载驱动，只需加载一次即可
	static{
		try {
			Class.forName(DRIVERNAME);
			System.out.println("加载驱动成功！");
		} catch (ClassNotFoundException e) {
			System.out.println("加载失败！");
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		Connection conn=null;
		try {
			return conn=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	

	public static void main(String[] args) {
		Connection conn=DbConnection.getConnection();
		System.out.println("数据库连接="+conn);
		
	}


	

	
}
