package model;
import java.io.Serializable;

public class Post implements Serializable{
	private String id;          //id
	private String user_id;     //ユーザーID
	private String posttitle;   //投稿タイトル
	private String image;       //画像
	private String cord;
//	private int cord;           //犬猫ラジオボタン
	private String postcomment; //説明欄
	private String date;        //作成日付

	//引数のあるコンストラクタ
	public Post(String id,String user_id,String posttitle, String image, String cord/*int cord*/, String postcomment,String date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.posttitle = posttitle;
		this.image = image;
		this.cord = cord;
		this.postcomment = postcomment;
		this.date = date;
	}

	//引数のないコンストラクタ
	public Post() {
		super();
		this.id="";
		this.posttitle = "";
		this.image = "";
		this.cord = "";
//		this.cord = 0;
		this.postcomment = "";
		this.date = "";
	}

	//ゲッターとセッター
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String use_id) {
		this.user_id = use_id;
	}
	public String getPosttitle() {
		return posttitle;
	}
	public void setPosttitle(String posttitle) {
		this.posttitle = posttitle;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCord() {
		return cord;
	}
	public void setCord(String cord) {
		this.cord = cord;
	}
//	public int getCord() {
//		return cord;
//	}
//	public void setCord(int cord) {
//		this.cord = cord;
//	}
	public String getPostcomment() {
		return postcomment;
	}
	public void setPostcomment(String postcomment) {
		this.postcomment = postcomment;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}