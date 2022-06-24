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

import dao.BoardSDao;
import model.BoardS;

/**
 * Servlet implementation class MySaveBoardServlet
 */
@WebServlet("/MySaveBoardServlet")
public class MySaveBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MySaveBoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//セッションからユーザーIDを取得する
		HttpSession session = request.getSession();
//		String user_id = (String)session.getAttribute("user_id");
		String user_id = "nekozuki75@gmail.com";

		BoardSDao bsDao = new BoardSDao();
		//タイトルを取得するdaoを作成する
		List<BoardS> cardBoardS = bsDao.select_board_id(user_id);
		//取得したデータをリクエストスコープに追加格納する
		session.setAttribute("cardBoardS",cardBoardS);


	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mysaveboard.jsp");
	dispatcher.forward(request, response);

}
}
