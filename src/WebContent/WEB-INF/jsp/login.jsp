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
			<h1 class="cen" >
				<img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？">
			</h1>
		</header>
		<!-- メイン -->
		<form id="login_form" method="POST" action="/dotchiha/LoginServlet">
			<table class="cen high">
				<tr><td>
					メールアドレス<br><input type="text" name="user_id" placeholder="メールアドレスを入力">
				</td></tr>
				<tr><td>
					Password<br><input type="password" name="pw" id="password" placeholder="パスワードを入力"><br>
					<!-- 確認ボタン外 -->
					<input class="left" type="checkbox" id="password-check">
				</td></tr>
				<tr><td>
					<input type="submit" name="LOGIN" value="ログイン">
				</td></tr>
			</table>
		</form>
		<!-- 新規アカウント登録 -->
		<div class="cen high2">
		<a href="/dotchiha/NewRegisterServlet">新規アカウント登録</a>
		</div>
		<!-- フッター -->
		<div class="font-size">
			<div id="footer">
			</div>
			<footer>
				<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
			</footer>
		</div>
	</div>
</body>

	<script>
		'use strict'
		//パスワードの確認（外）
		const pwd = document.getElementById('password');
		const pwdCheck = document.getElementById('password-check');
		pwdCheck.addEventListener('change', function() {
		    if(pwdCheck.checked) {
		        pwd.setAttribute('type', 'text');
		    } else {
		        pwd.setAttribute('type', 'password');
		    }
		}, false);


 		//パスワードの確認（中）
		/* const passwordToggle = document.querySelector('.js-password-toggle');
		passwordToggle.addEventListener('change', function () {
			const password = document.querySelector('.js-password'),
			      passwordLabel = document.querySelector('.js-password-label');
			if (password.type === 'password') {
			  password.type = 'text';
			  passwordLabel.innerHTML = '<i class="fas fa-eye-slash"></i>';
			} else {
			  password.type = 'password';
			  passwordLabel.innerHTML = '<i class="fas fa-eye"></i>';
			}
			password.focus();
		}); */

	</script>

</html>