package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardSDao;
import model.BoardSave;

/**
 * Servlet implementation class ViewBoardSaveServlet
 */
@WebServlet("/ViewBoardSaveServlet")
public class ViewBoardSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBoardSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/dotchiha/LoginServlet");
//			return;
//		}oGet(request, response);

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String board_id = request.getParameter("board_id");

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String sender_id = (String)session.getAttribute("user_id");

		// 登録処理を行う
		BoardSDao bsDao = new BoardSDao();
		bsDao.insert(new BoardSave("",board_id,sender_id)); // 登録成功

		// 掲示板一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewboard.jsp");
		dispatcher.forward(request, response);
	}

}
