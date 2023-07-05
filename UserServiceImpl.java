package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.dao.UserDAO;
import com.study.springboot.dto.UserDTO;
import com.study.springboot.encryptor.Encryptor;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	Encryptor encryptor;
	
	@Override
	public int login(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 성공하면 정수 1, 실패하면 정수 0을 반환
	@Override
	public int joinUser(UserDTO userDTO) {

		String encPw = encryptor.encryptPassword(userDTO.getPw());
		userDTO.setPw(encPw);
		
		int result = userDAO.joinUser(userDTO);
		
		return result;
	}

	@Override
	public int idDupCheck(UserDTO userDTO) {

		int result = userDAO.idDupCheck(userDTO);
		
		return result;
	}

}
