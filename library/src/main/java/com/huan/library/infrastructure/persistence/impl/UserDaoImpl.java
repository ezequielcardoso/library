package com.huan.library.infrastructure.persistence.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.huan.library.domain.model.rights.User;
import com.huan.library.infrastructure.persistence.UserDao;
import com.huan.library.infrastructure.persistence.generic.HibernateDaoSupportBean;

/**
 * 
 * @author shuaizhichun
 * @time 2010-12-16 ����04:56:04
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupportBean implements UserDao {

	public boolean saveOrUpdateUser(User user) {
		try{
			this.getHibernateTemplate().saveOrUpdate(user);
		} catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean deleteUser(User user) {
		try{
//			this.getHibernateTemplate().delete(user.getUserId(),user);
		} catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}
	
	public List<User> selectAllUsers(){
		List<User> users = new ArrayList<User>();
		try{
			String hql = "from User ";
			users = this.getHibernateTemplate().find(hql);
		}catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}

	public User selectUserById(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> selectUsersByDeptId(String deptId) {
		// TODO Auto-generated method stub
		return null;
	}
}
