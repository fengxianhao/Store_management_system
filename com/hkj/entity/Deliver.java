package com.hkj.entity;

import java.util.Date;

public class Deliver {
	private int addressID;
	private Orders ordersID;
	private String address;
	private String startdate;
	private String deliveryDate;
	private int employeeID;
	private Employee employee;
	
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public int getAddressID() {
		return addressID;
	}
	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}
	public Orders getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(Orders ordersID) {
		this.ordersID = ordersID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	
	
}
