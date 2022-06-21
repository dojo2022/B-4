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

	public List<CPMember> select_pmember(String user_id){
		Connection conn = null;
		List<CPMember> pmemberList = new ArrayList<CPMember>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			// ここでJOINを利用して2つのテーブルからデータを取得する。
			String sql = "SELECT croom.id FROM (croom left join cmember on CROOM.id = Cmember.room_id) left join user as user on cmember.user_id = user.user_id where croom.room_name is null and user.user_id=?";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <ここ変える>全ての列にする
			while (rs.next()) {
				CPMember card = new CPMember(
				rs.getString("id")
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

	public List<CPMember> select_pm(String user_id, String room_id){
		Connection conn = null;
		List<CPMember> pmList = new ArrayList<CPMember>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/dojo6Data/dojo6Data", "sa", "");

			// SQL文を準備する
			// ここでJOINを利用して2つのテーブルからデータを取得する。
			String sql = "select user.user_id,user.user_name, cmember.room_id from cmember left join user on cmember.user_id=user.user_id where cmember.room_id= ? and cmember.user_id not in( ? )";
			// プリペアードステートメントを生成（取得）する
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, room_id);
			pStmt.setString(2, user_id);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする <ここ変える>全ての列にする
			while (rs.next()) {
				CPMember card = new CPMember(
				rs.getString("room_id"),
				rs.getString("user_id"),
				rs.getString("user_name")
				);
				pmList.add(card);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			pmList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			pmList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					pmList = null;
				}
			}
		}

		// 結果を返す
		return pmList;
	}


}
