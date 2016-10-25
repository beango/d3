package com.uwebs.demo.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uwebs.demo.model.RES_VIPCUSTOMER;

@Service("vipCustomerService")
public class VipCustomerServiceImpl implements VipCustomerServiceI {
	
	@Autowired
    private SessionFactory sessionFactory;
	
    /*@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}*/
	
	public List<RES_VIPCUSTOMER> get_list() {
		Session session = sessionFactory.openSession();

		@SuppressWarnings("unchecked")
		List<RES_VIPCUSTOMER> personList = session.createQuery("select p from RES_VIPCUSTOMER p").list();
		
		return personList;
	}

	
	public RES_VIPCUSTOMER get(Integer pkid) {
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from RES_VIPCUSTOMER where pkid=:pkid");  
		query.setParameter("pkid", pkid);
		List<RES_VIPCUSTOMER> customers = query.list();
		if (customers != null && customers.size() > 0) {
			return customers.get(0);
		}
		return null;
	}

	public void save(RES_VIPCUSTOMER model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(model);
		tx.commit();
	}

	public void update(RES_VIPCUSTOMER model) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RES_VIPCUSTOMER old = get(model.getPkid());
		old.setResId(model.getResId());
		old.setMobile(model.getMobile());
		old.setReason(model.getReason());
		old.setCtime(old.getCtime());
		session.update(old);
		tx.commit();
	}
	
	public void delete(Integer pkid) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		RES_VIPCUSTOMER model = get(pkid);
		session.delete(model);
		tx.commit();
	}
}
