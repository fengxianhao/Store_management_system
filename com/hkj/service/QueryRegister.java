package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;

public class QueryRegister {
	//≤È—Ø
	public List<GoodsEmp> queryEmp(){
		Connection conn=null;
		PreparedStatement pStat=null;
		ResultSet re=null;
		List<GoodsEmp> goodslist = null;

		try {

			conn=DbConnection.getConnection();
			String sql="select GoodsID,GName,Price,Type from goods";
			pStat=conn.prepareStatement(sql);
			pStat.executeQuery(sql);
			re=pStat.executeQuery();

			goodslist=new ArrayList<GoodsEmp>();

			while (re.next()) {

				int goodsID=re.getInt("GoodsID");
				String gName=re.getString("GName");
				String price=re.getString("Price");
				String type=re.getString("Type");


				//System.out.println(goodsID+gName+price+type);

				GoodsEmp emp=new GoodsEmp();

				emp.setGoodsID(goodsID);
				emp.setGName(gName);
				emp.setPrice(price);
				emp.setType(type);


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
	//		public static void main(String[] args) {
	//			QueryRegister queryRegister=new QueryRegister();
	//			queryRegister.queryEmp();
	//		}
}
