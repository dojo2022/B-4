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
 * Servlet implementation class PListServlet
 */
@WebServlet("/PListServlet")
public class PListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォローしている人の一覧のデータを保存するjavabeansをオブジェクト化
		//フォローしている人のデータを取得dao
		//フォローしている人のデータをセッションスコープに格納
		//データ：相互フォローのIDをselectする→ユーザー名になおす？（テーブル結合）

		FollowDao fDao = new FollowDao();
		List<Follow> pList = fDao.select_plist();
		HttpSession session = request.getSession();
		session.setAttribute("pList", pList);


		//リクエストが来たらplist.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/plist.jsp");
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
