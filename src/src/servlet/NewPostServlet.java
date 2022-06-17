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

/**
 * Servlet implementation class NewPostServlet
 */
@MultipartConfig(location = "C:\\dojo6\\src\\WebContent\\img")
@WebServlet("/NewPostServlet")
public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		Part image_S=request.getPart("image");//getPartで取得
		//リクエストパラメータの取得
		String posttitle = request.getParameter("posttitle");
		String image = this.getFileName(image_S);
		String cord = request.getParameter("cord");
		String postcomment = request.getParameter("postcomment");
//		if(cord == "dog") {
//			cord="1";
//
//		}else {
//			cord="0";
//		}
//		int code_i = Integer.parseInt(cord);
		String user_id = "test@gmail.com";
//		int cord = Integer.parseInt(request.getParameter("cord"));
//		String cordStr = this.getParameter("cord", request);
//		//犬猫の選択をif文で0.1表示を行う
//		if(cordStr.equals("cat")) {
//
//		}
//		int cord = Integer.parseInt(cordStr);

		//画像のアップロード処理
		request.setAttribute("image", image);
		image_S.write(image);

		//登録処理
		PostDao pDao = new PostDao();
		if (pDao.insert(new Post("",user_id,posttitle,image,cord,postcomment,""))) {	// 登録成功
			request.setAttribute("result",
			new Result("登録成功！", "レコードを登録しました。", "/dotchiha/NewPostServlet"));
		}
		else {												// 登録失敗
			request.setAttribute("result",
			new Result("登録失敗！", "レコードを登録できませんでした。", "/dotchiha/NewPostServlet"));
		}
		//結果ページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
		dispatcher.forward(request, response);
	}

//	private String getParameter(String key,HttpServletRequest request) {
//		Collection<Part> parts = null;
//		try {
//			parts = request.getParts();
//		} catch (IOException | ServletException e1) {
//			// TODO 自動生成された catch ブロック
//			e1.printStackTrace();
//		}
//
//    	String ret = null;
//    	for(Part part : parts) {
//    		System.out.println("name:" + part.getName());
//        	if(part.getName() != key) {
//        		continue;
//        	}
//
//            String contentType = part.getContentType();
//            log("contentType:" + contentType);
//            if ( contentType == null) {
//                try(InputStream inputStream = part.getInputStream()) {
//                    BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
//                    ret = bufReader.lines().collect(Collectors.joining());
//
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//    	}
//        return ret;
//	}

	//getFileName処理
	//ファイルの名前を取得する
	private String getFileName(Part image) {
		String name=null;
		for(String dispotion:image.getHeader("Content-Disposition").split(";")) {
			if (dispotion.trim().startsWith("filename")) {
			name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
			name = name.substring(name.lastIndexOf("\\") + 1);
			break;
			}
		}
		return name;
	}
}
