<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<a href="//Servlet"><img src="img/title_logo.png" width="300" height="" alt="今日はどっち派？"></a></h1>
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
	<div id="test"></div>
	<!-- 仮組、後でjavascriptで記述する  -->
		<table>
			<tr>
				<td><a href="//Servret?postid=X"><img src="img/0812045030.jpg" alt="投稿画像" class="brows_img"></a></td>
				<td><a href="//Servret"><img src="img/0812110532.jpg" alt="投稿画像" class="brows_img"></a></td>
			</tr>
			<tr>
				<td><a href="//Servret"><img src="img/5935050477_034987fd07.jpg" alt="投稿画像" class="brows_img"></a></td>
				<td><a href="//Servret"><img src="img/7108974657_3171ea4aaa.jpg" alt="投稿画像" class="brows_img"></a></td>
			</tr>
			<tr>
				<td><a href="//Servret"><img src="img/3936850490_5f5fd80a21.jpg" alt="投稿画像" class="brows_img"></a></td>
				<td><a href="//Servret"><img src="img/0813032255.jpg" alt="投稿画像" class="brows_img"></a></td>
			</tr>
			<tr>
				<td><a href="//Servret"><img src="img/4506970902_96cd8ae739.jpg" alt="投稿画像" class="brows_img"></a></td>
				<td><a href="//Servret"><img src="img/4835109188_725430edf5.jpg" alt="投稿画像" class="brows_img"></a></td>
			</tr>
		</table>
	</main>

	<!--メインここまで-->
	<!--フッターここから-->
	<div id="footer">
		<footer>
			<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
		</footer>
	</div>
	<!--フッターここまで-->
	<!-- javascriptここから-->
	<script>
	document.getElementById('test').innerHTML= sfeeling;
	</script>
	<script src ="/dotchiha/js/common.js"></script>
	<!-- javascriptここまで -->
</div>
</body>
</html>