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
import dao.FollowDao;
import model.CMember;
import model.Croom;
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

		//String user_id="nekozuki75@gmail.com";

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//相互フォロー者を表示する
		FollowDao fDao = new FollowDao();
		List<Follow> pList = fDao.select_plist();
		//HttpSession session = request.getSession();
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
			request.setCharacterEncoding("UTF-8");
			String followed_id = request.getParameter("followed_id"); //相互フォローしている人のデータ
			//String user_id="nekozuki75@gmail.com"; //ログインしている人のID今回はダミーのデータ
			String id = null;
			String room_name = null;

		//セッションからユーザーIDを取得する
			HttpSession session = request.getSession();
			String user_id = (String)session.getAttribute("user_id");
//
//		// 登録処理を行う<ここを変える>
//			CroomDao cDao = new CroomDao();
//			if (cDao.insert(new Croom(id, room_name))) {  //ここを新しく作られたルームにメンバー登録する内容にする
//				CMemberDao = new CMemberDao();
//				cmDao.insert_member(new CMember(room_id, user_id))
//			}
//		//  登録された内容は個人チャットの一覧で確認する user_id,user_nameは表示する必要はないけどとりあえず書いておく
//		//	HttpSession session = request.getSession();
//		//	session.setAttribute("user_id", user_id);
//		//	session.setAttribute("user_name", user_name);

//		// 登録処理を行う(Croom)
			CroomDao cDao = new CroomDao();
			if (cDao.insert(new Croom(id, room_name))) {
			}

		//Croomテーブルでは存在するが、CmemberテーブルではnullであるCroomテーブルのid
			CMemberDao cmDao = new CMemberDao();
			String room_id = cmDao.select();
		// 登録処理を行う
			cmDao.insert(new CMember("",room_id,user_id));
			cmDao.insert(new CMember("",room_id,followed_id));

		// 結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cselect.jsp");
			dispatcher.forward(request, response);

	}

}
