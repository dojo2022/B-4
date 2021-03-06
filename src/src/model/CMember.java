package model;
import java.io.Serializable;

//croom cmember userの３テーブルを合わせたmodelを記述している
public class CMember implements Serializable {

	private String id;
	private String room_id;
	private String user_id;

	public CMember(String id, String room_id, String user_id) {
		super();
		this.id = id;
		this.room_id = room_id;
		this.user_id = user_id;
	}

	public CMember() {

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

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
