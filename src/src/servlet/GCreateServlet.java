package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CMemberDao;
import dao.CroomDao;
import model.CMember;
import model.Croom;

/**
 * Servlet implementation class GCreateServlet
 */
@WebServlet("/GCreateServlet")
public class GCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストが来たらgcreate.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gcreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String room_name = request.getParameter("room_name");//テキストエリアのnameと小文字など書き方をそろえる

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");
//		String user_id = "nekozuki75@gmail.com";

		// 登録処理を行う(Croom)
		CroomDao cDao = new CroomDao();
		if (cDao.insert(new Croom(id, room_name))) {

		}

		//Croomテーブルでは存在するが、CmemberテーブルではnullであるCroomテーブルのid
		CMemberDao cmDao = new CMemberDao();
		String room_id = cmDao.select();

		// 登録処理を行う
		cmDao.insert(new CMember("",room_id,user_id));


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cselect.jsp");
		dispatcher.forward(request, response);
	}

}
