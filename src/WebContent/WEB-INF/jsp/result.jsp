<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>今日はどっち派？</title>
	<link rel="stylesheet" href="/dotchiha/css/common.css">
	<link rel="stylesheet" href="/dotchiha/css/login.css">
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
		<h2><c:out value="${result.title}" /></h2>
		<p><c:out value="${result.message}" /></p>
		<a href="${result.backTo}">戻る</a>
		<!-- フッター -->
		<div id="footer">
			<footer>
				<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
			</footer>
		</div>
	</div>
</body>
</html>