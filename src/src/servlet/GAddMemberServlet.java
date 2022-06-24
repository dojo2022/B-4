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

import dao.CMemberDao;
import dao.CroomDao;
import model.CMember;
import model.Croom;

/**
 * Servlet implementation class GAddMember
 */
@WebServlet("/GAddMemberServlet")
public class GAddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GAddMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ルーム名を取り出す
				//CroomDaoからSQLで取り出したCroomテーブルのデータをroomListに格納したものをselectで呼び出す
				CroomDao cDao = new CroomDao();//newの後はCroomDaoのpublicクラスを実体化したもの
				List<Croom> roomList = cDao.select();//selectでCroomDao.javaのCroomDaoクラスのselect内容を実行できる。それをlistに格納している
				//Croomテーブルの検索結果をセッションスコープに格納する
				HttpSession session = request.getSession();
				session.setAttribute("roomList", roomList);

				 //リクエストが来たらglist.jspを表示する（フォワード）
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gaddmember.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			//リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String room_id = request.getParameter("room_id");
				String room_name = request.getParameter("room_name");
				//String user_id="nekozuki75@gmail.com"; //ログインしている人のID今回はダミーのデータ

			//セッションからユーザーIDを取得する
				HttpSession session = request.getSession();
				String user_id = (String)session.getAttribute("user_id");

			// メンバーの登録処理を行う
				CMemberDao cmDao = new CMemberDao();
				cmDao.insert(new CMember("",room_id,user_id));
				//HttpSession session = request.getSession();
				session.setAttribute("room_name", room_name);

			// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cselect.jsp");
			dispatcher.forward(request, response);


	}

}
