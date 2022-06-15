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
		public List<Croom> select(Croom param) {
			Connection conn = null;
			List<Croom> roomList = new ArrayList<Croom>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/dojo6Date/dojo6Date", "sa", "");

				// SQL文を準備する　<ここ変える>全て取り出して、WHEREのところは検索する項目にする
				String sql = "SELECT id, room_name FROM Croom WHERE room_name LIKE ? ORDER BY id";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる　<ここ変える>検索項目の数に合わせる
				if (param.getRoom_name() != null) {
					pStmt.setString(1, "%" + param.getRoom_name() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}


				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする <ここ変える>全ての列にする
				//postalcode, tel, email
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

}
