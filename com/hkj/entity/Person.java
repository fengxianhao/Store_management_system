package com.hkj.entity;

import java.util.Date;



public class Person {
	int EmployeeID;
	String Ename;
	String Sex;
	int Age;
	String Position;
	String IDcard;
	String phone;
	String Address;
	String cDate;
	String Number;
	String Pwd;
	int PowerID;
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.EmployeeID = employeeID;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		this.Ename = ename;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		this.Sex = sex;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		this.Age = age;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		this.Position = position;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		this.IDcard = iDcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		this.Address = address;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		this.Number = number;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		this.Pwd = pwd;
	}
	public int getPowerID() {
		return PowerID;
	}
	public void setPowerID(int powerID) {
		this.PowerID = powerID;
	}
	public Person(int EmployeeID,String Ename,String sex,int Age,String Position,String IDcard,String phone,String Address,String cDate,String Number,String Pwd,
	int PowerID){
		super();
		this.EmployeeID=getEmployeeID();
		this.Ename=getEname();
		this.Sex=getSex();
		this.Age =getAge();
		this.Position=getPosition();
		this.IDcard=getIDcard();
		this.phone=getPhone();
		this.Address=getAddress();
		this.cDate=getcDate();
		this.Number=getNumber();
		this.Pwd=getNumber();
	}
	public Person(int EmployeeID,String Ename,String sex,int Age,String Position){
		super();
		this.EmployeeID=getEmployeeID();
		this.Ename=getEname();
		this.Sex=getSex();
		this.Age =getAge();
		this.Position=getPosition();
	}
	public Person(){
		super();
	}
}
