<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<!--<link rel="stylesheet" href="/dotchiha/css/.css">-->
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
    <form action="/dotchiha/BoardListServlet" method="post">
		  <input type="radio" name="dorc" value="0">
		  <label>猫</label>
		  <input type="radio" name="dorc" value="1">
		  <label>犬</label>
			<input type="submit" value="検索">
		<br>
		</form>
    <!-- 掲示板一覧表示 -->
    <form method="post" action="/dotchiha/ViewBoardServlet">
	    <table id="board_list">
	      <c:forEach var="e" items="${cardList}" >
	      <tr id="board_title"><td><button type = "submit" name = "board_id" value = "${e.id}">${e.title}</button></td></tr>
	      </c:forEach>
	    </table>
    </form>
    <br>

    <!-- 新規掲示板作成ボタン -->
    <button class ="boardpost" type = "button" onclick="location.href='/dotchiha/BoardPostServlet'">新規掲示板作成</button>


  </main>

  <!--メインここまで-->
  <!--フッターここから-->
    <div id="footer">
      <footer>
        <p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
      </footer>
    </div>
  <!--フッターここまで-->
</div>
<script src ="/dotchiha/js/common.js"></script>
</body>
</html>
