package model;

import java.io.Serializable;

public class PostR implements Serializable{
	private String post_id;    //お気に入り投稿のid
	private String image;      //お気に入り投稿の画像
	private String sender_id;  //お気に入りした人のuser_id(sender_id)

	public PostR(String post_id,String image,String sender_id) {
		this.post_id = post_id;
		this.image = image;
		this.sender_id = sender_id;
	}

	public PostR() {
		this.post_id ="";
		this.image="";
		this.sender_id="";
	}



	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

}
