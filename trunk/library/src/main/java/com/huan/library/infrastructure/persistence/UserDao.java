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
	public List<User> selectUsers(UserView view) ;
	
	/**
	 * 查找User
	 * @return
	 */
	public User getById(Long userId) ;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @
	 */
	public LoginState getUserLoginState(User user)  ;
	
	/**
	 * 
	 * @param user
	 * @return
	 * @
	 */
	public User getUserRole(User user)   ;
}
