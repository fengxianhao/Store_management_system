package com.hkj.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hkj.db.DbConnection;
import com.hkj.entity.Person;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class PersonService {
	private static final int EmployeeID=1;
	private static final String Ename =null;
	DbConnection dbConnection=new DbConnection();
	Connection connection=null;
	PreparedStatement psd=null;
	 Person person =new Person();
	private String sex;
	private int age;

	//娣诲姞
public boolean addPersons(Person person){
		
		try {
			String sql="insert into employee (EmployeeID,Ename,Sex,Age,Position,IDcard,Phone,Address,cDate,Number,Pwd,PowerID)"+" values (null,?,?,?,?,?,?,?,?,?,?,?)";
			connection=(Connection) dbConnection.getConnection();
			psd=(PreparedStatement) connection.prepareStatement(sql);
			//psd.setInt(1, person.getEmployeeID());
			psd.setString(1, person.getEname());
			psd.setString(2, person.getSex());
			psd.setInt(3, person.getAge());
			psd.setString(4, person.getPosition());
			psd.setString(5, person.getIDcard());
			psd.setString(6, person.getPhone());
			psd.setString(7, person.getAddress());
			psd.setString(8, person.getcDate());
			psd.setString(9,person.getNumber());
			psd.setString(10,person.getPwd());
			psd.setInt(11, person.getPowerID());
			psd.execute();
			return true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//鍏抽棴鐩稿叧璧勬簮
				try {
					if(psd!=null){
						psd.close();
					}if(connection!=null){
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return false;
		}

	
	//鍒犻櫎
	public int deletePerson(int id){
		String sql="delete from employee where EmployeeID=?";
		connection=(Connection) dbConnection.getConnection();
		try {
			psd=(PreparedStatement) connection.prepareStatement(sql);
			psd.setInt(1, id);
			return psd.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//鍏抽棴鐩稿叧璧勬簮
			try {
				if(psd!=null){
					psd.close();
				}if(connection!=null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	
	//淇敼
	public boolean updatePerson(Person person){
		String sqlString="update employee set Ename=?,Sex=?,Age=?,Position=?,IDcard=?,Phone=?,Address=?,cDate=?"+" where EmployeeID=?";
		connection=(Connection) dbConnection.getConnection();
		try {
			psd=(PreparedStatement) connection.prepareStatement(sqlString);
			psd.setString(1, person.getEname());
			psd.setString(2, person.getSex());
			psd.setInt(3, person.getAge());
			psd.setString(4, person.getPosition());
			psd.setString(5, person.getIDcard());
			psd.setString(6, person.getPhone());
			psd.setString(7, person.getAddress());
			psd.setString(8, person.getcDate());
			psd.setInt(9, person.getEmployeeID()); 
			

			
			
			return psd.executeUpdate()>0?true:false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//鍏抽棴鐩稿叧璧勬簮
			try {
				if(psd!=null){
					psd.close();
				}if(connection!=null){
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
		
	}
//	public static void main(String[] args) {
//		Person person=new Person();
//		person.setEmployeeID(6);
//		person.setEname("濂�);
//		person.setSex("鐢�);
//		person.setAge(18);
//		person.setPosition("5656");
//		person.setIDcard("12345");
//		person.setPhone("18986466949");
//		person.setAddress("涓婃捣");
//		person.setcDate("2016骞�鏈�9鏃�);
//		person.setNumber("155555");
//		person.setPwd("55559");
//		person.setPowerID(462551);
//		PersonService  personService=new PersonService();
//		personService.updatePerson(person);
//	}
	//鏌ヨ鎵�湁浜哄憳淇℃伅
public List<Person> getAllPerson(){

		
		String sqlString="select EmployeeID,Ename,sex,Age,Position from employee where EmployeeID=?";
		connection=(Connection) dbConnection.getConnection();
		ArrayList<Person> arrayList=new ArrayList<Person>();
		try {
			psd=(PreparedStatement) connection.prepareStatement(sqlString);
			ResultSet rs=psd.executeQuery();
			while (rs.next()) {
				//鑾峰彇褰撳墠琛岀殑鏁版嵁
				int EmployeeID=rs.getInt("EmployeeID");
				String Ename=rs.getString("Ename");
				String sex=rs.getString("sex");
				int age=rs.getInt("Age");
				String position=rs.getString("Position");
				
				//鏍规嵁鑾峰彇鐨勬暟鎹紝鍒涘缓涓�釜Person瀵硅薄
				Person writing=new Person();
				writing.setEmployeeID(EmployeeID);
				writing.setEname(Ename);
				writing.setSex(sex);
				writing.setAge(age); 
				writing.setPosition(position);
				person.setSex(toString());
				
				//灏嗗垱寤虹殑瀵硅薄锛屾坊鍔犲埌闆嗗悎涓�
				arrayList.add(person);
				
			}
			return arrayList;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
}
public static void main(String[] args) {
	Person person=new Person();
	person.setEmployeeID(6);
	PersonService  personService=new PersonService();
	personService.getAllPerson();
}
}

	
	