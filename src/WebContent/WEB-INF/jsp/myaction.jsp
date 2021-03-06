<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>

<!--Bootstrapの適用
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
-->
<!--スマホ対応適用Bootstrap
<meta name="viewport" content="initial-scale=1" />
--<
<!-- 共通のCSSの適用 -->
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/mypage.css">
<!-- 画像のリスト表示 -->
<link rel="stylesheet" href="/dotchiha/css/list.css">


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
			<h2 class = "title">リアクションした投稿</h2>
			<br>
			<table>
			<c:forEach var="e" items="${cardPostR}"  varStatus="status" >
				<script>
				'use strict'
				if(${status.count} % 2 == 1 ) {
					document.write('<tr>');
				}
				</script>
				<td>
				<form method="POST" action="/dotchiha/CorDBrowsServlet">
				<input type="hidden" name="ID" value="${e.id}">
				<input type="hidden" name="USERID" value="${e.user_id}">
				<input type="hidden" name="POSTTITLE" value="${e.posttitle}">
				<input type="hidden" name="cord" value="${e.cord}">
				<input type="hidden" name="POSTCOMMENT" value="${e.postcomment}">
				<input type="hidden" name="date" value="${e.date}">
				<input type="hidden" name="IMAGE" value="${e.image}" >
				<input type="image" class="brows_img" alt="投稿画像" src="img/${e.image}">
				</form>
				</td>
				<script>
				'use strict'
				if(${status.last}) {
					document.write('</tr>');
				} else if(${status.count} % 2 == 0 ) {
					document.write('</tr>');
				}
				</script>
			</c:forEach>
		</table>
			<!-- ダミーデータ
			<div class="container-fluid">
				<div class="row">
				        <div class="col-6">


						<img src="./img/akitainu.png" alt="リアクションした投稿" class="rphoto">
                    	<p><a href ="/dotchiha/MyActionServlet">凛々しい柴</a></p>
						</div>

						<div class="col-6">
						<img src="./img/cat3.jpg" alt="リアクションした投稿" class="rphoto">
                    	<p><a href ="/dotchiha/MyActionServlet">いろんな表情</a></p>
						</div>
				</div>
				<div class="row">
                	    <div class="col-6">
						<img src="./img/cat_hand.jpg" alt="リアクションした投稿" class="rphoto">
                    	<p><a href ="/dotchiha/MyActionServlet">肉球が癒し</a></p>
						</div>

               	    	<div class="col-6">
						<img src="./img/inugoya.png" alt="リアクションした投稿" class="rphoto">
                    	<p><a href ="/dotchiha/MyActionServlet">おひるね</a></p>
						</div>
				</div>
				<div class="row">
                	    <div class="col-6">
						<img src="./img/omocha.png" alt="リアクションした投稿" class="rphoto">
                    	<p><a href ="/dotchiha/MyActionServlet">元気に遊ぶ！</a></p>
						</div>

				</div>

			</div>
			<br>
			-->



											<!--戻るボタン--->
								<div  class="back">
								<button class ="exit" type = "button" onclick ="history.back()">戻る</button>
​								</div>
	</main>
		<!--フッターここから-->
		<div class="font-size">
			<div id="footer">
			</div>
			<footer>
				<p>&copy;Copyright 貴方は猫派？犬派？ All rights reserved.</p>
			</footer>
		</div>
	<!--フッターここまで-->
</div>
</body>
</html>