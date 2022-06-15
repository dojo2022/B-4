package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		 //リクエストが来たらgroupchat.jspを表示する（フォワード）
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/groupchat.jsp");
			dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		//【最終】チャットに送信されたメッセージを表示する
		//必要なデータ（DAO）
		//ルームID、メッセージ、送信者、日付、時刻
		//テキストエリアにMessageを入力し、送信する(POST)→リクエストパラメータを取得する
		//SQLでINSERTしてCMessageテーブルにメッセージを追加する
		//DAOでリクエストパラメータで取得したものをgetのところに書く
		//DAOでSQL文を実行し、結果をservletで表示する処理を書く
		//グループをリストに表示する（glist.jsp）←繰り返し処理で表示されるようになっている


		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("ID");//メッセージのID
		String message = request.getParameter("message");//テキストエリアのnameと小文字など書き方をそろえる
		String room_id = request.getParameter("room_id");//チャットルームのIDを送る
		String sender_id = request.getParameter("sender_id");//セッションIDなどでログインしているユーザーのIDを送る
		String date = request.getParameter("date");//送信日付
		String time = request.getParameter("time");//送信時刻




		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/groupchat.jsp");
		dispatcher.forward(request, response);

	}

}
