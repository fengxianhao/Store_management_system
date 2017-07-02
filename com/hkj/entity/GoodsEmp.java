package com.hkj.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;





public class GoodsEmp {
	private int GoodsID;
	private String GName;
	private String Price;
	private String Type;
	private int StorageID;
	private int StorageNumber;
	private String StorageDate;
	private String Charge;
	private int StockNumber;
	
	
	public int getGoodsID() {
		return GoodsID;
	}
	public void setGoodsID(int goodsID) {
		GoodsID = goodsID;
	}
	public String getGName() {
		return GName;
	}
	public void setGName(String gName) {
		GName = gName;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price2) {
		Price = price2;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getStorageID() {
		return StorageID;
	}
	public void setStorageID(int storageID) {
		StorageID = storageID;
	}
	public int getStorageNumber() {
		return StorageNumber;
	}
	public void setStorageNumber(int storageNumber) {
		StorageNumber = storageNumber;
	}
	public String getStorageDate() {
		return StorageDate;
	}
	public void setStorageDate(String storageDate) {
		StorageDate = storageDate;
	}
	public String getCharge() {
		return Charge;
	}
	public void setCharge(String charge) {
		Charge = charge;
	}

	public int getStockNumber() {
		return StockNumber;
	}
	public void setStockNumber(int stockNumber) {
		StockNumber = stockNumber;
	}
	
	public GoodsEmp(int goodsID, String gName, String price,String type,int storageID,int storageNumber,String storageDate,String charge,int stockNumber) {
		super();
		this.GoodsID = goodsID;
		this.GName = gName;
		this.Price = price;
		this.Type=type;
		this.StorageID=storageID;
		this.StorageNumber=storageNumber;
		this.StorageDate=storageDate;
		this.Charge=charge;
		this.StockNumber=stockNumber;
	}
	
	public GoodsEmp() {
		super();
	}
	
	
	public static void main(String[] args) {
		
//		Connection conn=DbConnection.getConnection();
//		System.out.println(conn);
//		
//		QueryRegister emp=new QueryRegister();
//		emp.queryEmp();
		
		
	}
}
