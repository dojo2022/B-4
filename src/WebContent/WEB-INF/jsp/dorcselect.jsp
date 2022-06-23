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
<!--<link rel="stylesheet" href="css/.css">-->

</head>
<body>
<div class ="wrapper">
	<!--  ヘッダーここから  -->
	<header class="header">
		<h1 id="logo" >
			<a href="/dotchiha/CorDBrowsServlet"><img src="img/title_logo.png" width="300" height="" alt="今日はどっち派？"></a></h1>
	</header>
	<!--  ヘッダーここまで  -->

	<!--メインここから-->
	<main>
		<h2 id="dorcselect">今日の気分は？</h2>
		<form method="POST" action="/dotchiha/CorDSelectServlet">
			<input type="hidden" name="FEELING" value="0">
			<input type="image"  src="img/selectingcat.png" alt="猫選択" >
		</form>
		<form method="POST" action="/dotchiha/CorDSelectServlet">
			<input type="hidden" name="FEELING" value="1">
			<input type="image" src="img/selectingdog.png" alt="犬選択">
		</form>

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
	<!-- javascriptここまで -->
</div>
</body>
</html>