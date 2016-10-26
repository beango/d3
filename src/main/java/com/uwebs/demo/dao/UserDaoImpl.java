package com.uwebs.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uwebs.demo.model.RES_VIPCUSTOMER;

@Transactional
@Repository("userDao")
public class UserDaoImpl implements UserDaoI {
    
    @Autowired
    private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<RES_VIPCUSTOMER> getlist() {
    	Session session = sessionFactory.openSession();
		//Session session = HibernateUtil.getSession();
    	/*try {
    	    session = sessionFactory.getCurrentSession();
    	} catch (HibernateException e) {
    	    session = sessionFactory.openSession();
    	}*/
    	
    	List<RES_VIPCUSTOMER> list = session.createQuery("select p from RES_VIPCUSTOMER p").list();
    	
    	return list;
    }
}