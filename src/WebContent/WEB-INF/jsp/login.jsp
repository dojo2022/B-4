<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン|今日はどっち派？</title>
</head>
<body>
<!-- ヘッダー -->
<h1>今日はどっち派？</h1>

<!-- メイン -->

<!-- <p class=cen>※ID=DOJO, PW=password でログインできます。</p> -->
<hr>
<form id="login_form" method="POST" action="/simpleBC/LoginServlet">
	<table >
		<tr><td><label>
			Users ID<br><input type="text" name="ID">
		</label></td></tr>
		<tr><td><label>
			Password<br><input type="password" name="PW">
		</label></td></tr>
		<tr><td>
			<input type="submit" name="LOGIN" value="ログイン">
		</td></tr>
		<tr><td>
			新規アカウント登録<input type="submit" name="NewLogin">
	</table>
</form>
<!-- フッター -->
</body>
</html>