package com.uwebs.demo.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uwebs.demo.dao.UserDaoI;
import com.uwebs.demo.model.RES_VIPCUSTOMER;
import com.uwebs.demo.service.UserServiceI;

@Service("userService")
public class UserServiceImpl implements UserServiceI {
	
    @Autowired
    private UserDaoI userDao;
    
    @Autowired
    private SessionFactory sessionFactory;
    
	public UserDaoI getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	public void test() {
		System.out.println("Hello World!");
	}

	public List<RES_VIPCUSTOMER> getlist() {
		Session session = sessionFactory.openSession();

    	List<RES_VIPCUSTOMER> list = session.createQuery("select p from RES_VIPCUSTOMER p").list();
    	
    	return list;
	}

}
