package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CMemberDao;
import model.CPMember;

/**
 * Servlet implementation class PListServlet
 */
@WebServlet("/PListServlet")
public class PListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//SELECT croom.id FROM (croom left join cmember on CROOM.id = Cmember.room_id)  left join user as user on cmember.user_id = user.user_id where croom.room_name is null and user.user_id='nekozuki75@gmail.com';
		//メールアドレスを取得する(セッションスコープにあるはず)今回はダミーで入れておく「'nekozuki75@gmail.com'」
		//String user_id="nekozuki75@gmail.com";
		//list型のデータが返ってくるDAOを呼び出す(中身は上のsql)
		//このlistで取得できるidを使って以下のsqlをlistがある限り繰り返す
		//「select user.user_id,user.user_name from cmember left join user on cmember.user_id=user.user_id where cmember.room_id= ? and cmember.user_id not in(?);」
		//上の「3」の部分を置き換えて繰り返す
		//for(String　room_id_:コレクション名(list))｛DAOの処理を書く｝

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
		String user_id = (String)session.getAttribute("user_id");

		//検索結果をセッションスコープに格納する
		//HttpSession session = request.getSession();

		//個人チャットのルームIDを取り出す
		CMemberDao cmmDao = new CMemberDao();
		List<CPMember> pmemberList = cmmDao.select_pmember(user_id);

		ArrayList<List<CPMember>> pm= new ArrayList<List<CPMember>>();
		for(CPMember cp: pmemberList) {
			String room_id=cp.getId();
			List<CPMember> pmList = cmmDao.select_pm(user_id,room_id);
//			session.setAttribute("pmList", pmList);
			pm.add(pmList);
		}
		session.setAttribute("pmList", pm);


		//リクエストが来たらplist.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/plist.jsp");
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
