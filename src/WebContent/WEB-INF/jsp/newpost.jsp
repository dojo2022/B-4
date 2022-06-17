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
	<!-- メイン -->
	<main>
		<h1 class = "title">新規投稿</h1>
		<form method="POST" action="/dotchiha/NewPostServlet" enctype="multipart/form-data">
			<table>
				<!-- タイトル -->
				<tr><td><label>
					<input type="text" name="posttitle">投稿タイトル
				</label></td></tr>
				<!-- 写真・画像のアップロード -->
				<tr><td><label>
					画像<input type="file" name="image" accept="image/*" onchange="previewImage(this);"><br>
					<canvas id="check" style="max-width:200px;"></canvas>
				</label></td></tr>
				<!-- 犬猫のラジオボタン -->
				<tr><td><label>
					<input type="radio" name="cord" value="0"> 猫
					<input type="radio" name="cord" value="1"> 犬
				</label></td></tr>
				<!-- 説明欄 -->
				<tr><td><label>
					<textarea rows="4" cols="30" name="postcomment"
					placeholder="魅力を伝えましょう!#で詳細検索が可能になります!"></textarea>
				</label></td></tr>
				<tr><td>
					<input type="submit" name="post" value="投稿">
				</td></tr>
			</table>
		</form>
	</main>
	<!-- フッター -->
	<div id="footer">
	    <footer>
	     	<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
	    </footer>
	 </div>
</div>
</body>
<script>
	function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('check');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
		console.log(fileReader.result) // ← (確認用)null
	}
</script>
</html>