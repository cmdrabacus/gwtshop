package de.leuphana.internet.baseshop.shared;

public class BackendAccess {
	private String username;
	private String password;

	public BackendAccess() {
		username = "user";
		password = "pw";
	}

	public String getUser() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
