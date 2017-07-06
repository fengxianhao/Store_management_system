package fxh.com.hkj.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.management.relation.RelationSupport;
import com.hkj.entity.Goods;
import com.hkj.entity.OrdersDetil;
import com.mysql.jdbc.PreparedStatement;

import fxh.com.hkj.db.DbHelper_F;


public class Service {
	private static Connection conn=null;
	private static PreparedStatement pst=null;
	private static ResultSet res=null;
	
	public static boolean runSelect(String sql) {
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
		return true;
	}
	
	
	
	
	
	
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
	//����Զ��巽��
	public static boolean runAddSql(String sql) {
		try {
			conn=DbHelper_F.getConnection();
			pst=(PreparedStatement) conn.prepareStatement(sql);
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				if(pst!=null){
					pst.close();
				} 
				if (conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	//�޸��Զ��巽��
	public static boolean runUpdateSql(String sql, Object[] params) {
		try {
			conn=DbHelper_F.getConnection();
			pst=(PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);//������
			}
			pst.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			try {
				if (pst!=null){
					pst.close();
				}
				if (conn!=null){
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
