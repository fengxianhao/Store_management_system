package com.hkj.service;

import java.util.List;


public interface BasicDao<T> {
	
	/**
	 * 插入对象
	 * @param ip
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int insert(String ip, T t) throws Exception;
	
	/**
	 * 修改对象
	 * @param ip
	 * @param sql
	 * @param t
	 * @return
	 * @throws Exception
	 */
	int update(String ip, T t) throws Exception;
	
	/**
	 * 修改多个对象
	 * @param ip
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	int update(String ip, String sql) throws Exception;
	
	/**
	 * 删除对象
	 * @param ip
	 * @param id
	 * @return
	 * @throws Exception
	 */
	int delete(String ip, int id) throws Exception;
	
	/**
	 * 删除多个对象
	 * @param ip
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	int delete(String ip, String sql) throws Exception;
	
	/**
	 * 删除对象
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	int delete(String ip) throws Exception;
	
	
	/**
	 * 查询对象
	 * @param ip
	 * @param id
	 * @return
	 * @throws Exception
	 */
	T findById(String ip, int id) throws Exception;
	
	/**
	 * 查询单个对象
	 * @param ip
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	T findOne(String ip, String filter) throws Exception;
	
	/**
	 * 查询列表
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	List<T> findAll(String ip) throws Exception;
	
	/**
	 * 详细查询
	 * @param ip
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	List<T> detailFind(String ip, String filter) throws Exception;
	
	/**
	 * 按照条件查询对象数量
	 * @param ip
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	int count(String ip, String filter) throws Exception;
	
	
}
