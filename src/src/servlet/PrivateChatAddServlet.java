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
import model.CMessage;
import model.CSenderName;

/**
 * Servlet implementation class PrivateChatAddServlet
 */
@WebServlet("/PrivateChatAddServlet")
public class PrivateChatAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrivateChatAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		//String id = request.getParameter("ID");//メッセージのID
		String message = request.getParameter("message");//テキストエリアのnameと小文字など書き方をそろえる
		String room_id = request.getParameter("room_id");//チャットルームのIDを送る
		String sender_id = "nekozuki75@gmail.com";//セッションIDなどでログインしているユーザーのIDを送る

		// DAOを呼び出す
		CMessageDao cmDao = new CMessageDao();
		cmDao.insert(new CMessage("", message, room_id, sender_id, "",""));
		List<CSenderName> messageList = cmDao.select_username(room_id);
		//検索結果をsessionスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("messageList", messageList);

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privatechat.jsp");
		dispatcher.forward(request, response);
	}

}
