package com.hkj.service;

import java.util.List;

import com.hkj.entity.Vip;


/**
 * 
 * @author 閮櫤鍕�
 *
 * Store_management_system
 * MemberServiceImpl.java
 * 涓嬪崍3:25:38
 */
public class MemberServiceImpl implements BasicService<Vip> {

	MemberDao md = new MemberDao();
	
	@Override
	public boolean insertOrUpdate(String ip, Vip t, boolean isUpdate)
			throws Exception {
		try {
			if(isUpdate) 
				md.update(ip, t);
			else 
				md.insert(ip, t);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean update(String ip, String sql) throws Exception {
		try {
			md.update(ip, sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String ip, int id) throws Exception {
		try {
			md.delete(ip, id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String ip, String sql) throws Exception {
		try {
			md.delete(ip, sql);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String ip) throws Exception {
		try {
			md.delete(ip);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Vip findById(String ip, int id) throws Exception {
		try {
			return md.findById(ip, id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Vip findOne(String ip, String filter) throws Exception {
		try {
			return md.findOne(ip, filter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Vip> findAll(String ip) throws Exception {
		try {
			return md.findAll(ip);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Vip> detailFind(String ip, String filter) throws Exception {
		try {
			return md.detailFind(ip, filter);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int count(String ip, String filter) throws Exception {
		try {
			return md.count(ip, filter);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
