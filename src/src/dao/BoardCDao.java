package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BoardC;
import model.BoardCExp;


public class BoardCDao {
	//掲示板をコメント付きで取得（一覧表型）
	public ArrayList<BoardCExp> getBoardCExpList(String id){
		ArrayList<BoardCExp> ret = new ArrayList<BoardCExp>();
		Connection conn = null;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			// ここでJOINを利用して2つのテーブルからデータを取得する。
			String sql = "SELECT Board.id AS board_id, user_id, title, text, Board.date AS board_date, dorc "
					+ ", BoardC.id AS boardc_id, board_id, sender_id, comment, BoardC.date AS boardc_date "
					+ "FROM Board "
					+ "LEFT JOIN BoardC "
					+ "ON Board.id = BoardC.board_id "
					+ "WHERE Board.id = ?";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, id);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				//1件のBoardCExpを作成し、追加する。
				BoardCExp item = new BoardCExp();
				//Board関連のデータ
				item.setUser_id(rs.getString("user_id"));
				item.setTitle(rs.getString("title"));
				item.setText(rs.getString("text"));
				item.setBoard_date(rs.getString("board_date"));
				item.setDorc(rs.getString("dorc"));
				//BoardC関連のデータ
				item.setId(rs.getString("boardc_id"));
				item.setBoard_id(rs.getString("board_id"));
				item.setSender_id(rs.getString("sender_id"));
				item.setComment(rs.getString("comment"));
				item.setDate(rs.getString("boardc_date"));

				ret.add(item);
			}

		}catch(Exception ex) {
			ex.printStackTrace();
			ret = null;
		}finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					ret = null;
				}
			}
		}
		return ret;
	}

	public boolean insert(BoardC card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//id,board_id,sender_id,comment,date

			// SQL文を準備する
			String sql = "INSERT into BoardC (board_id,sender_id,comment) values ( ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getBoard_id() != null && !card.getBoard_id().equals("")) {
				pStmt.setString(1, card.getBoard_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getSender_id() != null && !card.getSender_id().equals("")) {
				pStmt.setString(2, card.getSender_id());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getComment() != null && !card.getComment().equals("")) {
				pStmt.setString(3, card.getComment());
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
