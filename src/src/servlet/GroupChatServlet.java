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

/**
 * Servlet implementation class GroupChatServlet
 */
@WebServlet("/GroupChatServlet")
public class GroupChatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public GroupChatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
//		String room_id = request.getParameter("room_id");
//		//String room_id = "1";//チャットルームのIDを送る
//
//		//ルームIDが1のメッセージを全て取り出す
//		//CroomDaoからSQLで取り出したCroomテーブルのデータをroomListに格納したものをselectで呼び出す
//		CMessageDao cmDao = new CMessageDao();//newの後はCroomDaoのpublicクラスを実体化したもの
//		List<CMessage> messageList = cmDao.select(room_id);//selectでCmessageDao.javaのCmessageDaoクラスのselect内容を実行できる。それをlistに格納している
//		//Croomテーブルの検索結果をリクエストスコープに格納する
//		request.setAttribute("messageList", messageList);
//
//
//		 //リクエストが来たらgroupchat.jspを表示する（フォワード）
//			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/groupchat.jsp");
//			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String room_id = request.getParameter("room_id");
		String room_name = request.getParameter("room_name");

		//String room_id = "1";//チャットルームのIDを送る
		//ルームIDが1のメッセージを全て取り出す
		//CMessageDaoからSQLで取り出したCmessageテーブルのデータをmessageListに格納したものをselectで呼び出す
		CMessageDao cmDao = new CMessageDao();//newの後はCmessageDaoのpublicクラスを実体化したもの
		List<CMessage> messageList = cmDao.select(room_id);//selectでCmessageDao.javaのCmessageDaoクラスのselect内容を実行できる。それをlistに格納している
		//Cmessageテーブルの検索結果をセッションスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("messageList", messageList);
		session.setAttribute("room_name", room_name);
//		request.setAttribute("messageList", messageList);


		 //リクエストが来たらgroupchat.jspを表示する（フォワード）
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/groupchat.jsp");
			dispatcher.forward(request, response);
		//【最終】チャットに送信されたメッセージを表示する
		//必要なデータ（DAO）
		//ルームID、メッセージ、送信者、日付、時刻
		//テキストエリアにMessageを入力し、送信する(POST)→リクエストパラメータを取得する
		//SQLでINSERTしてCMessageテーブルにメッセージを追加する
		//DAOでリクエストパラメータで取得したものをgetのところに書く
		//DAOでSQL文を実行し、結果をservletで表示する処理を書く
		//グループをリストに表示する（glist.jsp）←繰り返し処理で表示されるようになっている

	}

}
