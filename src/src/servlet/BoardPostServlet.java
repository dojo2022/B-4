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

import dao.BoardDao;
import model.Board;

/**
 * Servlet implementation class BoardPostServlet
 */
@WebServlet("/BoardPostServlet")
public class BoardPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardPostServlet() {
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

		// 新規掲示板ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/boardpost.jsp");
		dispatcher.forward(request, response);
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

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
//		String user_id = "nekozuki75@gmail.com";

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String cat = request.getParameter("cat");
		if (cat == null || cat == "null") {cat="0";}
		String dog = request.getParameter("dog");
		if (dog == null || dog == "null") {dog="0";}
		String dorc = null;

		if(cat.equals("1") && dog.equals("0")) {
			dorc = "0";
		}else if(cat.equals("0") && dog.equals("1")) {
			dorc = "1";
		}else {
			dorc = "2";
		}

		// 登録処理を行う
		BoardDao bDao = new BoardDao();
		bDao.insert(new Board("",user_id,title,text,"",dorc)); // 登録成功

		// 検索処理を行う
		List<Board> boardList = bDao.select(new Board("", "", "", "", "",""));

		// 検索結果をリクエストスコープに格納する
//		HttpSession session = request.getSession();
		session.setAttribute("boardList", boardList);


		// 掲示板一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/boardlist.jsp");
		dispatcher.forward(request, response);
	}

}
