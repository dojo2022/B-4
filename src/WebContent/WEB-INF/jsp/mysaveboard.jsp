<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/mypage.css">
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
			<h1 class = "title">保存した掲示板</h1>
			<br>
			        <!--犬猫の選択-->
        <div class="box">
        <input type="radio" name="cord" value="cat">猫
        <input type="radio" name="cord" value="dog">犬
        </div>
        <br>
        <br>
        <!--保存した掲示板を表示させる-->
        <!-- <div class="box">
            <p><a href ="/dotchiha/MysaveBoardServlet">4/2.15:00~Zoom オフ会</a></p>

        </div>
        <br>
        <div class="box">
            <p><a href ="/dotchiha/MysaveBoardServlet">5月オフ会の希望日程</a></p>
        </div> -->
        <!-- 保存した掲示板一覧表示 -->
        <form method="post" action="/dotchiha/ViewBoardServlet">
          <table id="board_list">
            <c:forEach var="e" items="${cardBoardS}" >
            <tr id="board_title"><td><button type = "submit" name = "board_id" value ="${e.board_id}">${e.title}</button></td></tr>
            </c:forEach>
          </table>
        </form>
        <br>


											<!--戻るボタン--->
								<div  class="back">
								<button class ="exit" type = "button" onclick ="history.back()">戻る</button>
​								</div>
	</main>
		<!--フッターここから-->
		<div class="font-size">
			<div id="footer">
			</div>
			<footer>
				<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
			</footer>
		</div>
	<!--フッターここまで-->
</body>
</html>