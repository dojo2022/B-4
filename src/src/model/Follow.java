package model;

import java.io.Serializable;

public class Follow implements Serializable{
	private String id;	// ID
	private String follow_id;	// フォロー者ID
	private String followed_id;	// 被フォロー者ID

	//引数のあるコンストラクタ
	public Follow(String id, String follow_id, String followed_id) {
		super();
		this.id = id;
		this.follow_id = follow_id;
		this.followed_id = followed_id;
	}

	//引数のないコンストラクタ
		public Follow() {
			super();
			this.id = "";
			this.follow_id = "";
			this.followed_id = "";
		}

		//ゲッターとセッター
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getFollow_id() {
			return follow_id;
		}

		public void setFollow_id(String follow_id) {
			this.follow_id = follow_id;
		}

		public String getFollowed_id() {
			return followed_id;
		}

		public void setFollowed_id(String followed_id) {
			this.followed_id = followed_id;
		}


}



