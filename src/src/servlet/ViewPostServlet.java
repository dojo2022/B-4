package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//セッションスコープから投稿情報を受け取る
		HttpSession session = request.getSession();
		String posttitle = (String) session.getAttribute("posttitle");
		String userid= (String) session.getAttribute("userid");
		String image = (String) session.getAttribute("image");
		String postcomment = (String) session.getAttribute("userid");
		String date = (String) session.getAttribute("date");
		//リクエストスコープに格納
		request.setAttribute("postTitle", posttitle);
		request.setAttribute("image", image);
		request.setAttribute("postComment", postcomment);
		request.setAttribute("date", date);

		// 投稿詳細ページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/viewpost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
