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

import dao.CroomDao;
import model.Croom;

/**
 * Servlet implementation class GListServlet
 */
@WebServlet("/GListServlet")
public class GListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String user_id = "nekozuki75@gmail.com";

		//ルーム名を取り出す
		//CroomDaoからSQLで取り出したCroomテーブルのデータをroomListに格納したものをselectで呼び出す
		CroomDao cDao = new CroomDao();//newの後はCroomDaoのpublicクラスを実体化したもの
		List<Croom> roomalreadyList = cDao.select_already(user_id);//selectでCroomDao.javaのCroomDaoクラスのselect内容を実行できる。それをlistに格納している
		//Croomテーブルの検索結果をセッションスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("roomalreadyList", roomalreadyList);

		 //リクエストが来たらglist.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/glist.jsp");
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
