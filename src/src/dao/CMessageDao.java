package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CMessage;

public class CMessageDao {
	public List<CMessage> select(String room_id) {
		Connection conn = null;
		List<CMessage> messageList = new ArrayList<CMessage>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する　<ここ変える>全て取り出して、WHEREのところは検索する項目にする
			String sql = "SELECT id, room_id, message, sender_id FROM Cmessage WHERE room_id =? ORDER BY id ASC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, room_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <ここ変える>全ての列にする
			//postalcode, tel, email
			while (rs.next()) {
				CMessage card = new CMessage(
				rs.getString("id"),
				rs.getString("room_id"),
				rs.getString("message"),
				rs.getString("sender_id")
				);
				messageList.add(card);
				//System.out.println(rs.getString("number"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			messageList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			messageList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					messageList = null;
				}
			}
		}

		// 結果を返す
		return messageList;
	}

	public boolean insert(CMessage card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する＜ここ変える SQLのテーブルと同じ項目にする＞
			String sql = "INSERT INTO Cmessage (message, room_id, sender_id) VALUES ( ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			 //SQL文を完成させる＜ここ変える SQLのテーブルと同じ項目にする＞
			if (card.getMessage() != null && !card.getMessage().equals("")) {
				pStmt.setString(1, card.getMessage());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getRoom_id() != null && !card.getRoom_id().equals("")) {
				pStmt.setString(2, card.getRoom_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getSender_id() != null && !card.getSender_id().equals("")) {
				pStmt.setString(3, card.getSender_id());
			}
			else {
				pStmt.setString(3, null);
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
