package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Croom;

public class CroomDao {
	//データベース接続に使用する情報
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Croom> select() {
			Connection conn = null;
			List<Croom> roomList = new ArrayList<Croom>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する<ここ変える>全て取り出して、WHEREのところは検索する項目にする
				String sql = "SELECT * FROM Croom WHERE room_name != 'null' ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする <ここ変える>全ての列にする
				while (rs.next()) {
					Croom card = new Croom(
					rs.getString("id"),
					rs.getString("room_name")
					);
					roomList.add(card);
					//System.out.println(rs.getString("number"));
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				roomList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				roomList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						roomList = null;
					}
				}
			}

			// 結果を返す
			return roomList;
		}

		public boolean insert(Croom card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する＜ここ変える SQLのテーブルと同じ項目にする＞
				String sql = "INSERT INTO Croom (id, room_name) VALUES (?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる＜ここ変える SQLのテーブルと同じ項目にする＞
				if (card.getId() != null && !card.getId().equals("")) {
					pStmt.setString(1, card.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (card.getRoom_name() != null && !card.getRoom_name().equals("")) {
					pStmt.setString(2, card.getRoom_name());
				}
				else {
					pStmt.setString(2, null);
				}


				// SQL文を実行する
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
			return result;
		}


}
