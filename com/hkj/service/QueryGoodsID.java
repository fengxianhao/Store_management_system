package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;


public class QueryGoodsID {

	DbConnection db=new DbConnection();
	//产品查询
	public List<GoodsEmp> query(int GoodsID){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<GoodsEmp> goodsList=new ArrayList<GoodsEmp>();

		try{

			String sql="select GoodsID,GName,Price,Type from goods where GoodsID=?";
			conn=(Connection) db.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, GoodsID);

			rs=ps.executeQuery();
			while(rs.next()){
				GoodsEmp goodsEmp =new GoodsEmp();
				goodsEmp.setGoodsID(rs.getInt("goodsID"));
				goodsEmp.setGName(rs.getString("GName"));
				goodsEmp.setPrice(rs.getString("Price"));
				goodsEmp.setType(rs.getString("Type"));
				goodsList.add(goodsEmp);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return goodsList;
	}






	//	int goodsID;
	//	
	//	public  List<GoodsEmp> queryEmp(String string){
	//		Connection conn=null;
	//
	//		PreparedStatement pStat=null;
	//
	//		ResultSet re=null;
	//
	//		List<GoodsEmp> goodslist = null;
	//
	//		try {
	//
	//			conn=DbConnection.getConnection();
	//			
	//		
	//			
	//			String sql="select GoodsID,GName,Price,Type from goods where goodsID=?";
	//			pStat=conn.prepareStatement(sql);
	//
	//			pStat.executeQuery(sql);
	//
	//			re=pStat.executeQuery(sql);
	//
	//			goodslist=new ArrayList<GoodsEmp>();
	//
	//			while (re.next()) {
	//
	//				int goodsID=re.getInt("GoodsID");
	//				String gName=re.getString("GName");
	//				String price=re.getString("Price");
	//				String type=re.getString("Type");
	//				
	//				//System.out.println(goodsID+gName+price+type);
	//
	//				GoodsEmp emp=new GoodsEmp();
	//
	//				emp.setGoodsID(goodsID);
	//				emp.setGName(gName);
	//				emp.setPrice(price);
	//				emp.setType(type);
	//
	//
	//				goodslist.add(emp);
	//			}
	//
	//		} catch (SQLException e) {
	//
	//			e.printStackTrace();
	//		}finally{
	//			try {
	//				if (re!=null) {
	//					re.close();
	//				}
	//				if (pStat!=null) {
	//					pStat.close();
	//				}
	//				if (conn!=null) {
	//					conn.close();
	//				}
	//			} catch (SQLException e) {
	//				e.printStackTrace();
	//			}
	//		}
	//		return goodslist;
	//	}

	/**
	 * 查询公用代码块
	 * @param sql
	 * @return
	 */
	public List<GoodsEmp> queryEmpByPrer(String sql){
		Connection conn=null;

		PreparedStatement pStat=null;

		ResultSet re=null;

		List<GoodsEmp> list=new ArrayList<GoodsEmp>();
		try{
			conn=DbConnection.getConnection();
			pStat=conn.prepareStatement(sql);
			re=	pStat.executeQuery(sql);

			if(re.next()){	
				GoodsEmp g=new GoodsEmp();

				g.setGoodsID(re.getInt("GoodsID"));
				g.setGName(re.getString("GName"));
				g.setPrice(re.getString("Price"));
				g.setType(re.getString("Type"));
				g.setStorageID(re.getInt("StorageID"));
				g.setStockNumber(re.getInt("StockNumber"));
				g.setStorageDate(re.getString("StorageDate"));
				g.setCharge(re.getString("Charge"));
				g.setStorageNumber(re.getInt("StorageNumber"));

				list.add(g);
			}

		} catch (Exception e) {
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
		return list;
	}

	/**
	 * 根据goodsID查询
	 * @param goodsID
	 * @return
	 */
	public List<GoodsEmp> queryEmpsByID(int goodsID){
		String sql="select * from goods where GoodsID="+goodsID;
		return queryEmpByPrer(sql);
	}
	/**
	 * 根据产品名称查询
	 * @param gName
	 * @return
	 */
	public List<GoodsEmp> queryEmpsByName(String gName){
		String sql="select * from goods where GName='"+gName+"'";
		return queryEmpByPrer(sql);
	}

	/**
	 * 根据产品类型查询
	 * @param type
	 * @return
	 */
	public List<GoodsEmp> queryEmpsByType(String type){
		String sql="select * form goods where Type='"+type+"'";
		return queryEmpByPrer(sql);
	}

	//	public static void main(String[] args) {
	//		Query1Register query1Register=new Query1Register();
	//		query1Register.queryEmp();
	//	}
}
