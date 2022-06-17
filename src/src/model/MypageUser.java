package model;

import java.io.Serializable;

public class MypageUser implements Serializable{
	private String icon;	 // アイコン画像
	private String address;	 // 都道府県
	private String user_name; //ユーザー名
	private String freespace; // フリースペース
	private String user_id;

	public String getUser_id() {
		return user_id;
	}
	public void setId(String user_id) {
		this.user_id = user_id;
	}
	public MypageUser(String icon, String address, String user_name, String freespace) {
		this.icon = icon;
		this.address = address;
		this.user_name = user_name;
		this.freespace = freespace;
	}
	public MypageUser(String icon, String address, String user_name, String freespace,String user_id) {
		this.icon = icon;
		this.address = address;
		this.user_name = user_name;
		this.freespace = freespace;
		this.user_id = user_id;
	}
	public MypageUser() {
		this.icon = "";
		this.address = "";
		this.user_name = "";
		this.freespace = "";
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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



