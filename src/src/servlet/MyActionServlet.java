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

import dao.PostRDao;
import model.PostR;

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
		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");


		//データベースから下記のデータ（リアクションした投稿）をユーザーidを元に取得する
		//データを取得するdaoを作成する
		PostRDao prDao = new PostRDao();
		List<PostR> cardPostR = prDao.select_id(user_id);
		//取得したデータをリクエストスコープに格納
		session.setAttribute("cardPostR",cardPostR);
		//投稿詳細画面戻るボタン用
		String r = "MyAction";
		session.setAttribute("viewReturn", r);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/myaction.jsp");
		dispatcher.forward(request, response);

	}

}
