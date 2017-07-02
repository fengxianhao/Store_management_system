package fxh.com.hkj.entity;

public class Goods {
	private int goodsID;
	private String gName;
	private String price;
	private String type;
	private int storageID;
	private int storageNumber;
	private String storageDate;
	
	
	
	public int getGoodsID() {
		return goodsID;
	}
	public void setGoodsID(int goodsID) {
		this.goodsID = goodsID;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String d) {
		this.price = d;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStorageID() {
		return storageID;
	}
	public void setStorageID(int storageID) {
		this.storageID = storageID;
	}
	public int getStorageNumber() {
		return storageNumber;
	}
	public void setStorageNumber(int storageNumber) {
		this.storageNumber = storageNumber;
	}
	public String getStorageDate() {
		return storageDate;
	}
	public void setStorageDate(String storageDate) {
		this.storageDate = storageDate;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	private String charge;
}
