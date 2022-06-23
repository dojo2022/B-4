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
		<tabel>
		<c:forEach var="e" items="${cardFollowList}" >
			<tr>
			<td rowspan="3"><img src="./icon/${e.icon}" alt="アイコン" name="icon" class="icon"></td>
			<td align="center">ユーザー名<br><p class="fbox"><strong>${e.user_name}</strong></p></td>
		</c:forEach>
			<td><p class="fbox">
				フォロー数 ${follow_count}
			</p></td>
			<td><p class="fbox">
				フォロワー数 ${followed_count}
			</p></td>
			</tr>
			<c:forEach var="e" items="${cardFollowList}" >
			<p>📍${e.address}</p><br>
			</c:forEach>
		</tabel>


		<c:forEach var="e" items="${cardFollowList}" >​
			<form class="box">
				${e.freespace}
			</form>
		</c:forEach>
​		<br>
		<form method="get" action="/dotchiha/MyChangeInfServlet" class="mci">
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
<<<<<<< Updated upstream
			<form method="post" action="/dotchiha/UpdatePostsubServlet">
=======
>>>>>>> Stashed changes
				<!-- <a href="/dotchiha/UpdatePostServlet"> -->
				<table>
				<c:forEach var="e" items="${cardPost}">
<%-- 				cartTListにはidがないので取れない
	 				<li><input type="submit" name="post_id" value="${e.id}">${e.title}</li>--%>
 					<tr><td>
 					<input type="hidden"  name="cord" value="${e.cord}" >
 					<input type="hidden"  name="image" value="${e.image}" >
 					<input type="hidden"  name="postcomment" value="${e.postcomment}" >
 					<input type="hidden"  name="posttitle" value="${e.posttitle}" >
 					<input type="hidden"  name="id" value="${e.id}" >
 					<button type="submit" name="posttitle" value="${e.id}">${e.posttitle}</button>
 					</td></tr>
				</c:forEach>
				</table>
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
<<<<<<< Updated upstream
		<div class="font-size">
			<div id="footer">
			</div>
=======
	<div class="font-size">
		<div id="footer">
		</div>
>>>>>>> Stashed changes
			<footer>
				<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
			</footer>
		</div>
	<!--フッターここまで-->
</div>

<script src ="/dotchiha/js/common.js"></script>
</body>
</html>