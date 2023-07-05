package com.study.springboot.encryptor;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Encryptor {
	/**
	 * @author LSC
	 * @param user_pw
	 * @return
	 * 
	 * SHA-256 방식으로 비밀번호 암호화 하는 메소드
	 * 
	 * 
	 */
	public String encryptPassword(String user_pw) {

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] hashedPasswordBytes = md.digest(user_pw.getBytes(StandardCharsets.UTF_8));

			StringBuilder sb = new StringBuilder();

			for (byte b : hashedPasswordBytes) {
				sb.append(String.format("%02x", b));
			}

			// 암호화된 비밀번호 반환
			return sb.toString();

		} catch (Exception e) {
			e.printStackTrace();

			return null;
		}

	}
}