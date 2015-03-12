package com.bsc.controller;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.alibaba.fastjson.JSONObject;
import com.bsc.common.AjaxUtils;

@Controller
@RequestMapping("/sys/index")
public class IndexController {
	

	@RequestMapping("/toUrl")
	public String index(String page){
		System.out.println("跳转到首页");
		if(StringUtils.isEmpty(page)){
			return "index";
		}else{
			return "pages/"+page;
		}
	}
	
	@RequestMapping(value="/res",method= RequestMethod.POST)
	public void resource(HttpServletResponse response){
		JSONObject object = new JSONObject();
		//Map<String, Object> resourceMap = resourcesService.getResources();
		//object.put("resourcesMap", resourceMap);
		String json = object.toJSONString();
		AjaxUtils.wirte(response, json);
	}
	
}
