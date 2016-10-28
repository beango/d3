package com.uwebs.demo.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class HomeAction extends ActionSupport {
	public String execute() throws Exception {
		return super.execute();
	}

	private JSONObject listResult;

	public String leftMenuList() throws IOException {
		String json = "[{\"id\":1,\"text\":\"Photos\",\"children\":[{\"id\":11,\"text\":\"VIP_CUSTOMER\",\"url\":\""
	+ServletActionContext.getRequest().getContextPath()+"/RES_VIPCUSTOMER/list\"},{\"id\":12,\"text\":\"Wife\"},{\"id\":113,\"text\":\"Company\"}]}]";
		
		//setListResult(JSONObject.fromObject(json));
		
		//String data = JSONUtils.toJson(json).toString(); 
		
		List itemsList = new ArrayList<Map<String, Object>>();  
        for (int i = 0; i < 5; i++) {  
            Map<String, Object> item = new HashMap<String, Object>();  
            item.put("id", i);  
            item.put("text", i);  
            item.put("state", "closed");  
            // item.put("children", itemsList2);  
            itemsList.add(item);  
        }  
        String data = JSONArray.fromObject(itemsList).toString();
		ServletActionContext.getResponse().getWriter().write(json); 
		return null;
	}

	public JSONObject getListResult() {
		return listResult;
	}

	public void setListResult(JSONObject listResult) {
		this.listResult = listResult;
	}
}
