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
import model.Result;

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
		String icon = request.getParameter("icon");
		String address = request.getParameter("address");
		String user_name = request.getParameter("user_name");
		String freespace = request.getParameter("freespace");

		System.out.println(request.getParameter("SUBMIT"));

		// 更新を行う
		FollowDao fDao = new FollowDao();
//
//
//		if (request.getParameter("SUBMIT").equals("更新する")) {
			if (fDao.update(new MypageUser(icon, address,user_name, freespace,user_id))) {	// 更新成功
				//データを取得するdaoを作成する

				List<MypageUser> cardFollowList = fDao.select_user("nekozuki75@gmail.com");
				//取得したデータをリクエストスコープに格納
				request.setAttribute("cardFollowList",cardFollowList);
				request.setAttribute("result",
				new Result("成功！","情報を更新しました。", "/dotchiha/MyPageServlet"));

			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("失敗！","情報を更新できませんでした。","/dotchiha/MyPageServlet"));
			}
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage.jsp");
		dispatcher.forward(request, response);

	}

}
