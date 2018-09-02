package com.example.demo.server;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserEntity;

public interface IHyzcServer {
	public abstract int addUser(User user);

	public abstract void insert(UserEntity user);
}
