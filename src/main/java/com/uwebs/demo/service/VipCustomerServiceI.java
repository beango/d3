package com.uwebs.demo.service;

import java.util.List;

import com.uwebs.demo.model.RES_VIPCUSTOMER;
import com.uwebs.demo.model.RES_VIPCUSTOMER_MAP;

public interface VipCustomerServiceI {
	List<RES_VIPCUSTOMER> get_list();
	
	List<RES_VIPCUSTOMER_MAP> get_list2();
}
