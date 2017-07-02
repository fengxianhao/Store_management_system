package com.hkj.service;

import static org.junit.Assert.*;

import org.junit.Test;

import com.hkj.entity.Vip;



public class TestDao {

	@Test
	public void testInsert() {
		Vip vip = new Vip();
		vip.setvName("test");
		vip.setSex("鐢�");
		vip.setAge(12);
		vip.setIdCard("123456789012345678");
		vip.setPhone("12345678901");
		vip.setAddress("涓浗涓婃捣");
		vip.setNumber("1234");
		vip.setLive(1);
		MemberDao md = new MemberDao();
		try {
			md.insert("", vip);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateStringVip() {
		Vip vip = new Vip();
		vip.setVipId(5);
		vip.setvName("test123");
		vip.setSex("濂�");
		vip.setAge(12);
		vip.setIdCard("123456789012345678");
		vip.setPhone("12345678901");
		vip.setAddress("涓浗涓婃捣");
		vip.setNumber("1234");
		vip.setLive(1);
		MemberDao md = new MemberDao();
		try {
			md.update("", vip);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdateStringString() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteStringInt() {
		MemberDao md = new MemberDao();
		try {
			md.delete("", 5);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testDeleteStringString() {//
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteString() {//鍒犻櫎鍏ㄩ儴
		MemberDao md = new MemberDao();
		try {
			md.delete("");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testFindById() {
		MemberDao md = new MemberDao();
		Vip vip = null;
		try {
			vip = md.findById("", 11);
			System.out.println(vip);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Test
	public void testFindOne() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testDetailFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
