package dao;

public class CMemberDao {
//
//	public List<CMember> select(){
//		Connection conn = null;
//		List<CMember> memberList = new ArrayList<CMember>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("org.h2.Driver");
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");
//
//			// SQL文を準備する
//			// ここでJOINを利用して2つのテーブルからデータを取得する。
//			String sql = "SELECT Cmessage.room_id, Cmessage.message, Cmessage.sender_id, User.user_name FROM Cmessage LEFT JOIN User ON Cmessage.sender_id = User.user_id;";
//			// プリペアードステートメントを生成（取得）する
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を実行し、結果表を取得する
//			ResultSet rs = pStmt.executeQuery();
//
//			// 結果表をコレクションにコピーする <ここ変える>全ての列にする
//			while (rs.next()) {
//				CMember card = new CMember(
//				rs.getString("user_id"),
//				rs.getString("room_id"),
//				rs.getString("user_name")
//				);
//				memberList.add(card);
//				//System.out.println(rs.getString("number"));
//			}
//		}
//		catch (SQLException e) {
//			e.printStackTrace();
//			memberList = null;
//		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			memberList = null;
//		}
//		finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				}
//				catch (SQLException e) {
//					e.printStackTrace();
//					memberList = null;
//				}
//			}
//		}
//
//		// 結果を返す
//		return memberList;
//	}


}
