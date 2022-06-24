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

import dao.CMessageDao;
import model.CSenderName;

/**
 * Servlet implementation class PrivateChatServlet
 */
@WebServlet("/PrivateChatServlet")
public class PrivateChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivateChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String room_id = request.getParameter("room_id");
		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//CMessageDaoからSQLで取り出したCmessageテーブルとuserテーブルのデータをListに格納したものをselectで呼び出す
		CMessageDao cmDao = new CMessageDao();//newの後はCmessageDaoのpublicクラスを実体化したもの
		List<CSenderName> messageList = cmDao.select_username(room_id);//selectでCSenderName.javaのCmessageDaoクラスのselect内容を実行できる。それをlistに格納している

		//Cmessageテーブルの検索結果をセッションスコープに格納する
		//HttpSession session = request.getSession();
		session.setAttribute("messageList", messageList);
		session.setAttribute("room_id", room_id);

		//リクエストが来たらprivatechat.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privatechat.jsp");
		dispatcher.forward(request, response);
	}

}
