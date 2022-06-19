package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDao {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Board> select(Board param) {
		Connection conn = null;
		List<Board> boardList = new ArrayList<Board>();

		//id,user_id,title,text,date,dorc

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する<<ここを改造>>
			String sql = "select id,user_id,title,text,date,dorc from Board WHERE dorc LIKE ? ORDER BY id DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる<<ここを改造>>

//			if (param.getId() != null) {
//				pStmt.setString(1,  param.getId());
//			}
//			else {
//				pStmt.setString(1, "null");
//			}
			if (param.getDorc() != null) {
				pStmt.setString(1, "%" + param.getDorc() + "%");
			}
			else {
				pStmt.setString(1, "%");
			}


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする<<ここを改造>>
			while (rs.next()) {
				Board card = new Board(
				rs.getString("id"),
				rs.getString("user_id"),
				rs.getString("title"),
				rs.getString("text"),
				rs.getString("date"),
				rs.getString("dorc")
				);
				boardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			boardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			boardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					boardList = null;
				}
			}
		}

		// 結果を返す
			return boardList;
	}
	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Board card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//id,user_id,title,text,date,dorc

			// SQL文を準備する
			String sql = "INSERT into Board (user_id,title,text,dorc) values ( ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(1, card.getUser_id());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getTitle() != null && !card.getTitle().equals("")) {
				pStmt.setString(2, card.getTitle());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getText() != null && !card.getText().equals("")) {
				pStmt.setString(3, card.getText());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getDorc() != null && !card.getDorc().equals("")) {
				pStmt.setString(4, card.getDorc());
			}
			else {
				pStmt.setString(4, null);
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
