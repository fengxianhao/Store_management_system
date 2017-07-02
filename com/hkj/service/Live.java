package com.hkj.service;

/**
 * 
 * @author 郭智勇
 *
 * Store_management_system
 * Live.java
 * 上午11:02:23
 */
public class Live {

	//会员级别
	private int live;
	//会员折扣
	private double discount;
	public int getLive() {
		return live;
	}
	
	public Live(){
		
	}
	
	public Live(int live, int discount) {
		super();
		this.live = live;
		this.discount = discount;
	}

	public void setLive(int live) {
		this.live = live;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
}
