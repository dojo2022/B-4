package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BoardS;
import model.BoardSave;


public class BoardSDao {

	   //DBからリアクションした投稿のデータを取得
		// 引数board_idで検索項目を指定し、検索結果のリストを返す
	public List<BoardS> select_board_id(String sender_id) {
		Connection conn = null;
		List<BoardS> cardBoardS= new ArrayList<BoardS>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select b.title from Board as b  RIGHT JOIN BoardS as s on b.id = s.board_id  where s.sender_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, sender_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				BoardS card = new BoardS(
				rs.getString("Board_id"),
				rs.getString("Board_title"),
				rs.getString("sender_id")
				);
				cardBoardS.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardBoardS = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardBoardS = null;
		}


		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardBoardS = null;
				}
			}
		}


		// 結果を返す
		return cardBoardS;
	}

	public boolean insert(BoardSave save) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//id,board_id,sender_id

			// SQL文を準備する
			String sql = "INSERT into BoardS (board_id,sender_id) values ( ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (save.getBoard_id() != null && !save.getBoard_id().equals("")) {
				pStmt.setString(1, save.getBoard_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (save.getSender_id() != null && !save.getSender_id().equals("")) {
				pStmt.setString(2, save.getSender_id());
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

