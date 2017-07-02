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
			//调用getConnection()方法获取连接对象
			conn=DbHelper_F.getConnection();
			//调用连接对象conn的prepareStatement方法生成预编译语句对象
			pst=(PreparedStatement) conn.prepareStatement(sql);
			//调用预编译语句对象pst的executeQuery方法执行查询，并把返回值
			res=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	
	
	//查询自定义方法
	public static ResultSet runSelectRes(String sql) {
		try {
			//调用getConnection()方法获取连接对象
			conn=DbHelper_F.getConnection();
			//调用连接对象conn的prepareStatement方法生成预编译语句对象
			pst=(PreparedStatement) conn.prepareStatement(sql);
			//调用预编译语句对象pst的executeQuery方法执行查询，并把返回值
			res=pst.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	//添加自定义方法
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

	//修改自定义方法
	public static boolean runUpdateSql(String sql, Object[] params) {
		try {
			conn=DbHelper_F.getConnection();
			pst=(PreparedStatement) conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pst.setObject(i+1, params[i]);//参数绑定
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
