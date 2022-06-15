package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//croomテーブルからidとroom_nameを取得する（null以外）
		//cmemberテーブルから各room_idに所属するuser_idの数を取得する→room_nameと照らし合わせて表示する
		//必要なデータを呼び出す処理が必要→データをリクエストスコープに格納
		//
		//
		// リクエストパラメータを取得する＜ここを項目数に合わせて変える＞
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String room_name = request.getParameter("ROOM_NAME");

		// 検索処理を行う＜newの後を全項目数に合わせて変える＞
		CroomDao croomDao = new CroomDao();
		List<Croom> roomList = croomDao.select(new Croom(id, room_name));


		// 検索結果をリクエストスコープに格納する
		request.setAttribute("roomList", roomList);

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
