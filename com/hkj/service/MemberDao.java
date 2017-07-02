package com.hkj.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hkj.db.DbConnection;
import com.hkj.db.DbConnection1;
import com.hkj.entity.Vip;
import com.hkj.service.BasicDao;


/**
 * 
 * @author 閮櫤鍕�
 * 
 *         Store_management_system MemberDao.java 涓嬪崍1:51:51
 */
public class MemberDao implements BasicDao<Vip> {

	/**
	 * 娣诲姞VIP 浼氬憳
	 */
	@Override
	public int insert(String ip, Vip t) throws Exception {
		Connection connection = null;
		PreparedStatement psd = null;
		try {
			String sql = "insert into vip(VIPID,VName,Sex,Age,IDcard,phone,Address,cDate,number,Live)"
					+ " values(null,?,?,?,?,?,?,now(),?,?)";
			connection = DbConnection.getConnection();
			psd = connection.prepareStatement(sql);
			psd.setString(1, t.getvName());
			psd.setString(2, t.getSex());
			psd.setInt(3, t.getAge());
			psd.setString(4, t.getIdCard());
			psd.setString(5, t.getPhone());			
			psd.setString(6, t.getAddress());
			psd.setString(7, t.getNumber());
			psd.setInt(8, t.getLive());
			return psd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection1.closeConnection(psd, connection);
		}
		
		return 0;
	}

	/**
	 * 淇敼浼氬憳淇℃伅
	 */
	@Override
	public int update(String ip, Vip t) throws Exception {
		Connection con = DbConnection1.getConnection();
		Statement stmt = null;
		String sqlUpdate = "UPDATE vip SET VName=" 
				+ DbConnection1.quote(t.getvName()) + 
				",Sex=" + DbConnection1.quote(t.getSex()) 
				+ 
				",Age=" + t.getAge()
				+ 
				",IDcard=" + DbConnection1.quote(t.getIdCard())
				+ 
				",phone=" + DbConnection1.quote(t.getPhone())
				+ 
				",Address=" + DbConnection1.quote(t.getAddress())
				+ 
				",number=" + DbConnection1.quote(t.getNumber())
				+ 
				",Live=" + t.getLive()
				+ " WHERE VIPID=" + t.getVipId();
		try {
			stmt = con.createStatement();
			return stmt.executeUpdate(sqlUpdate);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(stmt, con);
		}
	}

	/**
	 * 鏍规嵁sql 鏇存敼浼氬憳淇℃伅
	 */
	@Override
	public int update(String ip, String sql) throws Exception {
		Connection con = DbConnection1.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(stmt, con);
		}
	}

	/**
	 * 鏍规嵁id鍒犻櫎浼氬憳
	 */
	@Override
	public int delete(String ip, int id) throws Exception {
		Connection con = DbConnection.getConnection();
		Statement stmt = null;
		String sqlDel = "DELETE FROM vip WHERE VIPID=" + id;
		
		try {
			stmt = con.createStatement();
			return stmt.executeUpdate(sqlDel);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(stmt,con);
		}		
	}

	/**
	 * 鏍规嵁sql鍒犻櫎
	 */
	@Override
	public int delete(String ip, String sql) throws Exception {
		Connection con = DbConnection.getConnection();
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			return stmt.executeUpdate(sql);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(stmt,con);
		}		
	}

	/**
	 * 鍒犻櫎鍏ㄩ儴
	 */
	@Override
	public int delete(String ip) throws Exception {
		Connection con = DbConnection.getConnection();
		Statement stmt = null;
		String sqlDel = "DELETE FROM vip";
		
		try {
			stmt = con.createStatement();
			return stmt.executeUpdate(sqlDel);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(stmt,con);
		}		
	}

	@Override
	public Vip findById(String ip, int id) throws Exception {
		Connection con = DbConnection.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM vip WHERE VIPID=" + id;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			if(rs.next()) {
				Vip vip = new Vip();
				vip.setVipId(rs.getInt("VIPID"));
				vip.setvName(rs.getString("VName"));
				vip.setSex(rs.getString("Sex"));
				vip.setAge(rs.getInt("Age"));
				vip.setIdCard(rs.getString("IDcard"));
				vip.setPhone(rs.getString("phone"));
				vip.setAddress(rs.getString("Address"));
				vip.setDate(rs.getDate("cDate"));
				vip.setNumber(rs.getString("number"));
				vip.setLive(rs.getInt("Live"));
				
				return vip;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(rs,stmt,con);
		}
	}

	@Override
	public Vip findOne(String ip, String filter) throws Exception {
		Connection con = DbConnection1.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM vip WHERE " + filter;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			if(rs.next()) {
				Vip vip = new Vip();
				vip.setVipId(rs.getInt("VIPID"));
				vip.setvName(rs.getString("VName"));
				vip.setSex(rs.getString("Sex"));
				vip.setAge(rs.getInt("Age"));
				vip.setIdCard(rs.getString("IDcard"));
				vip.setPhone(rs.getString("phone"));
				vip.setAddress(rs.getString("Address"));
				vip.setDate(rs.getDate("cDate"));
				vip.setNumber(rs.getString("number"));
				vip.setLive(rs.getInt("Live"));
				
				return vip;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(rs,stmt,con);
		}
	}

	@Override
	public List<Vip> findAll(String ip) throws Exception {
		Connection con = DbConnection1.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM vip order by VIPID";
		List<Vip> vips = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			vips = new ArrayList<Vip>();
			while(rs.next()) {
				Vip vip = new Vip();
				vip.setVipId(rs.getInt("VIPID"));
				vip.setvName(rs.getString("VName"));
				vip.setSex(rs.getString("Sex"));
				vip.setAge(rs.getInt("Age"));
				vip.setIdCard(rs.getString("IDcard"));
				vip.setPhone(rs.getString("phone"));
				vip.setAddress(rs.getString("Address"));
				vip.setDate(rs.getDate("cDate"));
				vip.setNumber(rs.getString("number"));
				vip.setLive(rs.getInt("Live"));
				
				vips.add(vip);
			}
			return vips;
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(rs,stmt,con);
		}
	}

	@Override
	public List<Vip> detailFind(String ip, String filter) throws Exception {
		Connection con = DbConnection1.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlSelect = "SELECT * FROM vip WHERE " + filter;
		List<Vip> vips = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sqlSelect);
			vips = new ArrayList<Vip>();
			while(rs.next()) {
				Vip vip = new Vip();
				vip.setVipId(rs.getInt("VIPID"));
				vip.setvName(rs.getString("VName"));
				vip.setSex(rs.getString("Sex"));
				vip.setAge(rs.getInt("Age"));
				vip.setIdCard(rs.getString("IDcard"));
				vip.setPhone(rs.getString("phone"));
				vip.setAddress(rs.getString("Address"));
				vip.setDate(rs.getDate("cDate"));
				vip.setNumber(rs.getString("number"));
				vip.setLive(rs.getInt("Live"));
				
				vips.add(vip);
			}
			return vips;
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(rs,stmt,con);
		}
	}

	@Override
	public int count(String ip, String filter) throws Exception {
		Connection con = DbConnection1.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT count(*) FROM vip WHERE " + filter;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			throw new SQLException(e);
		} finally {
			DbConnection1.closeConnection(rs,stmt,con);
		}
	}
	
	

}
