<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
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
  </header>
  <!--  ヘッダーここまで  -->
  <!--メインここから-->
  <main>
    <h1 class = "title">掲示板</h1>
    <br>
    <br>

    <!-- アイコン＆ユーザー名 -->

    <!-- タイトル -->
     ${ret.title}
    <!-- 投稿内容 -->

    <!-- 保存ボタン -->

    <!-- コメント -->
    <c:forEach var="e" items="${cardList}" >
      <tr><td><button type = "submit" name = "board_id" value = "${e.id}">${e.title}</button></td></tr>
    </c:forEach>
    <!-- コメント送信ボタン -->

    <!--戻るボタン--->
    <button class ="exit" type = "button" onclick ="history.back()">戻る</button>

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
<c:forEach var="e" items="${cardList}" >
        <tr id="${e.id}"><td><button type = "submit" name = "id" value = "${e.id}">${e.title}</button></td></tr>
        </c:forEach>