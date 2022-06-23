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
<link rel="stylesheet" href="/dotchiha/css/pt.css">
<!-- <link rel="stylesheet" href="pt.css"> -->
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
<!-- ここからチャットの画面 参考は「ゼロから作る簡単webチャットUIの作り方」-->
<!-- 自分やユーザーの情報 -->
<!--<h3 id ="me" user_id="1">あなたはユーザー1です</h3>
<h3 id="partner" thread_id="1">相手</h3>
<div id="users">
	<button class="user" user_id="2">ユーザー2</button>
</div>-->
<br>
	<div id = "your_container">

		<!-- チャットの外側部分 -->
		<div id="pms_messages_container">

			<!-- ヘッダー部分 -->
			<div id="pms_chat_header">
				<!-- ステータス -->
				<div id="pms_chat_user_status">
					<!-- 戻るボタン -->
					<div id="pms_back">
						<form method="GET" action="/dotchiha/PListServlet">
							<input type = "submit" name = "tolist" value = "←">
							<!-- onsubmitでplist.jspへ飛ぶ -->
						</form>
					<!-- <button class ="exit" type = "button" onclick ="history.back()">←</button> -->
					</div>
					<!-- ユーザー名 -->
					<div id="pms_chat_user_name"></div>
				</div>
			</div>

			<!-- タイムライン部分 -->
			<div id="pms_messages">
					<!-- メッセージ1（左側） -->
					<div class="pms_message pms_left">
						<c:forEach var="e" items="${messageList}" >
							<div class="gms_message_senderl">${e.user_name}</div>
							<div class="pms_message_box">
								<div class="pms_message_text">${e.message}</div>
							</div>
						</c:forEach>
					</div>
					<div class="pms_clear"></div><!-- 回り込みを解除（スタイルはcssで充てる） -->

					<!-- メッセージ2（右側） -->
					<!-- <div class="pms_message pms_right"> -->
					<!-- <div class="pms_message_box"> -->
					<!-- <div class="pms_message_text">よろしくお願いします。</div> -->
					<!-- </div> -->
					<!-- </div> -->
					<!-- <div class="pms_clear"></div> --><!-- 回り込みを解除（スタイルはcssで充てる） -->
			</div>

			<!-- テキストボックス、送信ボタン -->
			<div id="pms_send">
			<form  method="POST" action="/dotchiha/PrivateChatAddServlet">
				<textarea name="message" id="pms_send_message"></textarea>
				<!-- e は使えないのでリクエストスコープ名を使用-->
				<button type="submit" id="pms_send_btn" class = "buttontag" value = "${room_id}" name="room_id">送信</button>
			</form>
			</div>
		</div>
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
<script src ="/dotchiha/js/common.js"></script>
</body>
</html>