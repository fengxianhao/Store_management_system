package fxh.com.hkj.entity;

import java.util.Date;

public class Orders {
	private int ordersID;
	private String ordersDate;
	private String amount;
	private int vipID;
	private Vip vip;
	
	
	public int getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}
	public String getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(String date) {
		this.ordersDate = date;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getVipID() {
		return vipID;
	}
	public void setVipID(int vipID) {
		this.vipID = vipID;
	}
	public Vip getVip() {
		return vip;
	}
	public void setVip(Vip vip) {
		this.vip = vip;
	}
	
	
}
