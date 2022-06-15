package model;

import java.io.Serializable;

public class TList implements Serializable{
	private String title;	 // 投稿したタイトル

	public TList(String title) {
		this.title = title;
	}
	public TList() {
		this.title = "";
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
