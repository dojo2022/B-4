package model;
import java.io.Serializable;

public class Croom implements Serializable {
		private String id;	// ルームID
		private String room_name;	// ルーム名

		//引数があるコンストラクタ
		public Croom(String id, String room_name) {
			super();
			this.id = id;
			this.room_name = room_name;
		}

		public Croom(String id) {
			super();
			this.id = id;
		}

		//引数がないコンストラクタ（デフォルトコンストラクタ）
		public Croom() {
			super();
			this.id = "";
			this.room_name = "";
		}


		//ゲッターとセッター
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

}
