package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;

public class QueryStockNumber {
		
	
	//≤È—Ø
	public List<GoodsEmp> queryEmp(int StockNumber1,int StockNumber2){
		Connection conn=null;
		PreparedStatement pStat=null;
		ResultSet re=null;
		List<GoodsEmp> goodslist = null;
		
		try {
			
			conn=DbConnection.getConnection();
			
			String sql="SELECT GoodsID,GName,Type,StockNumber FROM goods WHERE StockNumber BETWEEN 100 and 1000";
			
			pStat=conn.prepareStatement(sql);
			
			re=pStat.executeQuery(sql);
			
			//re=pStat.executeQuery();
			
			goodslist=new ArrayList<GoodsEmp>();
			
			while (re.next()) {
				
				int goodsID=re.getInt("GoodsID");
				String gName=re.getString("GName");
				String type=re.getString("Type");
				int stockNumber1=re.getInt("StockNumber");
				int stockNumber2=re.getInt("StockNumber");
				

				
				System.out.println(goodsID+gName+type+stockNumber1);
				
				GoodsEmp emp=new GoodsEmp();
				
			
				emp.setGoodsID(goodsID);
				emp.setGName(gName);
				emp.setType(type);
				emp.setStockNumber(stockNumber1);
				emp.setStockNumber(stockNumber2);
				

				
				goodslist.add(emp);
			}
			
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
			
		return goodslist;
	}
	public static void main(String[] args) {
		
		
		QueryStockNumber queryStock=new QueryStockNumber();
		queryStock.queryEmp(100, 300);
	}
}