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

import dao.PostDao;
import model.Post;

/**
 * Servlet implementation class UpdatePostsub
 */
@WebServlet("/UpdatePostsubServlet")
public class UpdatePostsubServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*リクエストパラメータを取得*/
		String post_id = request.getParameter("id");

		// 検索処理を行う
		PostDao pDao = new PostDao();
		List<Post> postList = pDao.select(post_id);

		// 検索結果をセッションスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("postList", postList);

		//投稿更新ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updatepost.jsp");
		dispatcher.forward(request, response);
	}

}
