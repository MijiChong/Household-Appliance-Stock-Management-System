package application;

import java.util.Scanner;

public class UserInfo {
	Scanner sc = new Scanner(System.in);
	private String name;
	private String userID;

	public void setNameAndID(String name) {
		this.name = name;
		int index = name.lastIndexOf(' ');
		
		// if there is no spacing in name
		if (index == -1) {
			userID = "guest";
		} else {
			userID = name.charAt(0) + name.substring(index + 1);
		}
	}

	public String getName() {
		return name;
	}

	public String getUserID() {
		return userID;
	}
}
