package model;
import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String user_id;
	private String user_name;
	private String address;
	private String icon;
	private String freespace;
	private String pw;

	public User(String id,String user_id,String user_name,String address,String icon,
			String freespace,String pw) {
		this.id=id;
		this.user_id=user_id;
		this.user_name=user_name;
		this.address=address;
		this.icon=icon;
		this.freespace=freespace;
		this.pw=pw;
	}

	public User() {
		this.id="";
		this.user_id="";
		this.user_name="";
		this.address="";
		this.icon="";
		this.freespace="";
		this.pw="";
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getFreespace() {
		return freespace;
	}

	public void setFreespace(String freesapce) {
		this.freespace = freesapce;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}



}
