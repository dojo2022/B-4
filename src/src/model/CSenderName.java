package model;
import java.io.Serializable;

public class CSenderName implements Serializable {
	private String id;	// メッセージID
	private String room_id;	// ルームID
	private String message;	// メッセージ
	private String sender_id;	// 送信者ID
	private String user_name;	// ユーザー名


	public CSenderName(String id, String room_id, String message, String sender_id, String user_name) {
		super();
		this.id = id;
		this.room_id = room_id;
		this.message = message;
		this.sender_id = sender_id;
		this.user_name = user_name;
	}

	public CSenderName() {
		super();
		this.id = "";
		this.room_id = "";
		this.message = "";
		this.sender_id = "";
		this.user_name = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoom_id() {
		return room_id;
	}

	public void setRoom_id(String room_id) {
		this.room_id = room_id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSender_id() {
		return sender_id;
	}

	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


}
