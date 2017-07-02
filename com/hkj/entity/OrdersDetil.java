package com.hkj.entity;

public class OrdersDetil {
	private int ordersDetilID;
	private int ordersID;
	private String goodsID;
	private int number;
	private Double allprice;
	private Goods goods;
	private Orders orders;
	
	
	public int getOrdersDetilID() {
		return ordersDetilID;
	}
	public void setOrdersDetilID(int ordersDetilID) {
		this.ordersDetilID = ordersDetilID;
	}
	public int getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(int ordersID) {
		this.ordersID = ordersID;
	}
	public String getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(String string) {
		this.goodsID = string;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Double getAllprice() {
		return allprice;
	}
	public void setAllprice(Double allprice) {
		this.allprice = allprice;
	}
	
}
