package model;

import java.io.Serializable;

public class MypageUser implements Serializable{
	private String icon;	 // アイコン画像
	private String prefecture;	 // 都道府県
	private String user_name; //ユーザー名
	private String freespace; // フリースペース

	public MypageUser(String icon, String prefecture, String user_name, String freespace) {
		this.icon = icon;
		this.prefecture = prefecture;
		this.user_name = user_name;
		this.freespace = freespace;
	}
	public MypageUser() {
		this.icon = "";
		this.prefecture = "";
		this.user_name = "";
		this.freespace = "";
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getFreespace() {
		return freespace;
	}
	public void setFreespace(String freespace) {
		this.freespace = freespace;
	}

}



