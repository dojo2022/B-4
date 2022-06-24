package model;

import java.io.Serializable;

public class BoardS implements Serializable{
	//BoardSテーブルから
	private String board_id;
	private String sender_id;
	//Boardテーブルから
	private String title;
	private String dorc;

	public BoardS(String board_id, String sender_id, String title, String dorc) {
		super();
		this.board_id = board_id;
		this.sender_id = sender_id;
		this.title = title;
		this.dorc = dorc;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDorc() {
		return dorc;
	}
	public void setDorc(String dorc) {
		this.dorc = dorc;
	}




}
