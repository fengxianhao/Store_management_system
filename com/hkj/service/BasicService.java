package com.hkj.service;

import java.util.List;

/**
 * 服务类接口
 * OTAP_Demo
 * Administrator郭智勇
 * 2016-3-7
 * 下午5:46:14
 *
 */
public interface BasicService<T>{


	
	/**
	 * 新增或者修改
	 * @param sql
	 * @param t
	 * @return
	 * @throws Exception
	 */
	boolean insertOrUpdate(String ip, T t, boolean isUpdate) throws Exception;
	
	
	
	/**
	 * 修改多个对象
	 * @param ip
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	boolean update(String ip, String sql) throws Exception;
	
	/**
	 * 删除对象
	 * @param ip
	 * @param id
	 * @return
	 * @throws Exception
	 */
	boolean delete(String ip, int id) throws Exception;
	
	/**
	 * 删除多个对象
	 * @param ip
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	boolean delete(String ip, String sql) throws Exception;
	
	/**
	 * 删除所有对象
	 * @param ip
	 * @return
	 * @throws Exception
	 */
	boolean delete(String ip) throws Exception;
	
	
	/**
	 * 查询一个对象
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
	 * 查询所有
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
