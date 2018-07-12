package org.examples.jasper;

public class TestClass {

	private String userName;
	private String userAge;
	
	public TestClass(String string, String string2) {
		this.userName = string;
		this.userAge = string2;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	
}
