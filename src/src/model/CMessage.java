package model;
import java.io.Serializable;

public class CMessage implements Serializable {
		private String id;	// ID
		private String message;	// メッセージ
		private String room_id;	// ルームID
		private String send_id;	// 送信者ID
		private String date;	// 日付
		private String time;	// 時間

		//引数があるコンストラクタ
		public CMessage(String id, String message, String room_id, String send_id, String date, String time) {
			super();
			this.id = id;
			this.message = message;
			this.room_id = room_id;
			this.send_id = send_id;
			this.date = date;
			this.time = time;
		}

		//引数がないコンストラクタ（デフォルトコンストラクタ）
		public CMessage() {
			super();
			this.id = "";
			this.message = "";
			this.room_id = "";
			this.send_id = "";
			this.date = "";
			this.time = "";
		}

		//ゲッターとセッター
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getRoom_id() {
			return room_id;
		}

		public void setRoom_id(String room_id) {
			this.room_id = room_id;
		}

		public String getSend_id() {
			return send_id;
		}

		public void setSend_id(String send_id) {
			this.send_id = send_id;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}



}
