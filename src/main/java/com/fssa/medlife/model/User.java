package com.fssa.medlife.model;

public class User {

	private String email;
	private String username;
	private String password;
	private String phonenumber;
	private String type;
	public boolean isDeleted;
	private int UserId;

	
	
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		this.UserId = userId;
	}

	public User() {
	}

	public User(String email, String username, String password, String phonenumber, String type, boolean isDeleted) {
		super();

		this.email = email;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.type = type;
		this.isDeleted = isDeleted;
	}

	public User(String email, String username, String password, String phonenumber, String type) {
		super();

		this.email = email;
		this.username = username;
		this.password = password;
		this.phonenumber = phonenumber;
		this.type = type;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String email, boolean isDeleted) {
		super();
		this.email = email;
		this.isDeleted = isDeleted;
	}

	public User(int userid2, String email2, String username2, String password2, String phoneNumber2, String type2,
			int deleted) {
		// TODO Auto-generated constructor stub
	}

	public User(String email2, String password2, String userType) {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public boolean getIsdoctor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", username=" + username + ", password=" + password + ", phonenumber="
				+ phonenumber + ", type=" + type + ", isDeleted=" + isDeleted + ", UserId=" + UserId + "]";

	}
}