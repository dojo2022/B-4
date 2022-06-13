<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>保存した掲示板｜マイページ｜今日はどっち派？</title>
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
			<h1 class = "title">保存した掲示板</h1>
			        <!--犬猫の選択-->
        <div class="box">
        <input type="radio" name="cord" value="cat">猫
        <input type="radio" name="cord" value="dog">犬
        </div>
        <br>
        <br>
        <!--保存した掲示板を表示させる-->
        <div class="box">
            <p><a href ="/dotchiha/MysaveBoardServlet">4/2.15:00~Zoom オフ会</a></p>

        </div>
        <br>
        <div class="box">
            <p><a href ="/dotchiha/MysaveBoardServlet">5月オフ会の希望日程</a></p>
        </div>

											<!--戻るボタン--->
								<button class ="exit" type = "button" onclick ="history.back()">戻る</button>
​
	</main>
</body>
</html>