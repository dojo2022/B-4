<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String posttitle = (String)request.getAttribute("postTitle"); %>
    <% String image = (String)request.getAttribute("image"); %>
    <% String postcomment = (String)request.getAttribute("postComment"); %>
    <% String date = (String)request.getAttribute("date"); %>
    <% String reaction = (String)request.getAttribute("reaction"); %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
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
		<h2 class= "vpost_title" id= "vpost_title">
		<% out.println(posttitle); %>
		</h2>
		<img src="img/<% out.println(image); %>" class="vpost_img" alt="投稿画像">
		<c:forEach var="e" items="${userinfo}" varStatus="status" >
		<table>
		<tr>
			<td id= "vpost_icon"><img src="img/${e.icon}" class="vpost_icon" alt="ユーザーアイコン"></td><td id="vpost_name">${e.user_name}</td>
		</tr>
		</table>
		</c:forEach>
		<p class= "vpost_exp" id= "vpost_exp"><% out.println(postcomment); %></p>
		<div id="vpost_reaction">
		<form method="POST" action="/dotchiha/ViewPostServlet">
		<input type="hidden" name="reaction" value="<% out.println(reaction); %>" >
		<input type="image" class="vpost_reaction" alt="リアクション" src="/dotchiha/img/reaction<% out.println(reaction); %>.png">
		</form>
		</div>
	</main>
​
	<!--メインここまで-->
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
<!--
	<script>
		'use strict'


		/* HTML文変数宣言 */
		let vpost_titleHTML = '';
		let vpost_imgHTML = '';
		let vpost_expHTML = '';
		let vpost_iconHTML = '';
		let vpost_nameHTML = '';
		let vpost_reactionHTML = '';

		/* HTML文生成 */
		vpost_titleHTML += posttitle;
		vpost_imgHTML = '<img src="img/4506970902_96cd8ae739.jpg" class="vpost_img" alt="">';
		vpost_expHTML = '何やら外が気になるご様子の猫ちゃん可愛い！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！';
		vpost_iconHTML = '<img src="img/icon_user.png" class="vpost_icon" alt="ユーザーアイコン">';
		vpost_nameHTML = '猫大好き';
		vpost_reactionHTML = '<img src="img/heartoff.png" class="vpost_reaction" alt="リアクションボタン">';

		/* HTML文代入 */
		document.getElementById('vpost_title').innerHTML = vpost_titleHTML;
		document.getElementById('vpost_img').innerHTML = vpost_imgHTML;
		document.getElementById('vpost_exp').innerHTML = vpost_expHTML;
		document.getElementById('vpost_icon').innerHTML = vpost_iconHTML;
		document.getElementById('vpost_name').innerHTML = vpost_nameHTML;
		document.getElementById('vpost_reaction').innerHTML = vpost_reactionHTML;
	</script>
	-->
	<script src ="/dotchiha/js/common.js"></script>
	<!-- javascriptここまで -->



</body>
</html>