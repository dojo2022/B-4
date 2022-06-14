<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<!--  ヘッダーここから  -->
		<header class="header">
			<h1 id="logo" >
				<img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？">
			</h1>
		</header>
		<!-- メイン -->
		<form id="login_form" method="POST" action="/dotchiha/LoginServlet">
			<table >
				<tr><td><label>
					メールアドレス<br><input type="text" name="id">
				</label></td></tr>
				<tr><td><label>
					Password<br><input type="password" name="pw">
				</label></td></tr>
				<tr><td>
					<input type="submit" name="LOGIN" value="ログイン">
				</td></tr>
			</table>
		</form>
		<!-- 新規アカウント登録 -->
		<a href="/dotchiha/NewRegisterSrevlet">新規アカウント登録</a>
		<!-- フッター -->
		<div id="footer">
			 <footer>
				<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
			 </footer>
		</div>
	</div>
</body>
</html>