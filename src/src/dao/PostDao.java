package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Post;

public class PostDao {
	//引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Post card) {
		Connection conn = null;
		boolean result = false;
		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "insert into Post (user_id,posttitle,image,cord,postcomment) values (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if(card.getUser_id()!=null&& !card.getUser_id().equals("")) {
				pStmt.setString(1,card.getUser_id());
			}
			else {
				pStmt.setString(1,null);
			}
			if(card.getPosttitle()!=null&& !card.getPosttitle().equals("")) {
				pStmt.setString(2,card.getPosttitle());
			}
			else {
				pStmt.setString(2,null);
			}
			if(card.getImage()!=null&& !card.getImage().equals("")) {
				pStmt.setString(3,card.getImage());
			}
			else {
				pStmt.setString(3,null);
			}

			if(card.getCord()!=null&& !card.getCord().equals("")) {
				pStmt.setString(4,card.getCord());
			}
			else {
				pStmt.setString(4,null);
			}
			if(card.getPostcomment()!=null&& !card.getPostcomment().equals("")) {
				pStmt.setString(5,card.getPostcomment());
			}
			else {
				pStmt.setString(5,null);
			}
			//SQL文を実行する
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
		//データベースを切断
		finally {
			if(conn!=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//結果を返す
		return result;
	}

	//タイトルから投稿内容すべてのデータを取得
	public List<Post> select(String posttitle){
		Connection conn = null;
		List<Post> cardPost = new ArrayList<Post>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			// ここでテーブルからデータを取得する。
			String sql = "SELECT id,user_id,posttitle,image,crod,postcomment,date FROM Post WHERE id = ?";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, posttitle);
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <ここ変える>全ての列にする
			while (rs.next()) {
				Post card = new Post(
				rs.getString("id"),
				rs.getString("user_id"),
				rs.getString("posttitle"),
				rs.getString("image"),
				rs.getString("cord"),
				rs.getString("postcomment"),
				rs.getString("date")
				);
				cardPost.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardPost = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardPost = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardPost = null;
				}
			}
		}

		// 結果を返す
		return cardPost;
	}

	//引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Post card) {
		Connection conn = null;
		boolean result = false;

		try {
			//JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			//データベースに接続
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			//SQL文を準備する
			String sql = "update Post set posttitle=?,image=?,cord=?,postcomment=? where id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SQL文を完成させる
			if (card.getPosttitle() != null && !card.getPosttitle().equals("")) {
				pStmt.setString(1, card.getPosttitle());
			}
			else {
				pStmt.setString(1, null);
			}
			if (card.getImage() != null && !card.getImage().equals("")) {
				pStmt.setString(2, card.getImage());
			}
			else {
				pStmt.setString(2, null);
			}
			if (card.getCord() != null && !card.getCord().equals("")) {
				pStmt.setString(3, card.getCord());
			}
			else {
				pStmt.setString(3, null);
			}
			if (card.getPostcomment() != null && !card.getPostcomment().equals("")) {
				pStmt.setString(4, card.getPostcomment());
			}
			else {
				pStmt.setString(4, null);
			}
			//SQL文を実行する
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
		//データベースを切断
		finally {
			if(conn!=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//結果を返す
		return result;
	}
	//引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String id) {
		Connection conn = null;
		boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "delete from Post where id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setString(1, id);

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


	// 犬or猫で投稿を検索する
	//気分で投稿を検索する
		public List<Post> fselect(String feeling) {
			Connection conn = null;
			List<Post> postList = new ArrayList<Post>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

				// SQL文を準備する
				String sql = "select id, user_id, posttitle, image, cord, postcomment, date  from Post WHERE cord = ?  OR cord = 2  ORDER BY id DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
				pStmt.setString(1,  feeling);
				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				while (rs.next()) {
					//idをintからStringへ変換
					int num1 = rs.getInt("id");
					Integer i = Integer.valueOf(num1);
					String id = i.toString();
					//cordをintからStringへ変換
					int num2 = rs.getInt("cord");
					Integer i2 = Integer.valueOf(num2);
					String cord = i2.toString();
					//dateをdateからString へ変換
					java.sql.Date num3 = rs.getDate("date");
					String date = new SimpleDateFormat("yyyy/MM/dd ").format(num3);
					Post p = new Post(
					id,
					rs.getString("user_id"),
					rs.getString("posttitle"),
					rs.getString("image"),
					cord,
					rs.getString("postcomment"),
					date
					);
					postList.add(p);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				postList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				postList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						postList = null;
					}
				}
			}

			// 結果を返す
			return postList;
		}


}