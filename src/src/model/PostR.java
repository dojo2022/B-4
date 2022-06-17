package model;

import java.io.Serializable;

public class PostR implements Serializable{
	private String posttitle;
	private String sender_id;

	public PostR(String posttitle,String sender_id) {
		this.posttitle = posttitle;     //リアクションした投稿のtitle
		this.sender_id = sender_id; //リアクションしたユーザーのid
	}

	public PostR() {
		this.posttitle="";
		this.sender_id="";
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

}
