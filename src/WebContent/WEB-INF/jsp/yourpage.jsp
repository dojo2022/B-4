<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>相手のページ｜今日はどっち派？</title>
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
		<h1 class = "title">相手のページ</h1>
								<img src="" alt="アイコン">
								<input type="submit" name="follow" value="フォローする">
								<br>
								<br>
								<strong>猫の青山</strong>


								<label for="follow">フォロー数 10人</label>
								<input type="checkbox" id="follow">
								<ul class="dropdown">
								<li>猫山</li>
								<li>犬山</li>
								<li>no neko no life</li>
								<li>猫</li>
								<li>inu</li>
								<li>cat</li>
								<li>pet</li>
								<li>dog</li>
								<li>neko</li>
								<li>innu</li>
								</ul>

								<label for="follower">フォロワー数 15人</label>
								<input type="checkbox" id="follower">
								<ul class="dropdown">
								<li>猫山</li>
								<li>犬山</li>
								<li>no neko no life</li>
								<li>猫</li>
								<li>inu</li>
								<li>cat</li>
								<li>pet</li>
								<li>dog</li>
								<li>neko</li>
								<li>innu</li>
								<li>in</li>
								<li>inu</li>
								<li>innnu</li>
								<li>ivu</li>
								<li>inubu</li>
								</ul>
​
								<form>
								自宅で猫ちゃんを三匹飼っています。よろしくお願いします。
								</form>
​
								<table>
								<tr><td>投稿タイトル一覧</td></tr>
								<tr><td><a href="/dotchiha/ViewPostServlet">・昼下がりの猫</a>
								</td></tr>
								<tr><td>・</td></tr>
								</table>

​
								<!--戻るボタン--->
								<button class ="exit" type = "button" onclick ="history.back()">戻る</button>
​
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