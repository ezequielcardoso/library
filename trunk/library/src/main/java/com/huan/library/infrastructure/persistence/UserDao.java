package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.domain.model.rights.User;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:55:26
 */
public interface UserDao {
	
	/**
	 * 增加或者修改User
	 * @param user
	 */
	public void saveOrUpdateUser(User user) throws Exception;
	
	/**
	 * 根据id删除User
	 * @param user
	 */
	public void deleteUser(User user) throws Exception;
	
	/**
	 * 根据userId 查找User
	 * @param userId
	 * @return
	 */
	public User selectUserById(String userId) throws Exception;
	
	/**
	 * 根据deptId查找所有的User
	 * @param deptId
	 * @return
	 */
	public List<User> selectUsersByDeptId(String deptId) throws Exception;
	
	/**
	 * 查找所有的User
	 * @return
	 */
	public List<User> selectAllUsers() throws Exception;
}
