package com.onlinegrocery.dto;

import com.onlinegrocery.enums.Role;

public class LoginResponseDto {
	private Role role;
	private String userName;
	private String message;
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "LoginResponseDto [role=" + role + ", userName=" + userName + ", message=" + message + "]";
	}
	public LoginResponseDto(Role role, String userName, String message) {
		super();
		this.role = role;
		this.userName = userName;
		this.message = message;
	}
	public LoginResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}

