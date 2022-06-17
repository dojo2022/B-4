package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FeelingDao;
import dao.PostDao;
import model.Post;

/**
 * Servlet implementation class CorDBrowsServlet
 */
@WebServlet("/CorDBrowsServlet")
public class CorDBrowsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 閲覧ページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cbrows.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1 = request.getSession();
		session1.setAttribute("id", "nekozuki75@gmail.com");
		// セッションスコープからログインidを取得
				HttpSession session = request.getSession();
				String userid= (String) session.getAttribute("id");
		// ユーザーの気分情報を取り出す
				FeelingDao fDao =new FeelingDao();
				int feeling = fDao.selectf(userid);
				PostDao pDao = new PostDao();
				List<> cardList = new ArrayList<Post>();
				cardList = pDao.selectpost(feeling);

	}

}
