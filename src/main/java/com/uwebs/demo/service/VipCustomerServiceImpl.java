package com.uwebs.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.uwebs.demo.model.RES_VIPCUSTOMER;

//@Transactional
@Service("vipCustomerService")
public class VipCustomerServiceImpl implements VipCustomerServiceI {

	//@Autowired
	//private SessionFactory sessionFactory;

	@Autowired
	private SqlMapClient sqlMapClient;

	public List<RES_VIPCUSTOMER> get_list() {
		List<RES_VIPCUSTOMER> list = null;

		try {
			list = sqlMapClient.queryForList("selectAllCustomers");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public RES_VIPCUSTOMER get(Integer pkid) {
		RES_VIPCUSTOMER c = null;
		try {
			c = (RES_VIPCUSTOMER) sqlMapClient.queryForObject("selectVipCustomerById", pkid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void save(RES_VIPCUSTOMER model) {
		try {
			this.sqlMapClient.insert("insertVipCustomer", model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(RES_VIPCUSTOMER model) {
		try {
			Integer object = sqlMapClient.update("updateVipCustomer", model);
			System.out.println("返回值：" + object);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer pkid) {
		try {
			Integer object = sqlMapClient.delete("deleteVipCustomer", pkid);
			System.out.println("删除学生信息的返回值：" + object + "，这里返回的是影响的行数");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
