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

		//【最終的な表示】繰り返し処理でグループの一覧を表示する
		//必要なデータ（DAO）
		//croomテーブルからidとroom_nameを取得する（null以外）→OK
		//cmemberテーブルから各room_idに所属するuser_idの数を取得する→room_nameと照らし合わせて表示する
		//必要なデータを呼び出す処理が必要→データをリクエストスコープに格納

		//ルーム名を取り出す
		//CroomDaoからSQLで取り出したCroomテーブルのデータをroomListに格納したものをselectで呼び出す
		CroomDao cDao = new CroomDao();//newの後はCroomDaoのpublicクラスを実体化したもの
		List<Croom> roomList = cDao.select();//selectでCroomDao.javaのCroomDaoクラスのselect内容を実行できる。それをlistに格納している
		//Croomテーブルの検索結果をセッションスコープに格納する
//		request.setAttribute("roomList", roomList);
		HttpSession session = request.getSession();
		session.setAttribute("roomList", roomList);

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
