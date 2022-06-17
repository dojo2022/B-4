package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Post;

public class PostDao {
	//引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Post card) {
		Connection conn = null;
		boolean result = false;
		try {
		//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

		//データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

		//SQL文を準備する
			String sql = "insert into Post (user_id,posttitle,image,cord,postcomment) values (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

		//SQL文を完成させる
			if(card.getUser_id()!=null&& !card.getUser_id().equals("")) {
				pStmt.setString(1,card.getUser_id());
			}
			else {
				pStmt.setString(1,null);
			}
			if(card.getPosttitle()!=null&& !card.getPosttitle().equals("")) {
				pStmt.setString(2,card.getPosttitle());
			}
			else {
				pStmt.setString(2,null);
			}
			if(card.getImage()!=null&& !card.getImage().equals("")) {
				pStmt.setString(3,card.getImage());
			}
			else {
				pStmt.setString(3,null);
			}

			if(card.getCord()!=null&& !card.getCord().equals("")) {
				pStmt.setString(4,card.getCord());
			}
			else {
				pStmt.setString(4,null);
			}
//			if(card.getCord()!=&& !card.getCord()=) {
//				pStmt.setInt(3,card.getCord());
//			}
//			else {
//				pStmt.setString(3,"");
//			}
			if(card.getPostcomment()!=null&& !card.getPostcomment().equals("")) {
				pStmt.setString(5,card.getPostcomment());
			}
			else {
				pStmt.setString(5,null);
			}
		//SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		//データベースを切断
			finally {
				if(conn!=null) {
					try {
						conn.close();
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
			}
		//結果を返す
			return result;
	}
}