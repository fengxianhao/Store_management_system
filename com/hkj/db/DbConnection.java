package com.hkj.db;

import java.sql.DriverManager;
import java.sql.SQLException;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	//����������
	private static final String DRIVERNAME="com.mysql.jdbc.Driver";
	//�������ݿ��URL·��
	private static final String URL="jdbc:mysql://localhost:3306/store_management_system";
	//���ݿ��¼�ʺ�
	private static final String USER="root";
	//���ݿ��¼����
	private static final String PASSWORD="root";
	//����������ֻ�����һ�μ���
	static{
		try {
			Class.forName(DRIVERNAME);
			System.out.println("���������ɹ���");
		} catch (ClassNotFoundException e) {
			System.out.println("����ʧ�ܣ�");
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
		System.out.println("���ݿ�����="+conn);
		
	}


	

	
}
