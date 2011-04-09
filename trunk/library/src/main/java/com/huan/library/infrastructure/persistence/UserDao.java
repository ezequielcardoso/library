package com.huan.library.infrastructure.persistence;

import java.util.List;

import com.huan.library.constant.LoginState;
import com.huan.library.domain.model.rights.User;
import com.huan.library.web.view.UserView;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 下午04:55:26
 */
public interface UserDao extends BaseDao<User> {
	
	/**
	 * 根据条件查找所有的User
	 * @param deptId
	 * @return
	 */
	public List<User> selectUsers(UserView view) throws Exception;
	
	/**
	 * 查找User
	 * @return
	 */
	public User getById(Long userId) throws Exception;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public LoginState getUserLoginState(User user) throws Exception ;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User getUserRole(User user)  throws Exception ;
}
