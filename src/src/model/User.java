package model;
import java.io.Serializable;

public class User implements Serializable{
	private String id;
	private String user_id;
	private String user_name;
	private String address;
	private String image;
	private String comment;
	private String pw;

	public User(String id,String user_id,String user_name,String address,String image,
			String comment,String pw) {
		this.id=id;
		this.user_id=user_id;
		this.user_name=user_name;
		this.address=address;
		this.image=image;
		this.comment=comment;
		this.pw=pw;
	}

	public User() {
		this.id="";
		this.user_id="";
		this.user_name="";
		this.address="";
		this.image="";
		this.comment="";
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}


}
