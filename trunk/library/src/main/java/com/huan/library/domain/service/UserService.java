package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.domain.model.rights.User;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:55:26
 */
public interface UserService {
	
	/**
	 * 增加或者修改User
	 * @param user
	 * @return
	 */
	public boolean addOrModifyUser(User user) throws Exception;
	
	/**
	 * 根据id删除User
	 * @param user
	 * @return
	 */
	public boolean removeUser(User user) throws Exception;
	
	/**
	 * 根据userId 查找User
	 * @param userId
	 * @return
	 */
	public User loadUserById(String userId) throws Exception;
	
	/**
	 * 根据deptId查找所有的User
	 * @param deptId
	 * @return
	 */
	public List<User> findUsersByDeptId(String deptId) throws Exception;
	
	/**
	 * 查找所有的User
	 * @return
	 */
	public List<User> findAllUsers() throws Exception;
}
