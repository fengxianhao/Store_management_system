package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.text.BreakIterator;

import javax.swing.JOptionPane;

import com.hkj.db.DbConnection;
import com.hkj.entity.GoodsEmp;



public class InserRegister {
	//���
	
		public boolean insergoods(GoodsEmp goodsEmp){
			
			Connection conn=null;
			
			PreparedStatement ps=null;
			
			// List<Emp> goodslist = null;
			
			try {
				String sql="insert into goods (goodsid,gname,price,type) values(?,?,?,?);";
				conn=DbConnection.getConnection();//��ȡ���ݿ�����
				ps=conn.prepareStatement(sql);
				
				ps.setInt(1, goodsEmp.getGoodsID());
				ps.setString(2, goodsEmp.getGName());
				ps.setString(3, goodsEmp.getPrice());
				ps.setString(4, goodsEmp.getType());
				
				try {
					int flag=ps.executeUpdate();
					
					if(flag>0){
						//System.out.println("�ɹ�");
						JOptionPane.showMessageDialog(null, "��ӳɹ���");
					}else{
						//JOptionPane.showMessageDialog(null, "���ʧ�ܣ�");
						//System.out.println("ʧ��");
					}
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "���������룡");
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
//			GoodsEmp goodsEmp=new GoodsEmp();
//			goodsEmp.setGoodsID(23);
//			goodsEmp.setGName("sads");
//			goodsEmp.setPrice("30");
//			goodsEmp.setType("dasd");
//			InserRegister inserRegister=new InserRegister();
//			inserRegister.insergoods(goodsEmp);
		}
}

			

