package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FeelingDao {
	// Feelingテーブルにidが存在していたらtrueを返す
	public boolean searchf(String userid) {
		Connection conn = null;
		boolean searchResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from Feeling where user_id = ?" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDが一致する列が存在するかどうか確認する
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				searchResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			searchResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			searchResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					searchResult = false;
				}
			}
		}

		// 結果を返す
		return searchResult;
	}


	// 気分選択情報の書き換え
	public boolean updatef(String feeling, String user_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6","sa","");

			// SQL文を準備する
			String sql = "update Feeling set feeling = ? where user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, feeling);
			pStmt.setString(2, user_id);


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
	// 列作成
	public boolean insertf(String userid, String feeling) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6","sa","");

			// SQL文を準備する
			String sql = "insert into Feeling (user_id, feeling) value (?, ?) where user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, userid);
			pStmt.setString(2, feeling);



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
	// ユーザーIDから気分を検索する
	public int selectf(String userid) {
		Connection conn = null;
		int searchResult = 2;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6", "sa", "");

			// SELECT文を準備する
			String sql = "select feeling from Feeling where user_id = ?" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDが一致する列が存在するかどうか確認する
			rs.next();
			searchResult = rs.getInt("feeling");
		}
		catch (SQLException e) {
			e.printStackTrace();
			searchResult = 2;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			searchResult = 2;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					searchResult = 2;
				}
			}
		}

		// 結果を返す
		return searchResult;
	}
}
