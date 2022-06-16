package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CMessageDao;
import model.CMessage;

/**
 * Servlet implementation class GroupChatAdd
 */
@WebServlet("/GroupChatAdd")
public class GroupChatAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");//メッセージのID
		String message = request.getParameter("message");//テキストエリアのnameと小文字など書き方をそろえる
		String room_id = request.getParameter("room_id");//チャットルームのIDを送る
		String sender_id = request.getParameter("sender_id");//セッションIDなどでログインしているユーザーのIDを送る
		String date = request.getParameter("date");//送信日付
		String time = request.getParameter("time");//送信時刻

		// 登録処理を行う<ここを変える>
		CMessageDao cmDao = new CMessageDao();
		cmDao.insert(new CMessage(id, message, room_id, sender_id, date, time));
		//CMessageDao cmDao = new CMessageDao();//newの後はCroomDaoのpublicクラスを実体化したもの
		List<CMessage> messageList = cmDao.select(room_id);//selectでCmessageDao.javaのCmessageDaoクラスのselect内容を実行できる。それをlistに格納している
		//Croomテーブルの検索結果をリクエストスコープに格納する
		request.setAttribute("messageList", messageList);


		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/groupchat.jsp");
		dispatcher.forward(request, response);




	}

}
