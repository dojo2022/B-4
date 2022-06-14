<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="css/style.css">
<!--<link rel="stylesheet" href="css/.css">-->

</head>
<body>
<div class ="wrapper">
	<!--  ヘッダーここから  -->
	<header class="header">
		<h1 id="logo" >
			<a href="//Servlet"><img src="img/title_logo.png" width="300" height="" alt="今日はどっち派？"></a></h1>
	</header>
	<!--  ヘッダーここまで  -->

	<!--メインここから-->
	<main>
		<h2 id="dorcselect">今日の気分は？</h2>
		<a href="//Servret?select=0"><img src="img/selectingcat.jpg" alt="猫選択" class="dorcselect_img"></a>
		<a href="//Servret?select=1"><img src="img/selectingdog.jpg" alt="犬選択" class="dorcselect_img"></a>
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
	<script src ="/dotchiha/js/common.js"></script>
	<!-- javascriptここまで -->
</div>
</body>
</html>