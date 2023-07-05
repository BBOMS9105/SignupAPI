package com.study.springboot.dao;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.dto.UserDTO;

@Mapper
public interface UserDAO {
	
	int loginUser(UserDTO userDTO);
	int joinUser(UserDTO userDTO);
	int idDupCheck(UserDTO userDTO);
}
