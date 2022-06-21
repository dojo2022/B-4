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
		<h1 class = "title">マイページ</h1>
		<br>
		<br>

		<c:forEach var="e" items="${cardFollowList}" >

			<img src="./img/${e.icon}" alt="アイコン" name="icon" class="icon"><br>


			<p>📍${e.address}</p><br>

			<p class="uname"><strong>${e.user_name}</strong></p>
			<br><br>
		</c:forEach>
		<div class="fbox">
			フォロー数 ${follow_count}
		</div>
		<br>
		<div class="fbox">
			フォロワー数 ${followed_count}
		</div>
		<c:forEach var="e" items="${cardFollowList}" >​
			<form class="box">
				${e.freespace}
			</form>
		</c:forEach>
​		<br>
		<form method="get" action="/dotchiha/MyChangeInfServlet">
			<button type="submit" name="MCI" value="nekozuki75@gmail.com">情報の変更</button>
​		</form>

		<h3>投稿タイトル一覧</h3>
<%-- 		<div class="bbox">
			<ul>
				<c:forEach var="e" items="${cardTList}" >
					<li><a href="/dotchiha/ViewPostServlet">${e.title}</a></li>
				</c:forEach>
			</ul>
		</div> --%>
		<div class="bbox">
			<form method="post" action="/dotchiha/UpdatePostServlet">
				<c:forEach var="e" items="${cardPost}">
	<%--			cartTListにはidがないので取れない
	 				<li><input type="submit" name="post_id" value="${e.id}">${e.title}</li>
 --%>
 					<li>${e.posttitle}<input type="submit" name="" value="編集する"></li>
 					<input type="hidden" name="posttitle" value="${e.posttitle}">
				</c:forEach>
			</form>
		</div>
​
		<div class="box">
			<a href="/dotchiha/MyActionServlet">リアクションした投稿</a>
		</div>
		<br>
		<div class="box">
			<a href="/dotchiha/MySaveBoardServlet">保存した掲示板</a>
		</div>
​
	</main>
​
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