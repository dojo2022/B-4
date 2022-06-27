package model;

import java.io.Serializable;

public class PostR implements Serializable{
	private String id;        //id
	private String user_id;   //投稿主のユーザーid
	private String posttitle;    //お気に入り投稿のタイトル
	private String image;    //お気に入り投稿の画像
	private String cord;
	private String postcomment; //説明欄
	private String date;       //日付
	private String sender_id;  //お気に入りした人のuser_id(sender_id)





	public PostR(String id,String user_id,String posttitle,String cord,String postcomment,String date,String image,String sender_id) {
		this.id = id;
		this.user_id = user_id;
		this.posttitle = posttitle;
		this.image = image;
		this.cord = cord;
		this.postcomment = postcomment;
		this.date = date;
		this.sender_id = sender_id;
	}

	public PostR() {
		this.id = "";
		this.user_id = "";
		this.posttitle = "";
		this.image = "";
		this.cord = "";
		this.postcomment = "";
		this.date = "";
		this.sender_id = "";
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

	public String getPosttitle() {
		return posttitle;
	}

	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getCord() {
		return cord;
	}

	public void setCord(String cord) {
		this.cord = cord;
	}

	public String getPostcomment() {
		return postcomment;
	}

	public void setPostcomment(String postcomment) {
		this.postcomment = postcomment;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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
