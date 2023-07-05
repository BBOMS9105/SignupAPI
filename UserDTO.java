package com.study.springboot.dto;

public class UserDTO {
	
	private int user_id;
	private String id;
	private String pw;
	private String name;
	private String email;
	private String profile_img;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	
	@Override
	public String toString() {
		return "UserDTO [user_id=" + user_id + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email
				+ ", profile_img=" + profile_img + "]";
	}

}
