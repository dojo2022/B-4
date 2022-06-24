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
  </header>
  <!--  ヘッダーここまで  -->
  <!--メインここから-->
  <main>
    <h1 class = "title">掲示板</h1>
    <br>
    <br>


    <!-- アイコン＆ユーザー名 -->
    <div id="user_info">
      <form name="yourpage" action="/dotchiha/YourPageServlet" method ="POST">
        <a href="javascript:document.yourpage.submit()">
	       <img src="${'/dotchiha/img/'+=boardList[0].icon}" alt="アイコン" name="icon" class="icon" width="40" height="40">
	       ${boardList[0].user_name}
	      </a>
	      <input type="hidden" name="user_id" value="${boardList[0].user_id}">
      </form>
    </div>
    <!-- タイトル -->
    <h3>${boardList[0].title}</h3>
    <!-- 投稿内容 -->
    <p>${boardList[0].text}</p>
    <!-- 保存ボタン -->
    <form method="post" name="save" action="/dotchiha/ViewBoardSaveServlet">
      <input type="hidden" name="board_id" value="${boardList[0].id}">
      <input type="image" name = "board_id" id="save_button" value ="${boardList[0].id}" src="${save_button}" alt="保存">
    </form>

    <!-- コメント -->
    <table id="board_comment">
    <c:forEach var="e" items="${commentList}" >
      <tr id="comment"><td>${e.comment}</td></tr>
      <tr id="comment_date"><td>${e.date}</td></tr>
      <tr id="sender_name"><td>${e.user_name}</td></tr>
    </c:forEach>
    </table>
    <!-- コメント送信ボタン -->
    <div id="board_comment">
      <form  method="POST" action="/dotchiha/ViewBoardCommentServlet">
        <textarea name="comment" id="comment_message"></textarea>
        <button type="submit" name = "board_id" value = "${boardList[0].id}" id="send_button">送信</button>
      </form>
      </div>
    <!--戻るボタン--->
    <button class ="exit" type = "button" onclick ="history.back()">戻る</button>

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
<script src ="/dotchiha/js/common.js"></script>
</body>
</html>
