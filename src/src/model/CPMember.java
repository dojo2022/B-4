package model;

public class CPMember {
	private String id;	// CroomテーブルからルームID
	private String room_name;	// Croomテーブルからルーム名
	private String room_id;	// CmemberテーブルからユーザーID
	private String user_id;	// CmemberテーブルからユーザーID
	private String user_name;//userテーブルからユーザー名

	public CPMember(String id, String room_name, String room_id, String user_id, String user_name) {
		super();
		this.id = id;
		this.room_name = room_name;
		this.room_id = room_id;
		this.user_id = user_id;
		this.user_name = user_name;
	}

	public CPMember(String id) {
		super();
		this.id = id;
	}

	public CPMember(String room_id, String user_id, String user_name) {
		super();
		this.room_id = room_id;
		this.user_id = user_id;
		this.user_name = user_name;
	}

	public CPMember() {
		super();
		this.id = "";
		this.room_name = "";
		this.user_id = "";
		this.user_name = "";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


}
