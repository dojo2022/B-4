<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/chat.css">
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
		<h1 class = "title">グループをつくる</h1>
				<br>
				<br>
				<form method="POST" action="/dotchiha/GCreateServlet" id="groupchatcreate">
				<div class="on">
				<p>※グループの名前は必ず入力してください</p>
				<textarea name="room_name" placeholder="例：猫のかわいさをひたすら語る"></textarea></div>
				<br>
				<br>
				<input type ="submit" name = "gcreate" value = "作成" class="button">
				<br>
				<span id="errormessage"></span>
				<!-- onsubmitでグループ作成される glist.jspに表示する -->
				</form>
				<br>
				<br>
				<!--戻るボタン--->
				<button class ="exit" type = "button" onclick ="history.back()">やめる</button>
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
<script src ="/dotchiha/js/chat.js"></script>
</body>
</html>