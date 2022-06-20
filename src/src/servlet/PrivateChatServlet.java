package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("ID");
//
//		// 登録処理を行う<ここを変える>
//		CroomDao cDao = new CroomDao();
//		if (cDao.insert(new Croom(id))) {	// 登録成功
//			request.setAttribute("result",
//			new Result());
//		}
//		else {											// 登録失敗
//			request.setAttribute("result",
//			new Result());
//		}






		//リクエストが来たらprivatechat.jspを表示する（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/privatechat.jsp");
		dispatcher.forward(request, response);
	}

}
