<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><!-- forEach文を使うにはこの文が必要 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/gt.css">
<!-- <link rel="stylesheet" href="gt.css"> -->
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
		<div id="gms_messages_container">

			<!-- ヘッダー部分 -->
			<div id="gms_chat_header">
				<!-- ステータス -->
				<div id="gms_chat_user_status">
					<!-- 戻るボタン -->
					<div id="gms_back">
					<button class ="exit" type = "button" onclick ="history.back()">←
					</button></div>
					<!-- ユーザー名 -->
					<div id="gms_chat_user_name">コスパいいおやつ選手権</div>
				</div>
			</div>

			<!-- タイムライン部分 -->

			<div id="gms_messages">
					<!-- メッセージ1（左側） -->
					<div class="gms_message gms_left">
					<div class="gms_message_senderl"></div>
					<c:forEach var="e" items="${messageList}" >
						<div class="gms_message_box">
								<div class="gms_message_text">${e.message}</div>
							</div>
					</c:forEach>
					</div>
					<div class="gms_clear"></div><!-- 回り込みを解除（スタイルはcssで充てる） -->

					<!-- メッセージ2（右側） -->
					<div class="gms_message gms_right">
					<div class="gms_message_senderr"></div>
						<div class="gms_message_box">
								<div class="gms_message_text"></div>
						</div>
					</div>
					<div class="gms_clear"></div><!-- 回り込みを解除（スタイルはcssで充てる） -->

			</div>

			<!-- テキストボックス、送信ボタン -->
			<div id="gms_send">
			<form  method="POST" action="/dotchiha/GroupChatAddServlet">
				<textarea name="message" id="gms_send_message"></textarea>
				<p>${e.room_id}</p>
				<!-- <input type ="submit" name = "send" value = "${e.message}" id="gms_send_btn"> -->
				<button type="submit" id="gms_send_btn" class = "buttontag" value = "${e.room_id}" name="room_id">送信</button>
			</form>
			</div>
		</div>
	</div>
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