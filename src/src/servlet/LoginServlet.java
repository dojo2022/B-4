package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Result;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*リクエストパラメータを取得する*/
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String pw = request.getParameter("pw");

//		HttpSession session = request.getSession();
//
//		//セッションにキーと値のペアを格納
//	    session.setAttribute("user_id", user_id);

		/*ログイン処理を行う*/
		UserDao iDao = new UserDao();
		if (iDao.isLoginOK(new User("",user_id,"","","","",pw))) {	// ログイン成功
			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);

			// セッションスコープにIDを格納する
//			HttpSession session = request.getSession();
//			session.setAttribute("id", new LoginUser(user_id));

			// 犬猫選択サーブレットにリダイレクトする
			response.sendRedirect("/dotchiha/CorDSelectServlet");
		}
		else {									// ログイン失敗
			// リクエストスコープに、タイトル、メッセージ、戻り先を格納する
			request.setAttribute("result",
			new Result("ログイン失敗！", "IDまたはPWに間違いがあります。", "/dotchiha/LoginServlet"));

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}

	}
}
