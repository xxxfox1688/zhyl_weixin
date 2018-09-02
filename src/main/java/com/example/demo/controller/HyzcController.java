package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserEntity;
import com.example.demo.server.IHyzcServer;
import com.example.demo.util.UserSexEnum;

@RequestMapping(value="hyzc")
@Controller
//@ComponentScan("com.example.demo.server")
//@MapperScan("com.example.demo.dao")
public class HyzcController {
	@Resource
	private IHyzcServer hyzcServer;
	
	@GetMapping("/hyzc")
	public String index(Model model) {
		model.addAttribute("msg","Hello World 1112");
		return "hyzc/hyzc";
	}
	
	@GetMapping("/hyzc_jj")
	public String hyzc_jj(Model model) {
		return "hyzc/hyzc_jj";
	}
	
	
	@PostMapping("/addUser")
	@ResponseBody
	public Map addUser(User user,Model model) {
		Map map = new HashMap();
		String result;
		int i = hyzcServer.addUser(user);
		if (i>0) {
			 result = "000000";
		} else {
			 result = "999999";
		}
		map.put("success", result);
		return map;
	}
	
	@RequestMapping("/add")
    public String save(UserEntity user) {
    	user = new UserEntity("aa", "a123456", UserSexEnum.MAN);
    	hyzcServer.insert(user);
    	return "hyzc/hyzc";
    }
	
}
