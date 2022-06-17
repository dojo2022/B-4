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
		<h1 class = "title">個人チャット</h1>
				<br>
				<br>
				<form>
				<input type = "submit" name = "pstart" value = "会話を始める" class="button">
				<!-- onsubmitで相互フォローの人の一覧表示 script? -->
				</form>
				<br>
				<br>
				<div id="plist">
				<!-- フォローしている人の一覧表示 -->
				<!-- 会話をしたしていないで区別するかも -->
				<form method="GET" action="/dotchiha/PrivateChatServlet" id="cselect2">
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>
				<input type = "submit" name = "private" value = "猫の青山" class="button">
				<!-- onsubmitでprivatechat.jspへ飛ぶ -->
				<br>

				<!-- アイコンありの場合はこっちを使う
				<button type="submit">
					<img src="  " width="30" height="30" alt="アイコン">
   					<span style="font-weight:bold;">犬鈴木</span>
				</button>
				<br> -->

				</form></div>
				<br>
				<!--戻るボタン--->
				<form method="GET" action="/dotchiha/CSelectServlet">
							<input type = "submit" name = "tolist" value = "戻る">
							<!-- onsubmitでglist.jspへ飛ぶ -->
						</form>
				<!-- <button class ="exit" type = "button" onclick ="history.back()">戻る</button> -->
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