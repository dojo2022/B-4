package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PostR;

public class PostRDao {
	   //DBからリアクションした投稿のデータを取得
		// 引数post_idで検索項目を指定し、検索結果のリストを返す
	public List<PostR> select_post_id(String sender_id) {
		Connection conn = null;
		List<PostR> cardPostR = new ArrayList<PostR>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select r.post_id,p.image, r.sender_id from POST as p  RIGHT JOIN POSTR as r on p.id = r.post_id  where r.sender_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, sender_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				PostR card = new PostR(
				rs.getString("post_id"),
				rs.getString("image"),
				rs.getString("sender_id")
				);
				cardPostR.add(card);
			}


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {

		e.printStackTrace();
		}


		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		// 結果を返す
		return cardPostR;
	}


}
