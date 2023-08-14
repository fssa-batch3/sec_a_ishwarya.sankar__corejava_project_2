package com.fssa.medlife1.registration.model;
import com.fssa.medlife1.*;
public class UserSign {
	
	    private static int id;
	    private static String username;
	    private static String password;
	    private String email;
	    private String type;
	    private static String phone;
		public static int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public static String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public static String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public static String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public static String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public UserSign(int id, String username, String password, String email, String type, String phone) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.email = email;
			this.type = type;
			this.phone = phone;
		}
		@Override
		public String toString() {
			return "UserSign [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email
					+ ", type=" + type + ", phone=" + phone + ", getId()=" + getId() + ", getUsername()="
					+ getUsername() + ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getType()="
					+ getType() + ", getPhone()=" + getPhone() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
	  

}