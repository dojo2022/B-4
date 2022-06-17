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

/**
 * Servlet implementation class MyActionServlet
 */
@WebServlet("/MyActionServlet")
public class MyActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//データベースから下記のデータ（リアクションした投稿）をユーザーidを元に取得する
		//データを取得するdaoを作成する
		FollowDao fDao = new FollowDao();
		List<MypageUser> cardFollowList = fDao.select_user("nekozuki75@gmail.com");
		//取得したデータをリクエストスコープに格納
		request.setAttribute("cardFollowList",cardFollowList);

		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaction.jsp");
		dispatcher.forward(request, response);

	}

}
