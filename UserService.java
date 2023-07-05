package com.study.springboot.service;

import com.study.springboot.dto.UserDTO;

public interface UserService {
	
	int login(UserDTO userDTO);
	int joinUser(UserDTO userDTO);
	int idDupCheck(UserDTO userDTO);
}
