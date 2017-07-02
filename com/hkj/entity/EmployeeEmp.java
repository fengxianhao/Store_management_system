package com.hkj.entity;

public class EmployeeEmp {
	private int EmployeeID;
	private String Ename;
	private String Sex;
	private String Age;
	private String Position;
	private String IDcard;
	private String phone;
	private String Address;
	private String cDate;
	private String Number;
	private String Pwd;
	private int PowerID;
	
	
	public int getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(int employeeID) {
		EmployeeID = employeeID;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getIDcard() {
		return IDcard;
	}
	public void setIDcard(String iDcard) {
		IDcard = iDcard;
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
		Address = address;
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
		Number = number;
	}
	public String getPwd() {
		return Pwd;
	}
	public void setPwd(String pwd) {
		Pwd = pwd;
	}
	public int getPowerID() {
		return PowerID;
	}
	public void setPowerID(int powerID) {
		PowerID = powerID;
	}
	
	public EmployeeEmp(int employeeID, String ename, String sex,String age,String position,String idcard,String Phone,String address,String CDate,String number,String pwd,int powerID) {
		super();
		this.EmployeeID = employeeID;
		this.Ename = ename;
		this.Sex = sex;
		this.Age=age;
		this.Position=position;
		this.IDcard=idcard;
		this.phone=Phone;
		this.Address=address;
		this.cDate=CDate;
		this.Number=number;
		this.Pwd=pwd;
		this.PowerID=powerID;
	}
	
	public EmployeeEmp() {
		super();
	}
}
