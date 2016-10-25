package com.uwebs.demo.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.uwebs.demo.model.RES_VIPCUSTOMER;
import com.uwebs.demo.service.UserServiceI;
import com.uwebs.demo.service.impl.VipCustomerServiceImpl;

@Action(value = "VipCustomerAction")
@ParentPackage("basePackage")
@Namespace("/")
public class VipCustomerAction extends ActionSupport {
	private static final long serialVersionUID = 6872366878758961847L;
	private List<RES_VIPCUSTOMER> mapList;
	private RES_VIPCUSTOMER customer;
	private Integer pkid;

	@Autowired
	private VipCustomerServiceImpl vipCustomerService;

	public Integer getPkid() {
		return pkid;
	}

	public void setPkid(Integer pkid) {
		this.pkid = pkid;
	}

	public String execute() throws Exception {
		return super.execute();
	}

	public String list() {
		System.out.println("list");
		mapList = vipCustomerService.get_list();
		return SUCCESS;
	}

	public String add() {
		System.out.println("pkid" + pkid);
		if (pkid != null) {
			customer = vipCustomerService.get(pkid);
		}
		return SUCCESS;
	}

	public String save() {
		RES_VIPCUSTOMER old = null;// bl.get(customer.getPkid());
		if (old != null) {
			vipCustomerService.update(customer);
		} else {
			customer.setCtime(new Date());
			vipCustomerService.save(customer);
		}

		return SUCCESS;
	}

	public String delete() {
		vipCustomerService.delete(pkid);
		return SUCCESS;
	}

	/**
	 * @return the mapList
	 */
	public List<RES_VIPCUSTOMER> getMapList() {
		return mapList;
	}

	/**
	 * @param mapList
	 *            the mapList to set
	 */
	public void setMapList(List<RES_VIPCUSTOMER> mapList) {
		this.mapList = mapList;
	}

	public RES_VIPCUSTOMER getCustomer() {
		return customer;
	}

	public void setCustomer(RES_VIPCUSTOMER customerBean) {
		this.customer = customerBean;
	}
}