package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
//				HttpSession session = request.getSession();
//				String userid= (String) session.getAttribute("id");
				String userid = "nekozuki75@gmail.com";
		// ユーザーの気分情報を取り出す
				FeelingDao fDao =new FeelingDao();
				int f = fDao.selectf(userid);
//				int f = 1;
				Integer i = Integer.valueOf(f);
				String feeling = i.toString();
//				request.setAttribute("feeling", feeling);
// ここまでは出来ている

				PostDao pDao = new PostDao();
//				List<Post> postList = new ArrayList<Post>();
//				postList = pDao.fselect(feeling);
				List<Post> postList = pDao.fselect(feeling);
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



	}

}