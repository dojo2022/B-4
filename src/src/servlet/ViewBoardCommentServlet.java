package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardCDao;
import model.BoardC;

/**
 * Servlet implementation class ViewBoardCommentServlet
 */
@WebServlet("/ViewBoardCommentServlet")
public class ViewBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String comment = request.getParameter("comment");
		String board_id = request.getParameter("board_id");

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String sender_id = (String)session.getAttribute("user_id");

		// 登録処理を行う
		BoardCDao bcDao = new BoardCDao();
		bcDao.insert(new BoardC("",board_id,sender_id,comment,"")); // 登録成功

		// 掲示板一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewboard.jsp");
		dispatcher.forward(request, response);

	}

}
