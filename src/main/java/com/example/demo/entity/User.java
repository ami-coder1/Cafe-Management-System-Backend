package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uid")
	private int userId;
	
	@Column(name = "uname")
	private String userName;
	
	@Column(name = "uaddress")
	private String userAddress;
	
	@Column(name = "umobile")
	private String userMobile;
	
	@Column(name = "uemail")
	private String userEmail;
	
	@Column(name = "upassword")
	private String userPassword;

	public User() {
		
	}

	public User(int userId, String userName, String userAddress, String userMobile, String userEmail,
			String userPassword) {
		
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.userMobile = userMobile;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", userMobile="
				+ userMobile + ", userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
	
}

