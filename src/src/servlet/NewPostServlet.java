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

import dao.PostDao;
import model.Post;
import model.Result;

/*import dao.PostDao;
import model.Post;*/

/**
 * Servlet implementation class NewPostServlet
 */
@MultipartConfig(location = "C:\\dotchiha\\WebContent\\img")
@WebServlet("/NewPostServlet")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//新規投稿ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/newpost.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Part image=request.getPart("image");//getPartで取得
		//リクエストパラメータの取得
		String posttitle = request.getParameter("posttitle");
		String image = this.getFileName(image);
		String cord = request.getParameter("cord");
		String postcomment = request.getParameter("postcomment");
		//画像のアップロード処理
		request.setAttribute("image", image);
		image.write(image);

		//登録処理
		PostDao pDao = new PostDao();
		if (pDao.insert(new Post(posttitle,image,cord,postcomment))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/dotchiha/LoginServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/dotchiha/LoginServlet"));
		}
		//結果ページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/idpwregistresult.jsp");
		dispatcher.forward(request, response);
	}
	//getFileName処理
	//ファイルの名前を取得する
	private String getFileName(Part image) {
		String name=null;
		for(String dispotion:image.getHeader("Content-Dispotion").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
			name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
			name = name.substring(name.lastIndexOf("\\") + 1);
			break;
			}
		}
		return name;
	}
}
