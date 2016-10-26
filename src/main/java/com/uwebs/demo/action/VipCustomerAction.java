package com.uwebs.demo.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import net.sf.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.uwebs.demo.model.RES_VIPCUSTOMER;
import com.uwebs.demo.service.VipCustomerServiceImpl;

//@Action(value = "VipCustomerAction")
//@ParentPackage("basePackage")
//@Namespace("/")
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
		return SUCCESS;
	}

	private JSONObject listResult;

	public JSONObject getListResult() {
		return listResult;
	}

	public void setListResult(JSONObject listResult) {
		this.listResult = listResult;
	}
	
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public String getlistjson() {
		mapList = vipCustomerService.get_list();
		// System.out.println(jsonArray);

		Integer total = mapList.size();

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", total);
		jsonObject.put("rows", mapList);
		// HttpServletResponse response = ServletActionContext.getResponse();
		// PrintWriter out =response.getWriter();
		// out.print(jsonObject);
		listResult = JSONObject.fromObject(jsonObject);
		// listResult = jsonArray.toString();

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
		RES_VIPCUSTOMER old = vipCustomerService.get(customer.getPkid());
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