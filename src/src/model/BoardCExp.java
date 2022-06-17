package model;

public class BoardCExp extends BoardC {
	private String user_id;	  // ユーザーID
	private String title;	// タイトル
	private String text;  //説明欄
	private String date;  //作成日付
	private String dorc;  //犬猫選択

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDorc() {
		return dorc;
	}
	public void setDorc(String dorc) {
		this.dorc = dorc;
	}


}
