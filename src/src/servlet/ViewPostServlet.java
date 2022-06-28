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
import dao.UserDao;
import model.User;

/**
 * Servlet implementation class ViewPostServlet
 */
@WebServlet("/ViewPostServlet")
public class ViewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープからログインユーザーのユーザーIDを取り出す
		HttpSession session = request.getSession();
		String userid= (String) session.getAttribute("user_id");
		//セッションスコープから投稿情報を受け取る
		String postid = (String) session.getAttribute("postid");
		String posttitle = (String) session.getAttribute("posttitle");
		String postuser= (String) session.getAttribute("postuser");
		String image = (String) session.getAttribute("image");
		String postcomment = (String) session.getAttribute("postcomment");
		String date = (String) session.getAttribute("date");
		String viewReturn = (String) session.getAttribute("viewReturn");
		//ユーザーIDで検索してユーザー情報を得る
		UserDao uDao = new UserDao();
		List<User> userInfo = uDao.uselect(postuser);
		//投稿IDとユーザーIDでリアクションテーブルを検索する
		PostRDao rDao = new PostRDao();
		String reaction= "";
		if(rDao.selectreaction(postid, userid)) {
			reaction = "on";
		} else {
			reaction = "off";
		}
		//リクエストスコープに格納
		request.setAttribute("postTitle", posttitle);
		request.setAttribute("image", image);
		request.setAttribute("postComment", postcomment);
		request.setAttribute("date", date);
		request.setAttribute("postuser", postuser);
		request.setAttribute("userinfo", userInfo);
		request.setAttribute("reaction", reaction);
		request.setAttribute("viewReturn", viewReturn);
		// 投稿詳細ページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewpost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リアクション機能
		//セッションスコープからログインユーザーのユーザーIDを取り出す
		HttpSession session = request.getSession();
		String userid= (String) session.getAttribute("user_id");
		String postid = (String) session.getAttribute("postid");
		PostRDao rDao = new PostRDao();
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String reaction = request.getParameter("reaction");
		if(reaction.equals("off")) {
			//リアクションテーブルにユーザーIDと投稿IDを登録する
			if(rDao.insertr(postid, userid)) {
				response.sendRedirect("/dotchiha/ViewPostServlet");
			}
		} else {
			//リアクションテーブルからユーザーIDと投稿IDを削除する
			if(rDao.deleter(postid, userid)) {
				response.sendRedirect("/dotchiha/ViewPostServlet");
			}
		}


	}

}
