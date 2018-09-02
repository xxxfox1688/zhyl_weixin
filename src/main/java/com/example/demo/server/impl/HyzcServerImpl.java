package com.example.demo.server.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.HyzcMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserEntity;
import com.example.demo.server.IHyzcServer;
import com.example.demo.util.StringUtil;

//@ComponentScan("com.example.demo.dao")
@Service("hyzcServer")
public class HyzcServerImpl implements IHyzcServer {
	
	@Autowired
	private HyzcMapper hyzcMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(User user) {
		user.setUser_seq(StringUtil.getUUID());
		int i = hyzcMapper.addUser(user);
		return i;
	}

	@Override
	public void insert(UserEntity user) {
		userMapper.insert(user);
	}

}
