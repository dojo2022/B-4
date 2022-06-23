package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {
// ログインできるならtrueを返す
	public boolean isLoginOK(User User) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from User where user_id = ? and pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,User.getUser_id());
			pStmt.setString(2,User.getPw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}
//引数idpwで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(User User) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data","sa","");

				// SQL文を準備する
				String sql = "INSERT into User (id,user_id,user_name,address,icon,freespace,pw) values (?,?,?,?,?,?,?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (User.getId() != null && !User.getId().equals("")) {
					pStmt.setString(1, User.getId());
				}
				else {
					pStmt.setString(1, null);
				}
				if (User.getUser_id() != null && !User.getUser_id().equals("")) {
					pStmt.setString(2, User.getUser_id());
				}
				else {
					pStmt.setString(2, null);
				}
				if (User.getUser_name() != null && !User.getUser_name().equals("")) {
					pStmt.setString(3, User.getUser_name());
				}
				else {
					pStmt.setString(3, null);
				}
				if (User.getAddress() != null && !User.getAddress().equals("")) {
					pStmt.setString(4, User.getAddress());
				}
				else {
					pStmt.setString(4, null);
				}
				if (User.getIcon() != null && !User.getIcon().equals("")) {
					pStmt.setString(5, User.getIcon());
				}
				else {
					pStmt.setString(5, null);
				}
				if (User.getFreespace() != null && !User.getFreespace().equals("")) {
					pStmt.setString(6, User.getFreespace());
				}
				else {
					pStmt.setString(6, null);
				}
				if (User.getPw() != null && !User.getPw().equals("")) {
					pStmt.setString(7, User.getPw());
				}
				else {
					pStmt.setString(7, null);
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
		//ユーザーIDで検索してユーザー情報を取得する

		public List<User> uselect(String userid) {
					Connection conn = null;
					List<User> userInfo = new ArrayList<User>();

					try {
						// JDBCドライバを読み込む
						Class.forName("org.h2.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

						// SQL文を準備する
						String sql = "select id, user_id, user_name, address, icon, freespace, pw  from User WHERE user_id = ?";
						PreparedStatement pStmt = conn.prepareStatement(sql);
						// SQL文を完成させる
						pStmt.setString(1,  userid);
						// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						while (rs.next()) {
							//idをintからStringへ変換
							int num = rs.getInt("id");
							Integer i = Integer.valueOf(num);
							String id = i.toString();
							User u = new User(
							id,
							rs.getString("user_id"),
							rs.getString("user_name"),
							rs.getString("address"),
							rs.getString("icon"),
							rs.getString("freespace"),
							rs.getString("pw")
							);
							userInfo.add(u);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						userInfo = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						userInfo = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								userInfo = null;
							}
						}
					}

					// 結果を返す
					return userInfo;
				}
}
