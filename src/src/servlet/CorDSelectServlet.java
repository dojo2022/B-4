package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FeelingDao;
/**
 * Servlet implementation class CorDSelectServlet
 */
@WebServlet("/CorDSelectServlet")
public class CorDSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 選択ページにフォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/dorcselect.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session1 = request.getSession();
//		session1.setAttribute("id", "nekozuki75@gmail.com");
		// セッションスコープからログインidを取得
		HttpSession session = request.getSession();
		String userid= (String) session.getAttribute("id");
//		String userid = "nekozuki75@gmail.com";
		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String feeling = request.getParameter("FEELING");


		// feelingテーブルにidが存在しているか確認する
		FeelingDao fDao =new FeelingDao();
		if(fDao.searchf(userid)) {
			//存在した場合
			// 気分を更新する
			if(fDao.updatef(feeling, userid))  {
				// 閲覧サーブレットにリダイレクトする
				response.sendRedirect("/dotchiha/CorDBrowsServlet");
			} else {
				response.sendRedirect("/dotchiha/LoginServlet");
			}
		}
		else {
			//存在しなかった場合
			// 気分テーブルにログインユーザーの列を作成
			if(fDao.insertf(userid, feeling)) {
				// 閲覧サーブレットにリダイレクトする
				response.sendRedirect("/dotchiha/CorDBrowsServlet");
			}

		}



	}


}
