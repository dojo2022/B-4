package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.UserDao;

/**
 * Servlet implementation class NewRegisterServlet
 */
//↓これ絶対入れてね！！
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\icon") // アップロードファイルの一時的な保存先
@WebServlet("/NewRegisterServlet")
public class NewRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Part part=request.getPart("icon");//getPartで取得
		// リクエストパラメータを取得する
//		String id = request.getParameter("id");
//		String user_id = request.getParameter("user_id");
//		String user_name = request.getParameter("user_name");
//		String address = request.getParameter("address");
		//thisでこのServlet上でgetFileName処理を行う
		String icon = this.getFileName(part);
		String freespace = request.getParameter("freespace");
		String pw = request.getParameter("pw");

		//画像のアップロード処理
		request.setAttribute("image", icon);
		part.write(icon);

		// 登録処理を行う
		UserDao iDao = new UserDao();
//		if (iDao.insert(new User(id,user_id,user_name,address,icon,freespace,pw))) {	// 登録成功
//			request.setAttribute("result",
//			new Result("登録成功！", "レコードを登録しました。", "/dotchiha/LoginServlet"));
//		}
//		else {												// 登録失敗
//			request.setAttribute("result",
//			new Result("登録失敗！", "レコードを登録できませんでした。", "/dotchiha/LoginServlet"));
//		}

		// 結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}
	//getFileName処理
	//ファイルの名前を取得する
	private String getFileName(Part part) {
		String name=null;
		for(String dispotion:part.getHeader("Content-Dispotion").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
			name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
			name = name.substring(name.lastIndexOf("\\") + 1);
			break;
			}
		}
		return name;
	}
}