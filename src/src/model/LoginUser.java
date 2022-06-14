package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_id;	// ログイン時のID

	public LoginUser() {
		this(null);
	}

	public LoginUser(String id) {
		this.user_id = id;
	}

	public String getId() {
		return user_id;
	}

	public void setUserId(String id) {
		this.user_id = id;
	}
}
