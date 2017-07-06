package com.hkj.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.relation.RelationSupport;

import com.hkj.db.DbConnection;
import com.hkj.entity.Goods;
import com.hkj.entity.GoodsEmp;
import com.hkj.entity.OrdersDetil;
import com.mysql.jdbc.PreparedStatement;

import fxh.com.hkj.db.DbHelper_F;


public class Service1 {
	private static Connection conn=null;
	private static PreparedStatement pst=null;
	private static ResultSet res=null;
	
	//��ѯ�Զ��巽��
	public static ResultSet runSelectRes(String sql) {
		try {
			//����getConnection()������ȡ���Ӷ���
			conn=DbHelper_F.getConnection();
			//�������Ӷ���conn��prepareStatement��������Ԥ����������
			pst=(PreparedStatement) conn.prepareStatement(sql);
			//����Ԥ����������pst��executeQuery����ִ�в�ѯ�����ѷ���ֵ
			res=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<GoodsEmp> query4(String StorageDate1,String StorageDate2){
		java.sql.PreparedStatement pStat=null;
		ResultSet rs=null;
		try {
			conn=(Connection) DbConnection.getConnection();
			String sql="SELECT StorageID,GoodsID,GName,Type,StorageNumber,StorageDate,Charge FROM goods where StorageDate>=? and StorageDate<=?";
			pStat=conn.prepareStatement(sql);
			pStat.setString(1,StorageDate1);
			pStat.setString(2,StorageDate2);
			rs=pStat.executeQuery();
			ArrayList<GoodsEmp> list=new ArrayList<GoodsEmp>();
			while(rs.next()){
				GoodsEmp pr=new GoodsEmp();
				int StorageID=rs.getInt("StorageID");
				int goodsID=rs.getInt("GoodsID");
				String gName=rs.getString("GName");
				String type=rs.getString("Type");
				int storagenumber=rs.getInt("StorageNumber");
				String storageDate=rs.getString("StorageDate");
				String charge=rs.getString("Charge");
				
				pr.setStorageID(StorageID);
				pr.setGoodsID(goodsID);
				pr.setGName(gName);
				pr.setType(type);
				pr.setStorageNumber(storagenumber);
				pr.setStorageDate(storageDate);
				pr.setCharge(charge);
				list.add(pr);
			}
			
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
