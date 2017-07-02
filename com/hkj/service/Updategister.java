package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;

public class Updategister {
	//修改
	
	public boolean updategoods(GoodsEmp emp){
		
		Connection conn=null;
		
		PreparedStatement ps=null;
		
		// List<Emp> goodslist = null;
		
		try {
			conn=DbConnection.getConnection();//获取数据库连接
			
			String sql="update goods set GName=?,Price=?,Type=? where GoodsID=?";
			
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, emp.getGName());
			ps.setString(2, emp.getPrice());
			ps.setString(3, emp.getType());
			ps.setInt(4, emp.getGoodsID());
			
			
//			ps.setInt(5, emp.getStorageID());
//			ps.setInt(6, emp.getStorageNumber());
//			ps.setString(7, emp.getStorageDate());
//			ps.setString(8, emp.getCharge());	
			
			
			int flag=ps.executeUpdate();
			
			if(flag>0){
				System.out.println("成功");
				JOptionPane.showMessageDialog(null, "修改成功！");
				
			}else{
				System.out.println("失败");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			
				
			try {
				if (ps!=null) {
					
				ps.close();
				
				}
				if (conn!=null) {
				
					conn.close();
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
			
			
	}
	
	public static void main(String[] args) {
//		GoodsEmp emp=new GoodsEmp();
//		emp.setGoodsID(9);
//		emp.setGName("g");
//		emp.setPrice("10");
//		emp.setType("12");
//		
//		Updategister updategister=new Updategister();
//		updategister.updategoods(emp);
//	}
}
}
