package Medlife.model;

public class User {

	private int userID;
	private String username;
	private String phone_number;
	private String email;
	private String password;
	
	public User(String username,  String phonenumber , String email, String password) {
		super();
		this.userID = userID;
		this.username = username;
		this.phone_number = phonenumber;
		this.email = email;
		this.password = password;
	}
	
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public String toString() {
		return "UserID: " + userID + "username: " + username + "phone_number: " + phone_number +"Email: " + email + " Password: " + password;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getMobile_number() {
		return phone_number;
	}

	public void setMobile_number(String mobile_number) {
		this.phone_number = mobile_number;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}