package com.uwebs.demo.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import com.opensymphony.xwork2.ActionSupport;

import com.uwebs.demo.service.UserServiceI;
import com.uwebs.demo.service.VipCustomerServiceI;

@ParentPackage("basePackage")
@Action(value="strust2Test")
@Namespace("/")
public class TestAction extends ActionSupport {
	
	public String execute() throws Exception {
		return super.execute();
	}
	
    /**
     * ע��userService
     */
    //@Autowired
    private UserServiceI userService;

    public UserServiceI getUserService() {
		return userService;
	}

	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	//@Autowired
    private VipCustomerServiceI vipCustomerService;
    
    public VipCustomerServiceI getVipCustomerService() {
		return vipCustomerService;
	}

	public void setVipCustomerService(VipCustomerServiceI vipCustomerService) {
		this.vipCustomerService = vipCustomerService;
	}

	/**
     * http://localhost:8080/SSHE/strust2Test!test.action
     * MethodName: test
     * Description: 
     * @author xudp
     */
    public void test(){
        userService.test();
        userService.getlist();
        //vipCustomerService.get_list();
    }
}
