package com.uwebs.demo.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.interceptor.annotations.Before;
import com.uwebs.demo.service.UserServiceI;
import com.uwebs.demo.service.impl.VipCustomerServiceI;

public class TestSpring {

	private UserServiceI userService;
	private VipCustomerServiceI vipCustomerService;
	@Before
    public void before(){
		System.out.println("befor");
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
        userService = (UserServiceI) ac.getBean("userService");
    }
	
    @Test
    public void test(){
        //ͨ��spring.xml�����ļ�����Spring��Ӧ�ó��������Ļ���
        //ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
    	//ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
        //��Spring��IOC�����л�ȡbean����
        //UserServiceI userService = (UserServiceI) ac.getBean("userService");
        //ִ�в��Է���
    	
    	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
        userService = (UserServiceI) ac.getBean("userService");
        
        
        userService.test();
        userService.getlist();
    }
    
    @Test
    public void vipcustomer()
    {
    	ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"spring.xml","spring-hibernate.xml"});
    	vipCustomerService = (VipCustomerServiceI) ac.getBean("vipCustomerService");
        
    	vipCustomerService.get_list();
    }
}
