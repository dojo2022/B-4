<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
</head>
<body>
<div class="wrapper">
	<!-- ヘッダー -->
	<header class="header">
		<h1 id="logo" >
			<a href="/dotchiha/CorDBrowsServlet">
			 <img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？">
			</a>
		</h1>
	</header>
	<!-- メイン -->
<h2><c:out value="${result.title}" /></h2>
<p><c:out value="${result.message}" /></p>
<a href="/dotchiha/LoginServlet">ログイン画面へ戻る</a>
</div>
</body>
</html>