<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String choice = (String)request.getAttribute("choice"); %>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/list.css">

</head>
<body>
<div class ="wrapper">
	<!--  ヘッダーここから  -->
	<header class="header">
		<h1 id="logo" >
			<a href="/dotchiha/CorDBrowsServlet"><img src="img/title_<% out.print(choice); %>logo.png" width="300" height="" alt="今日はどっち派？"></a></h1>

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
		<!-- 切り替えボタン -->
		<div id="switching_button">
		<form method="POST" action="/dotchiha/CorDSelectServlet" >
		<input type="hidden" name="FEELING" value="<% out.print(choice); %>">
		<input type="image" class="switching_button" src="img/switching.jpg" alt="切り替え">
		</form>
		</div>
				</div>
			</div>
		</div>
	</header>
	<!--  ヘッダーここまで  -->

	<!--メインここから-->
	<main>
		<table>
			<c:forEach var="e" items="${postList}" varStatus="status" >
				<script>
				'use strict'
				if(${status.count} % 2 == 1 ) {
					document.write('<tr>');
				}
				</script>
				<td>
				<form method="POST" action="/dotchiha/CorDBrowsServlet">
				<input type="hidden" name="ID" value="${e.id}">
				<input type="hidden" name="USERID" value="${e.user_id}">
				<input type="hidden" name="POSTTITLE" value="${e.posttitle}">
				<input type="hidden" name="CORD" value="${e.cord}">
				<input type="hidden" name="POSTCOMMENT" value="${e.postcomment}">
				<input type="hidden" name="DATE" value="${e.date}">
				<input type="hidden" name="IMAGE" value="${e.image}" >
				<input type="image" class="brows_img" alt="投稿画像" src="img/${e.image}">
				</form>
				</td>
				<script>
				'use strict'
				if(${status.last}) {
					document.write('</tr>');
				} else if(${status.count} % 2 == 0 ) {
					document.write('</tr>');
				}
				</script>
			</c:forEach>
		</table>
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
	<!-- javascriptここから-->
	<script src ="/dotchiha/js/common.js"></script>
</div>
</body>
</html>