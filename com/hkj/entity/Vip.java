package com.hkj.entity;

import java.util.Date;


/**
 * 
 * @author 郭智�?
 *
 * Store_management_system
 * Vip.java
 * 上午10:57:30
 */
public class Vip {
	
	private Integer vipId;
	private String vName;
	private String sex;
	private int age;
	private String idCard;
	private String phone;
	private String address;
	private Date date;
	private String number;
	private int live;
	public Integer getVipId() {
		return vipId;
	}
	public void setVipId(Integer vipId) {
		this.vipId = vipId;
	}
	public String getvName() {
		return vName;
	}
	public void setvName(String vName) {
		this.vName = vName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		
//		boolean target;
//		if(age>0||age<100){
//			target=true;
//			this.age=age;
//			
//		}else{
//			target=false;
//			System.out.println("对不起您输入的年龄有误！");
//			this.age;
//		}
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getLive() {
		return live;
	}
	public void setLive(int live) {
		this.live = live;
	}
	@Override
	public String toString() {
		return "Vip [vipId=" + vipId + ", vName=" + vName + ", sex=" + sex
				+ ", age=" + age + ", idCard=" + idCard + ", phone=" + phone
				+ ", address=" + address + ", date=" + date + ", number="
				+ number + ", live=" + live + "]";
	}
	public Vip(Integer vipId, String vName, String sex, int age, String idCard,
			String phone, String address, Date date, String number, int live) {
		super();
		this.vipId = vipId;
		this.vName = vName;
		this.sex = sex;
		this.age = age;
		this.idCard = idCard;
		this.phone = phone;
		this.address = address;
		this.date = date;
		this.number = number;
		this.live = live;
	}
	public Vip(String vName, String sex, int age, String idCard, String phone,
			String address, Date date, String number) {
		super();
		this.vName = vName;
		this.sex = sex;
		this.age = age;
		this.idCard = idCard;
		this.phone = phone;
		this.address = address;
		this.date = date;
		this.number = number;
	}
	public Vip(Integer vipId, String vName, String sex, int age, String idCard,
			String phone, String address, Date date, String number) {
		super();
		this.vipId = vipId;
		this.vName = vName;
		this.sex = sex;
		this.age = age;
		this.idCard = idCard;
		this.phone = phone;
		this.address = address;
		this.date = date;
		this.number = number;
	}
	
	public Vip(){
		
	}
	
}
