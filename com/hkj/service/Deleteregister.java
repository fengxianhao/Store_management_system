package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.hkj.db.DbConnection;


public class Deleteregister {
	//ɾ��
	
	public int delectgoods(int emp){
		
		Connection conn=null;
		
		PreparedStatement ps=null;
		
		try {
			
			conn=DbConnection.getConnection();//��ȡ���ݿ�����
			
			String sql="DELETE FROM goods WHERE GoodsID=?";
			
			
			ps=conn.prepareStatement(sql);
			
			ps.setInt(1,emp );
			
			int flag=ps.executeUpdate();
			
			if(flag>0){
				JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
				
			}else{
				//JOptionPane.showMessageDialog(null, "ɾ��ʧ�ܣ�");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			
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
		
		
		return 0;
	}
	
	public static void main(String[] args) {
//		GoodsEmp goodsEmp=new GoodsEmp();
//		goodsEmp.setGoodsID(10);
////		emp.setGName("sads");
////		emp.setPrice("30");
////		emp.setType("dasd");
//		
//		Deleteregister deleteregister=new Deleteregister();
//		deleteregister.delectgoods(goodsEmp);
	}
}
