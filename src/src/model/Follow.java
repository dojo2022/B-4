package model;

import java.io.Serializable;

public class Follow implements Serializable{
	private String id;	// ID
	private String follow_id;	// フォロー者ID
	private String followed_id;	// 被フォロー者ID
	private String user_name;	// ユーザー名

	public Follow(String id, String follow_id, String followed_id, String user_name) {
		super();
		this.id = id;
		this.follow_id = follow_id;
		this.followed_id = followed_id;
		this.user_name = user_name;
	}


	public Follow(String followed_id, String user_name) {
		super();
		this.followed_id = followed_id;
		this.user_name = user_name;
	}

	public Follow() {
		super();
		this.id = "";
		this.follow_id = "";
		this.followed_id = "";
		this.user_name = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFollow_id() {
		return follow_id;
	}

	public void setFollow_id(String follow_id) {
		this.follow_id = follow_id;
	}

	public String getFollowed_id() {
		return followed_id;
	}

	public void setFollowed_id(String followed_id) {
		this.followed_id = followed_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}



}



