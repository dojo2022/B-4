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
	<div class="wrapper">
		<header class="header">
			<h1 id="logo" >
				<a href="/dotchiha/CorDBrowsServlet">
				 <img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？">
				</a>
			</h1>
		</header>
		<!-- メイン -->
		<h1 class="title">新規アカウント登録</h1>
		<form method="POST" action="/dojo6/NewRegisterServlet.java" enctype="multipart/form-data">
			<table>
				<!-- アイコン表示 -->
				<tr><td><label>
					画像:<input type="file" name="icon" accept="image/*" onchange="previewImage(this);"><br>
					<canvas id="preview" style="max-width:200px;"></canvas><br>
				</label></td></tr>
				<!-- 名前入力 -->
				<tr><td><label>
					ユーザー名
					<input type="text" name="user_name">
				</label></td></tr>
				<!-- メールアドレス入力(ユーザーID) -->
				<tr><td><label>
					メールアドレス
					<input type="email" name="user_id">
				</label></td></tr>
				<!-- 住所(プルダウン) -->
				<tr><td><label>
					住所
					<select size="1" name="address">
					<option value ="ad00">選択なし</option>
					<option value ="ad01">北海道</option>
					<option value ="ad02">青森県</option>
					<option value ="ad03">岩手県</option>
					<option value ="ad04">宮城県</option>
					<option value ="ad05">秋田県</option>
					<option value ="ad06">山形県</option>
					<option value ="ad07">福島県</option>
					<option value ="ad08">茨城県</option>
					<option value ="ad09">栃木県</option>
					<option value ="ad10">群馬県</option>
					<option value ="ad11">埼玉県</option>
					<option value ="ad12">千葉県</option>
					<option value ="ad13">東京都</option>
					<option value ="ad14">神奈川県</option>
					<option value ="ad15">新潟県</option>
					<option value ="ad16">富山県</option>
					<option value ="ad17">石川県</option>
					<option value ="ad18">福井県</option>
					<option value ="ad19">山梨県</option>
					<option value ="ad20">長野県</option>
					<option value ="ad21">岐阜県</option>
					<option value ="ad22">静岡県</option>
					<option value ="ad23">愛知県</option>
					<option value ="ad24">三重県</option>
					<option value ="ad25">滋賀県</option>
					<option value ="ad26">京都府</option>
					<option value ="ad27">大阪府</option>
					<option value ="ad28">兵庫県</option>
					<option value ="ad29">奈良県</option>
					<option value ="ad30">和歌山県</option>
					<option value ="ad31">鳥取県</option>
					<option value ="ad32">島根県</option>
					<option value ="ad33">岡山県</option>
					<option value ="ad34">広島県</option>
					<option value ="ad35">山口県</option>
					<option value ="ad36">徳島県</option>
					<option value ="ad37">香川県</option>
					<option value ="ad38">愛媛県</option>
					<option value ="ad39">高知県</option>
					<option value ="ad40">福岡県</option>
					<option value ="ad41">佐賀県</option>
					<option value ="ad42">長崎県</option>
					<option value ="ad43">熊本県</option>
					<option value ="ad44">大分県</option>
					<option value ="ad45">宮崎県</option>
					<option value ="ad46">鹿児島県</option>
					<option value ="ad47">沖縄県</option>
					</select>
				</label></td></tr>
				<!-- パスワード入力 -->
				<tr><td><label>
					パスワード
					<input type="text" name="pw">
				</label></td></tr>
				<!-- フリースペース -->
				<tr><td><label>
					一言コメント
					<textarea rows="4" cols="30" name="freespace"></textarea>
				</label></td></tr>
				<!-- 登録・リセットボタン -->
				<tr><td>
					<input type="submit" id="register" name="submit" value="登録">
					<input type="reset" name="reset" value="リセット">
				</td></tr>
			</table>
		</form>
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
			var canvas = document.getElementById('preview');
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