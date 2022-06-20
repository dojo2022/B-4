package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Follow;
import model.MypageUser;
import model.TList;

public class FollowDao {
	   //DBからicon,prefecture,user_name,freespace,titleのデータを取得
		// 引数user_idで検索項目を指定し、検索結果のリストを返す
		public List<MypageUser> select_user(String user_id) {
			Connection conn = null;
			List<MypageUser> cardFollowList = new ArrayList<MypageUser>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select u.icon,u.address,u.user_name, u.freespace from USER as u "
						+ "WHERE u.user_id = ?";



				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setString(1, user_id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					MypageUser card = new MypageUser(
					rs.getString("icon"),
					rs.getString("address"),
					rs.getString("user_name"),
					rs.getString("freespace")
					);
					cardFollowList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardFollowList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardFollowList = null;
			}


			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardFollowList = null;
					}
				}
			}


			// 結果を返す
			return cardFollowList;
		}

		//DBから投稿したタイトルのデータを取得
		public List<TList> select_posttitle(String id) {
			Connection conn = null;
			List<TList> cardTList = new ArrayList<TList>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select p.posttitle from USER as u  LEFT JOIN POST as p on u.user_id = p.user_id  where u.user_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					TList card = new TList(
					rs.getString("posttitle")
					);
					cardTList.add(card);
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
			return cardTList;
		}


		//DBからfollowのデータを取得
		// 引数user_idで検索項目を指定し、検索結果のリストを返す

			// SQL文を準備する
		public int select_follow(String id) {
			Connection conn = null;
			int follow_count=0;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select count(follow_id) from Follow where followed_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setString(1, id);

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				rs.next();
				follow_count=rs.getInt("count(follow_id)");

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
			return follow_count;
		}


		//DBからfollowedのデータを取得
		// 引数user_idで検索項目を指定し、検索結果のリストを返す
		// SQL文を準備する
	public int select_followed(String id) {
		Connection conn = null;
		int followed_count=0;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "select count(followed_id) from Follow where follow_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			followed_count=rs.getInt("count(followed_id)");

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
		return followed_count;
	}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(MypageUser card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			String sql = "update User set icon=?,address=?, user_name=?,freespace=? WHERE user_id =?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getIcon() != null && !card.getIcon().equals("")) {
				pStmt.setString(1, card.getIcon());
			}else {
				pStmt.setString(1, "%");
			}
			if (card.getAddress() != null && !card.getAddress().equals("")) {
				pStmt.setString(2, card.getAddress());
			}else {
				pStmt.setString(2, "%");
			}

			if (card.getUser_name() != null && !card.getUser_name().equals("")) {
				pStmt.setString(3, card.getUser_name());
			}else {
				pStmt.setString(3, "%");
			}

			if (card.getFreespace() != null && !card.getFreespace().equals("")) {
				pStmt.setString(4, card.getFreespace());
			}else {
				pStmt.setString(4, "%");
			}
			if (card.getUser_id() != null && !card.getUser_id().equals("")) {
				pStmt.setString(5, card.getUser_id());
			}else {
				pStmt.setString(5, "%");
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


	//plistの一覧表示
	public List<Follow> select_plist() {
	Connection conn = null;
	List<Follow> pList = new ArrayList<Follow>();

	try {
		// JDBCドライバを読み込む
		Class.forName("org.h2.Driver");

		// データベースに接続する
		conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

		// SQL文を準備する<ここ変える>全て取り出して、WHEREのところは検索する項目にする
		String sql = "SELECT Followed_id, User.user_name \r\n"
				+ "FROM ((SELECT  followed_id FROM FOLLOW  where follow_id = 'nekozuki75@gmail.com') intersect\r\n"
				+ "(SELECT  follow_id FROM FOLLOW  where followed_id = 'nekozuki75@gmail.com')) LEFT JOIN User ON Followed_id = User.user_id";
		PreparedStatement pStmt = conn.prepareStatement(sql);

		// SQL文を実行し、結果表を取得する
		ResultSet rs = pStmt.executeQuery();

		// 結果表をコレクションにコピーする <ここ変える>全ての列にする
		while (rs.next()) {
			Follow card = new Follow(
			rs.getString("followed_id"),
			rs.getString("user_name")
			);
			pList.add(card);
		}
	}
	catch (SQLException e) {
		e.printStackTrace();
		pList = null;
	}
	catch (ClassNotFoundException e) {
		e.printStackTrace();
		pList = null;
	}
	finally {
		// データベースを切断
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
				pList = null;
			}
		}
	}

	// 結果を返す
	return pList;
}

}






