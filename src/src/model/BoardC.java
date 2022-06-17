package model;

import java.io.Serializable;

public class BoardC implements Serializable {
	private String id;
	private String board_id;
	private String sender_id;
	private String comment;
	private String date;


	//引数ありコンストラクタ
	public BoardC(String id, String board_id, String sender_id, String comment, String date) {
		super();
		this.id = id;
		this.board_id = board_id;
		this.sender_id = sender_id;
		this.comment = comment;
		this.date = date;
	}



	//引数なしコンストラクタ
	public BoardC() {

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



}
