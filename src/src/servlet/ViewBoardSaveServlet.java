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
//		String sender_id = "ryouko-tanaka918.gmail.com";


		//保存されていなかったら保存、保存されていたら削除
		BoardSDao bsDao = new BoardSDao();
		if(bsDao.countsave(board_id,sender_id)) {
			//削除処理を行う
			bsDao.delete(board_id,sender_id);
		} else {
			// 登録処理を行う
			bsDao.insert(new BoardSave("",board_id,sender_id)); // 登録成功

		}

		//保存ボタンの色を判断する
		if(bsDao.countsave(board_id,sender_id)) {
			//保存済みボタン
//			String save_button = "saved_button.png";
			session.setAttribute("save_button","/dotchiha/img/saved_button.png");
		} else {
			// 未保存ボタン
//			String save_button = "save_button.png";
			session.setAttribute("save_button", "/dotchiha/img/save_button.png");
		}


		// 掲示板一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewboard.jsp");
		dispatcher.forward(request, response);
	}

}
