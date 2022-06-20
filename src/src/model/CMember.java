package model;
import java.io.Serializable;

public class CMember implements Serializable {
		private String id;	// ID
		private String room_id;	// ルームID
		private String user_id;	// ユーザーID
		private String user_name;//ユーザー名

		public CMember(String id, String room_id, String user_id, String user_name) {
			super();
			this.id = id;
			this.room_id = room_id;
			this.user_id = user_id;
			this.user_name = user_name;
		}

		public CMember() {
			super();
			this.id = "";
			this.room_id = "";
			this.user_id = "";
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
