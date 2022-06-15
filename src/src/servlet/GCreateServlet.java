package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CroomDao;
import model.Croom;
import model.Result;

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
		// TODO Auto-generated method stub
		//doGet(request, response);

		//【最終】グループを作るを押したら新しくグループが作られる  BCの登録を参考にする
		//テキストエリアにグループ名を入力し、送信する(POST)→リクエストパラメータを取得する
		//SQLでINSERTしてCroomテーブルにグループを追加する
		//DAOでリクエストパラメータで取得したものをgetのところに書く
		//DAOでSQL文を実行し、結果をservletで表示する処理を書く←？？？
		//グループをリストに表示する（glist.jsp）←繰り返し処理で表示されるようになっている


		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");
		String room_name = request.getParameter("room_name");//テキストエリアのnameと小文字など書き方をそろえる

		// 登録処理を行う<ここを変える>
		CroomDao cDao = new CroomDao();
		if (cDao.insert(new Croom(id, room_name))) {	// 登録成功
			request.setAttribute("result",
			new Result());
		}
		else {											// 登録失敗
			request.setAttribute("result",
			new Result());
		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/cselect.jsp");
		dispatcher.forward(request, response);
	}

}
