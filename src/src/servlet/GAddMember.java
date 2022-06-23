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
 * Servlet implementation class GAddMember
 */
@WebServlet("/GAddMember")
public class GAddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GAddMember() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
