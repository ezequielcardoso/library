package com.huan.library.domain.service;

import java.util.List;

import com.huan.library.constant.LoginState;
import com.huan.library.domain.model.rights.User;
import com.huan.library.web.view.UserView;

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
	public User addOrModifyUser(User user) throws Exception;
	
	/**
	 * 根据id删除User
	 * @param user
	 * @return
	 */
	public void removeUser(User user) throws Exception;
	
	/**
	 * 根据userId 查找User
	 * @param userId
	 * @return
	 */
	public User getUserById(Long userId) throws Exception;
	
	/**
	 * 查找所有的User
	 * @return
	 */
	public List<User> findUsers(UserView view) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public LoginState getUserLoginState(User user) throws Exception ;
	
	/**
	 * 
	 * @param sysUser
	 * @return
	 * @throws Exception
	 */
	public User getUserRole(User sysUser)  throws Exception ;
}
