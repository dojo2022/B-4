package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FollowDao;
import model.MypageUser;
import model.Post;

/**
 * Servlet implementation class MyChangeInfServlet
 */
@WebServlet("/MyChangeInfServlet")
public class MyChangeInfServlet extends HttpServlet {
    	private static final long serialVersionUID = 1L;
        // TODO Auto-generated constructor stub


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//データベースから下記のデータ（アイコン、都道府県、ユーザー名、freespace）をユーザーidを元に取得する
		//データを取得するdaoを作成する
		FollowDao fDao = new FollowDao();
		List<MypageUser> cardFollowList = fDao.select_user("nekozuki75@gmail.com");
		//取得したデータをリクエストスコープに格納
		request.setAttribute("cardFollowList",cardFollowList);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mychangeinf.jsp");
		dispatcher.forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_id = "nekozuki75@gmail.com";
		String icon = request.getParameter("imagefile");
		String address = request.getParameter("address");
		String user_name = request.getParameter("user_name");
		String freespace = request.getParameter("comment");

		System.out.println(address);
		System.out.println(freespace);

		// 更新を行う
		FollowDao fDao = new FollowDao();
//		if (request.getParameter("SUBMIT").equals("更新する")) {
		boolean res = fDao.update(new MypageUser(icon, address,user_name, freespace,user_id));
		if (res) {	// 更新成功
			//データを取得するdaoを作成する

			List<MypageUser> cardFollowList = fDao.select_user("nekozuki75@gmail.com");
			//取得したデータをリクエストスコープに格納
			request.setAttribute("cardFollowList",cardFollowList);
//				request.setAttribute("result",
//				new Result("成功！","情報を更新しました。", "/dotchiha/MyPageServlet"));
//
		}
//			else {												// 更新失敗
//				request.setAttribute("result",
//				new Result("失敗！","情報を更新できませんでした。","/dotchiha/MyPageServlet"));
//			}
//<<<<<<< HEAD

			//データベースから下記のデータ（アイコン、都道府県、ユーザー名、freespace）をユーザーidを元に取得する
			//データを取得するdaoを作成する
//			List<MypageUser> cardFollowList = fDao.select_user("nekozuki75@gmail.com");
			//取得したデータをリクエストスコープに格納
//			request.setAttribute("cardFollowList",cardFollowList);
//=======
		//データベースから下記のデータ（アイコン、都道府県、ユーザー名、freespace）をユーザーidを元に取得する
		//データを取得するdaoを作成する
		List<MypageUser> cardFollowList = fDao.select_user("nekozuki75@gmail.com");
		//取得したデータをリクエストスコープに格納
		request.setAttribute("cardFollowList",cardFollowList);
//>>>>>>> b6887840348e6b0abb3061c307dd345a94e1a3b6

		//タイトルを取得するdaoを作成する
		List<Post> cardPost = fDao.select_posttitle("nekozuki75@gmail.com");
		//取得したデータをリクエストスコープに追加格納する
		request.setAttribute("cardPost",cardPost);

		//follow数を取得するdaoを作成する
		int follow_count = 0;
		follow_count = fDao.select_follow("nekozuki75@gmail.com");
		String follow_count_s = String.valueOf(follow_count);
		//取得したデータをリクエストスコープに追加格納
		request.setAttribute("follow_count",follow_count_s);

		//followed数を取得するdaoを作成する
		int followed_count = 0;
		followed_count = fDao.select_followed("nekozuki75@gmail.com");
		String followed_count_s = String.valueOf(followed_count);
		//取得したデータをリクエストスコープに追加格納
		request.setAttribute("followed_count",followed_count_s);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);

	}

//	}
}
