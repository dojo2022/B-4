package model;

import java.io.Serializable;

public class BoardS implements Serializable{
	private String Board_title;
	private String sender_id;

	public BoardS(String Board_title, String sender_id) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.Board_title = Board_title; //リアクションした掲示板のtitle
		this.sender_id = sender_id; //リアクションしたユーザーのid
	}

	public BoardS() {
		this.Board_title="";
		this.sender_id="";
	}

	public String getBoard_title() {
		return Board_title;
	}

	public void setBoard_title(String board_title) {
		this.Board_title = board_title;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}



}
