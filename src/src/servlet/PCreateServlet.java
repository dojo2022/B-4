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

import dao.FollowDao;
import model.Follow;

/**
 * Servlet implementation class PCreateServlet
 */
@WebServlet("/PCreateServlet")
public class PCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//相互フォロー者を表示する
		FollowDao fDao = new FollowDao();
		List<Follow> pList = fDao.select_plist();
		HttpSession session = request.getSession();
		session.setAttribute("pList", pList);


		//リクエストが来たらgcreate.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/pcreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
//			request.setCharacterEncoding("UTF-8");
//			String id = request.getParameter("ID");
//			String user_name = request.getParameter("user_name");//テキストエリアのnameと小文字など書き方をそろえる

//		// 登録処理を行う<ここを変える>
//			CroomDao cDao = new CroomDao();
//			if (cDao.insert(new Croom(id, room_name))) {	// 登録成功
//				request.setAttribute("result",
//				new Result());
//			}
//			else {											// 登録失敗
//				request.setAttribute("result",
//				new Result());
//			}
//
//		// 結果ページにフォワードする
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cselect.jsp");
//			dispatcher.forward(request, response);

	}

}
