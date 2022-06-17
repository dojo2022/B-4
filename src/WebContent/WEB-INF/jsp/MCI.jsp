<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
	<link rel="stylesheet" href="/dotchiha/css/common.css">
	<link rel="stylesheet" href="/dotchiha/css/mypage.css">
</head>
<body>
	<div class ="wrapper">
		<!-- ヘッダー -->
		<header class="header">
			<h1 id="logo" >
				<img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？">
			</h1>
		</header>
		<!-- メイン -->
		<h1><c:out value="${result.title}" /></h1>
			<hr>
			<p><c:out value="${result.message}" /></p>

	</div>
</body>
</html>