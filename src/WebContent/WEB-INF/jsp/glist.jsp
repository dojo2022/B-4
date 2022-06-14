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
		<h1 class = "title">グループチャット</h1>
				<br>
				<br>
				<form method="GET" action="/dotchiha/GCreateServlet" id="gcstart">
				<input type = "submit" name = "gstart" value = "会話を始める" class="button">
				<!-- onsubmitでgcreate.jspへ飛ぶ -->
				</form>
				<br>
				<br>
				<div id="glist">
				<form method="GET" action="/dotchiha/GroupChatServlet" id="gc">
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">${e.room_name}</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">15人
				</button>
				<!-- onsubmitでgroupchat.jspへ飛ぶ -->
				<br>
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">東京でおすすめの動物病院教えて</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">20人
				</button>
				<!-- onsubmitでgroupchat.jspへ飛ぶ -->
				<br>
				<br>
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">東京でおすすめの動物病院教えて</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">20人
				</button>
				<br>
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">東京でおすすめの動物病院教えて</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">20人
				</button>
				<br>
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">東京でおすすめの動物病院教えて</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">20人
				</button>
				<br>
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">東京でおすすめの動物病院教えて</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">20人
				</button>
				<br>
				<button type="submit" class="buttontag">
   				<span style="font-weight:bold;">東京でおすすめの動物病院教えて</span><br>
				<img src="/dotchiha/img/icon_user.png" width="15" height="15" alt="	人数">20人
				</button>
				</form></div>
				<br>
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