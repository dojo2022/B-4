<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マイページ｜情報の変更</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/mypage.css">

</head>
<body>
<div class ="wrapper">
	<!--  ヘッダーここから  -->
	<header class="header">
		<h1 id="logo" >
			<a href="/dotchiha/CorDBrowsServlet"><img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？"></a>
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
	<!--  ヘッダーここまで  -->
	<!--メインここから-->
	<main>
		<h1 class = "title">情報の変更</h1>
		<form method="POST" action="/dojo6/MyChangeInfServlet.java" enctype="multipart/form-data">
		<table>
						<!-- アイコン表示 -->
				<tr><td><label>
					画像:<input type="file" name="IMAGE" accept="image/*" onchange="previewImage(this);"><br>
					<canvas id="preview" style="max-width:200px;"></canvas><br>
					<input type="submit" value="送信">
				</label></td></tr>
				<!-- 名前入力 -->
				<tr><td><label>
					ユーザー名
					<input type="text" name="user_name">
				</label></td></tr>
				<!-- メールアドレス入力(ユーザーID) -->
				<tr><td><label>
					メールアドレス
					<input type="text" name="user_id">
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
					<textarea rows="4" cols="30" name="comment"></textarea>
				</label></td></tr>


											<!-- 更新する -->
								<button class ="update" type="button">更新する</button>
											<!--戻るボタン--->
								<button class ="exit" type = "button" onclick ="history.back()">戻る</button>
							</table>
						</form>
	</main>
​
	<!--メインここまで-->
	<!--フッターここから-->
	  <div id="footer">
	    <footer>
	     	<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
	    </footer>
	  </div>
	<!--フッターここまで-->
</div>
<script src ="/dotchiha/js/common.js"></script>
</body>
</html>