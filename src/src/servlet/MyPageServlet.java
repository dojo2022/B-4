package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FollowDao;
import model.MypageUser;
import model.Post;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @param cardTList_s
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//データベースから下記のデータ（アイコン、都道府県、ユーザー名、freespace）をユーザーidを元に取得する
		//データを取得するdaoを作成する
		FollowDao fDao = new FollowDao();
		List<MypageUser> cardFollowList = fDao.select_user(user_id);
		//取得したデータをリクエストスコープに格納
		request.setAttribute("cardFollowList",cardFollowList);

		//タイトルを取得するdaoを作成する
		List<Post> cardPost = fDao.select_posttitle(user_id);
		//取得したデータをリクエストスコープに追加格納する
		request.setAttribute("cardPost",cardPost);

		//follow数を取得するdaoを作成する
		int follow_count = 0;
		follow_count = fDao.select_follow(user_id);
		String follow_count_s = String.valueOf(follow_count);
		//取得したデータをリクエストスコープに追加格納
		request.setAttribute("follow_count",follow_count_s);

		//followed数を取得するdaoを作成する
		int followed_count = 0;
		followed_count = fDao.select_followed(user_id);
		String followed_count_s = String.valueOf(followed_count);
		//取得したデータをリクエストスコープに追加格納
		request.setAttribute("followed_count",followed_count_s);
		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);
	}

}


