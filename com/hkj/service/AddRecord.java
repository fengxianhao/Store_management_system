package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;


public class AddRecord {
		//��Ӳ�Ʒ����¼
		public boolean updategoods(GoodsEmp emp){
			
			Connection conn=null;
			
			PreparedStatement ps=null;
			
			// List<Emp> goodslist = null;
			
			try {
				conn=DbConnection.getConnection();//��ȡ���ݿ�����
				
				String sql="update goods set StorageID=?,StorageNumber=storageNumber+?,StorageDate=?,Charge=? where GoodsID=?";
				
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, emp.getStorageID());
				ps.setInt(2, emp.getStorageNumber());
				ps.setString(3, emp.getStorageDate());
				ps.setString(4, emp.getCharge());
				ps.setInt(5, emp.getGoodsID());
				
				
//				ps.setInt(5, emp.getStorageID());
//				ps.setInt(6, emp.getStorageNumber());
//				ps.setString(7, emp.getStorageDate());
//				ps.setString(8, emp.getCharge());	
				
				
				int flag=ps.executeUpdate();
				
				if(flag>0){
					//System.out.println("�ɹ�");
					JOptionPane.showMessageDialog(null, "��ӳɹ���");
					
				}else{
					//System.out.println("ʧ��");
					JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
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
//			GoodsEmp emp=new GoodsEmp();
//			emp.setGoodsID(9);
//			emp.setGName("g");
//			emp.setPrice("10");
//			emp.setType("12");
//			
//			Updategister updategister=new Updategister();
//			updategister.updategoods(emp);
//		}
}


}
