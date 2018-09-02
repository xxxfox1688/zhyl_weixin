package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.example.demo.pojo.User;

public interface HyzcMapper {
	@Insert("INSERT INTO zhyl_zchy (user_seq,user_name,phone,sex,birthdate,zjhm,dz) VALUES('${user_seq}','${user_name}',${phone},${sex},STR_TO_DATE('${birthdate}','%Y-%m-%d'),'${zjhm}','${dz}')")
	public int addUser(User user);
}
