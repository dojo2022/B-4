<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>今日はどっち派？</title>
	<link rel="stylesheet" href="/dotchiha/css/common.css">
</head>
<body>
	<div class ="wrapper">
		<!-- ヘッダー -->
		<header class="header">
			<h1 id="logo" >
				<a href="/dotchiha/CorDBrowsServlet"><img src="/dotchiha/img/titile_logo.png" width="300" height="" alt="今日はどっち派？"></a>
			</h1>
		</header>
		<!-- メイン -->
		<main>
			<form>
				<table>
					<!-- 投稿した内容のデータを持ってくる -->
					<!-- タイトル -->
					<tr><td><label>
						<input type="text" name="posttitle" value="${e.posttitle}">
					</label></td></tr>
					<!-- 画像 -->
					<tr><td><label>
						画像:<input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
						<canvas id="preview" style="max-width:200px;"></canvas><br>
					</label></td></tr>
					<!-- 犬猫のラジオボタン -->
					<tr><td><label>
						<input type="radio" name="cord"  value="${e.cord}">猫
						<input type="radio" name="cord"  value="${e.cord}">犬
					</label></td></tr>
					<!-- コメント -->
					<tr><td><label>
						<textarea rows="4" cols="30" name="postcomment" >${e.postcomment}</textarea>
					</label></td></tr>
					<!-- 編集・削除 -->
					<tr><td><label>
						<input type="submit" name="submit" value="更新">
						<input type="submit" name="submit" value="削除"><br>
					</label></td></tr>
				</table>
			</form>
			<!-- マイページに戻る -->
			<button class ="exit" type = "button" onclick ="history.back()">戻る</button>

		</main>
		<!-- フッター -->
		<div id="footer">
		   <footer>
		    	<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
		   </footer>
		</div>
	</div>
</body>
</html>