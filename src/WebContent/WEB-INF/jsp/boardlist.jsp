<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/board.css">
</head>
<body>
<div class ="wrapper">
  <!--  ヘッダーここから  -->
  <header class="header">
    <h1 id="logo" >
      <a href="/dotchiha/CorDBrowsServlet"><img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？"></a>
    </h1>
    <!--  ハンバーガーメニュー  -->
    <div class="ham" id="ham">
      <span class="ham_line ham_line1"></span>
      <span class="ham_line ham_line2"></span>
      <span class="ham_line ham_line3"></span>
      <div class="menu_wrapper" id="menu_wrapper">
        <div class="menu">
          <ul>
              <li><a href="/dotchiha/NewPostServlet">新規投稿</a></li>
              <li><a href="/dotchiha/CorDBrowsServlet">閲覧</a></li>
              <li><a href="/dotchiha/BoardListServlet">掲示板</a></li>
              <li><a href="/dotchiha/CSelectServlet">チャット</a></li>
              <li><a href="/dotchiha/MyPageServlet">マイページ</a></li>
              <li><a href="/dotchiha/LogoutServlet" onclick="return confirm('ログアウトしてよろしいですか？')">ログアウト</a></li>
          </ul>
        </div>
      </div>
    </div>
  </header>
  <!--  ヘッダーここまで  -->
  <!--メインここから-->
  <main>
    <h1 class = "title">掲示板</h1>
    <br>
    <br>
    <!-- 犬猫選択ボタン -->
    <div class="dorc">
    <form action="/dotchiha/BoardListServlet" method="post">
		  <input type="checkbox" name="cat" value="1"><label>猫</label>
      <input type="checkbox" name="dog" value="1"><label>犬</label>
			<input type="submit" value="検索">
		</form>
		</div>
		<br>
    <!-- 掲示板一覧表示 -->

	   <div class="board_list">
	      <c:forEach var="e" items="${boardList}" >
		      <div class="user_date">
			      <div class="user_info">
				      <form name="yourpage" action="/dotchiha/YourPageServlet" method ="POST">
				        <a href="javascript:document.yourpage.submit()">
				        <img src="${'/dotchiha/img/'+=e.icon}" alt="アイコン" name="icon" class="icon" width="20" height="20">
				        ${e.user_name}
				        </a>
				        <%-- <input type="image" name = "user_id" id="save_button" value ="${e.user_id}" src="${'/dotchiha/img/'+=e.icon}"  width="20" height="20">
				        <a href="javascript:document.yourpage.submit()">${e.user_name}</a> --%>
				        <input type="hidden" name="user_id" value="${e.user_id}">
				      </form>
			      </div>
            <div class="board_date">${e.date}</div>
          </div>
		       <form method="post" action="/dotchiha/ViewBoardServlet">
		         <button class="board_title" type = "submit" name = "board_id" value = "${e.id}">${e.title}</button>
		       </form>
	      </c:forEach>
	    </div>

    <br>
    <br>

    <!-- 新規掲示板作成ボタン -->
    <div class="boardpost">
    <button class ="boardpost" type = "button" onclick="location.href='/dotchiha/BoardPostServlet'">新規掲示板作成</button>
    </div>
  </main>

  <!--メインここまで-->
  <!--フッターここから-->
  <div class="font-size">
    <div id="footer">
    </div>
    <footer>
      <p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
    </footer>
  </div>
  <!--フッターここまで-->
</div>
<script src ="/dotchiha/js/common.js">
document.getElementById("user").onclick = function() {
	  document.yourpage.submit();
};

</script>
</body>
</html>
