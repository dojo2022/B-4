package model;
import java.io.Serializable;

public class Post implements Serializable{
	private String posttitle;   //投稿タイトル
	private String image;       //画像
	private String cord;        //犬猫ラジオボタン
	private String postcomment; //説明欄

	//引数のあるコンストラクタ
	public Post(String posttitle, String image, String cord, String postcomment) {
		super();
		this.posttitle = posttitle;
		this.image = image;
		this.cord = cord;
		this.postcomment = postcomment;
	}

	//引数のないコンストラクタ
	public Post() {
		super();
		this.posttitle = "";
		this.image = "";
		this.cord = "";
		this.postcomment = "";
	}

	//ゲッターとセッター
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

	public String getPostcomment() {
		return postcomment;
	}

	public void setPostcomment(String postcomment) {
		this.postcomment = postcomment;
	}
}