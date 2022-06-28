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
		// セッションスコープからログインidを取得
		HttpSession session = request.getSession();
		String userid= (String) session.getAttribute("user_id");
		// ユーザーの気分情報を取り出す
		FeelingDao fDao =new FeelingDao();
		int f = fDao.selectf(userid);
		Integer i = Integer.valueOf(f);
		String feeling = i.toString();
		//気分をリクエストスコープに格納する
		String choice = "";
		if(f == 0) {
			choice = "1";
		}else if(f == 1) {
			choice = "0";
		}
		request.setAttribute("choice", choice);
		//気分で投稿を検索する
		PostDao pDao = new PostDao();
		List<Post> postList = pDao.fselect(feeling);
		//投稿詳細画面戻るボタン用
		String r = "CorDBrows";
		session.setAttribute("viewReturn", r);
		// 検索結果をリクエストスコープに格納する
		request.setAttribute("postList", postList);
		// 閲覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cbrows.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String postuser = request.getParameter("USERID");
		String posttitle = request.getParameter("POSTTITLE");
		String image = request.getParameter("IMAGE");
		String postcomment = request.getParameter("POSTCOMMENT");
		String date =request.getParameter("date");
		//セッションスコープに詳細画面に必要なデータを入れる
		HttpSession session = request.getSession();
		session.setAttribute("postid", id);
		session.setAttribute("postuser", postuser);
		session.setAttribute("posttitle", posttitle);
		session.setAttribute("image", image);
		session.setAttribute("postcomment", postcomment);
		session.setAttribute("date", date);

		// 投稿詳細サーブレットにリダイレクトする
		response.sendRedirect("/dotchiha/ViewPostServlet");
	}

}