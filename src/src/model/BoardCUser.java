package model;

import java.io.Serializable;

public class BoardCUser implements Serializable{
	private String id;
	private String board_id;
	private String sender_id;
	private String comment;
	private String date;
	private String user_name;  //ユーザー名
	private String icon;  //アイコン


	public BoardCUser(String id, String board_id, String sender_id, String comment, String date, String user_name,
			String icon) {
		super();
		this.id = id;
		this.board_id = board_id;
		this.sender_id = sender_id;
		this.comment = comment;
		this.date = date;
		this.user_name = user_name;
		this.icon = icon;
	}

	public BoardCUser() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}



}
