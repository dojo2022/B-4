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

import dao.BoardCDao;
import dao.BoardDao;
import dao.BoardSDao;
import model.BoardCUser;
import model.BoardUser;

/**
 * Servlet implementation class ViewBoardServlet
 */
@WebServlet("/ViewBoardServlet")
public class ViewBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/dotchiha/LoginServlet");
//			return;
//		}

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
//		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String board_id = request.getParameter("board_id");

		//セッションからユーザーIDを取得する
//		HttpSession session = request.getSession();
//		String sender_id = (String)session.getAttribute("user_id");
		String sender_id = "ryouko-tanaka918.gmail.com";

		// 検索処理を行う
		BoardDao bDao = new BoardDao();
		List<BoardUser> boardList = bDao.select_username(board_id);

		// 検索結果をセッションスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);

		// 検索処理を行う
		BoardCDao bcDao = new BoardCDao();
		List<BoardCUser> commentList = bcDao.select_username(board_id);

		// 検索結果をセッションスコープに格納する
		session.setAttribute("commentList", commentList);

		//保存ボタンの色を判断する
		BoardSDao bsDao = new BoardSDao();
		if(bsDao.countsave(board_id,sender_id)) {
			//保存済みボタン
//			String save_button = "saved_button.png";
			session.setAttribute("save_button","/dotchiha/img/saved_button.png");
		} else {
			// 未保存ボタン
//			String save_button = "save_button.png";
			session.setAttribute("save_button", "/dotchiha/img/save_button.png");
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewboard.jsp");
		dispatcher.forward(request, response);
	}

}
