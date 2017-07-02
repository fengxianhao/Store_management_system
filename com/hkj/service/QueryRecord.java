package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;

public class QueryRecord {
	
	//≤È—Ø
			public List<GoodsEmp> queryEmp(){
				Connection conn=null;
				PreparedStatement pStat=null;
				ResultSet re=null;
				//List<GoodsEmp> goodslist = null;
				
				try {
					
					conn=DbConnection.getConnection();
					String sql="select StorageID,GoodsID,GName,Type,StorageNumber,StorageDate,Charge from goods";
					pStat=conn.prepareStatement(sql);
					re=pStat.executeQuery();
					
					List<GoodsEmp> goodslist=new ArrayList<GoodsEmp>();
					
					while (re.next()) {
						int storageID=re.getInt("StorageID");
						int goodsID=re.getInt("GoodsID");
						String gName=re.getString("GName");
						String type=re.getString("Type");
						int storageNumber=re.getInt("StorageNumber");
						String storageDate=re.getString("StorageDate");
						String charge=re.getString("Charge");

						
						//System.out.println(storageID+goodsID+gName+type);
						
						GoodsEmp emp=new GoodsEmp();
						
						emp.setStorageID(storageID);
						emp.setGoodsID(goodsID);
						emp.setGName(gName);
						emp.setType(type);
						emp.setStorageNumber(storageNumber);
						emp.setStorageDate(storageDate);
						emp.setCharge(charge);

						
						goodslist.add(emp);
					}
					
					return goodslist;
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally{
					
						
					try {
						if (re!=null) {
							re.close();
						}
						if (pStat!=null) {
							
						pStat.close();
						
						}
						if (conn!=null) {
							
							conn.close();
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
					
				return null;
			}
	
}
