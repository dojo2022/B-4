package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostDao;
import model.Post;
import model.Result;

/**
 * Servlet implementation class UpdatePostServlet
 */
@WebServlet("/UpdatePostServlet")
public class UpdatePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

/*	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*//*
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//投稿更新ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/updatepost.jsp");
		dispatcher.forward(request, response);
		}
*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//リクエストパラメータを取得する
		String id = request.getParameter("id");
		String posttitle = request.getParameter("posttitle");
		String image = request.getParameter("image");
		String cord = request.getParameter("cord");
		String postcomment = request.getParameter("postcomment");

		//更新・削除を行う
		PostDao pDao = new PostDao();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (pDao.update(new Post("","",posttitle,image,cord,postcomment,""))) {	// 更新成功
				request.setAttribute("result",
				new Result("更新成功！", "レコードを更新しました。", "/simpleBC/MenuServlet"));
			}
			else {												// 更新失敗
				request.setAttribute("result",
				new Result("更新失敗！", "レコードを更新できませんでした。", "/simpleBC/MenuServlet"));
			}
		}
		else {
			if (pDao.delete(id)) {	// 削除成功
				request.setAttribute("result",
				new Result("削除成功！", "レコードを削除しました。", "/simpleBC/MenuServlet"));
			}
			else {						// 削除失敗
				request.setAttribute("result",
				new Result("削除失敗！", "レコードを削除できませんでした。", "/simpleBC/MenuServlet"));
			}
		}
	}
}
