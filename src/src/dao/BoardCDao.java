package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
				item.setDate(rs.getString("board_date"));
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
}
