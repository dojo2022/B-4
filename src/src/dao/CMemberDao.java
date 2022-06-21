package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CPMember;

public class CMemberDao {

	public List<CPMember> select_pmember(){
		Connection conn = null;
		List<CPMember> pmemberList = new ArrayList<CPMember>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			// ここでJOINを利用して2つのテーブルからデータを取得する。
			String sql = "SELECT croom.id, croom.room_name, cmember.user_id, user.user_name FROM (croom left join cmember on CROOM.id = Cmember.room_id) \r\n"
					+ "left join user as user on cmember.user_id = user.user_id where room_name is null and cmember.user_id='nekozuki75@gmail.com'";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <ここ変える>全ての列にする
			while (rs.next()) {
				CPMember card = new CPMember(
				rs.getString("id"),
				rs.getString("room_name"),
				rs.getString("user_id"),
				rs.getString("user_name")
				);
				pmemberList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			pmemberList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			pmemberList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					pmemberList = null;
				}
			}
		}

		// 結果を返す
		return pmemberList;
	}


}
