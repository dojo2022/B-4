package model;

import java.io.Serializable;

public class BoardUser implements Serializable{
	private String id;	// ID
	private String user_id;	  // ユーザーID
	private String title;	// タイトル
	private String text;  //説明欄
	private String date;  //作成日付
	private String dorc;  //犬猫選択
	private String user_name;  //ユーザー名
	private String icon;  //アイコン

	public BoardUser(String id, String user_id, String title, String text, String date, String dorc, String user_name,
			String icon) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.title = title;
		this.text = text;
		this.date = date;
		this.dorc = dorc;
		this.user_name = user_name;
		this.icon = icon;
	}

	public BoardUser() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDorc() {
		return dorc;
	}

	public void setDorc(String dorc) {
		this.dorc = dorc;
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
