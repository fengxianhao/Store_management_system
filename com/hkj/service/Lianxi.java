package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hkj.db.DbConnection;
import com.hkj.entity.Person;



public class Lianxi {

	public List<Person> query(){
		DbConnection bc=new DbConnection();
		Connection conn=null;
		PreparedStatement pStat=null;
		ResultSet rs=null;
		List<Person> wList = null;
		try {
			String sql="select EmployeeID,Ename,Sex,Age,Position from employee";
			conn=bc.getConnection();
			pStat=conn.prepareStatement(sql);
			rs=pStat.executeQuery();
			wList=new ArrayList<Person>();

			while(rs.next()){
				int EmployeeID=rs.getInt("EmployeeID");
				//System.out.print(EmployeeID);
				String Ename=rs.getString("Ename");
				String sex=rs.getString("sex");
				int Age=rs.getInt("Age");
				String Position=rs.getString("Position");
				Person writing=new Person();
				writing.setEmployeeID(EmployeeID);
				writing.setEname(Ename);
				writing.setSex(sex);
				writing.setAge(Age);
				writing.setPosition(Position);
				//				System.out.println(EmployeeID);
				wList.add(writing);
			}
			//			System.out.println(wList.get(0).getEmployeeID());
			//			System.out.println(wList.get(1).getEmployeeID());
			//			System.out.println(wList.get(2).getEmployeeID());
			//			System.out.println(wList.get(3).getEmployeeID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wList;
	}

	public Person SelectEmployeeByID(int employeeID){
		Person p=new Person();
		DbConnection bc=new DbConnection();
		Connection conn=null;
		PreparedStatement pStat=null;
		ResultSet rs=null;
		try {
			String sql="select * from employee where EmployeeID='"+employeeID+"'";
			conn=bc.getConnection();
			pStat=conn.prepareStatement(sql);
			rs=pStat.executeQuery();

			if(rs.next()){
				p.setEmployeeID(rs.getInt("EmployeeID"));
				p.setEname(rs.getString("Ename"));
				p.setSex(rs.getString("Sex"));
				p.setAge(rs.getInt("Age"));
				p.setPosition(rs.getString("Position"));
				p.setIDcard(rs.getString("IDcard"));
				p.setPhone(rs.getString("phone"));
				p.setAddress(rs.getString("Address"));
				p.setcDate(rs.getString("cDate"));
				p.setNumber(rs.getString("Number"));
				p.setPwd(rs.getString("Pwd"));
				p.setPowerID(rs.getInt("PowerID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return p;
	}


	public static void main(String[] args) {
		Lianxi lianxi=new Lianxi();
		lianxi.query();
	}
}
