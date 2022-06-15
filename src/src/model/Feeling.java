package model;
import java.io.Serializable;

public class Feeling implements Serializable {
	private String user_id;	// ユーザーid
	private String feeling;	// 気分

	// 引き数があるコンストラクタ
	public Feeling(String user_id) {
		super();
		this.user_id = user_id;
	}

	// 引数がないコンストラクタ
	public Feeling() {
		super();
		this.user_id = "";
		this.feeling = "";
	}
	// ゲッターとセッター
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getFeeling() {
		return feeling;
	}

	public void setFeeling(String feeling) {
		this.feeling = feeling;
	}

}
