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
		List<Board> cardList = new ArrayList<Board>();

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

			pStmt.setString(1,param.getDorc());
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
				cardList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
			return cardList;
	}
}
