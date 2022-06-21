<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<!-- 		<form method="POST" action="/dotchiha/MyChangeInfServlet" enctype="multipart/form-data"> -->
		<form method="POST" action="/dotchiha/MyChangeInfServlet">
		<table>
		<c:forEach var="e" items="${cardFollowList}" >
						<!-- アイコン表示 -->

				<tr><td><label>
					画像:
					<%-- <img src="./img/${e.icon}"> --%>
					<input type="file" name="image" accept="image/*" onchange="previewImage(this);"><br>
					<input type="hidden" name="imagefile" accept="image/*" onchange="previewImage(this);" value="${e.icon}"><br>
					<canvas id="preview" style="max-width:200px;"></canvas><br>

				</label></td></tr>
				<!-- 名前入力 -->
				<tr><td><label>
					ユーザー名
					<input type="text" name="user_name" value="${e.user_name}">
				</label></td></tr>
				<!-- 住所(プルダウン) -->
				<tr><td><label>
					住所
					<select size="1" name="address">
					<option value ="ad00"<c:if test="${cardFollowList.get(0).address == ''}"></c:if>>選択されていません</option>
					<option value ="北海道"<c:if test="${cardFollowList.get(0).address == '北海道'}">selected</c:if>>北海道</option>
					<option value ="青森県"<c:if test="${cardFollowList.get(0).address == '青森県'}">selected</c:if>>青森県</option>
					<option value ="ad03"<c:if test="${cardFollowList.get(0).address == '岩手県'}">selected</c:if>>岩手県</option>
					<option value ="ad04"<c:if test="${cardFollowList.get(0).address == '宮城県'}">selected</c:if>>宮城県</option>
					<option value ="ad05"<c:if test="${cardFollowList.get(0).address == '秋田県'}">selected</c:if>>秋田県</option>
					<option value ="ad06"<c:if test="${cardFollowList.get(0).address == '山形県'}">selected</c:if>>山形県</option>
					<option value ="ad07"<c:if test="${cardFollowList.get(0).address == '福島県'}">selected</c:if>>福島県</option>
					<option value ="ad08"<c:if test="${cardFollowList.get(0).address == '茨城県'}">selected</c:if>>茨城県</option>
					<option value ="ad09"<c:if test="${cardFollowList.get(0).address == '栃木県'}">selected</c:if>>栃木県</option>
					<option value ="ad10"<c:if test="${cardFollowList.get(0).address == '群馬県'}">selected</c:if>>群馬県</option>
					<option value ="ad11"<c:if test="${cardFollowList.get(0).address == '埼玉県'}">selected</c:if>>埼玉県</option>
					<option value ="ad12"<c:if test="${cardFollowList.get(0).address == '千葉県'}">selected</c:if>>千葉県</option>
					<option value ="ad13"<c:if test="${cardFollowList.get(0).address == '東京都'}">selected</c:if>>東京都</option>
					<option value ="ad14"<c:if test="${cardFollowList.get(0).address == '神奈川県'}">selected</c:if>>神奈川県</option>
					<option value ="ad15"<c:if test="${cardFollowList.get(0).address == '新潟県'}">selected</c:if>>新潟県</option>
					<option value ="ad16"<c:if test="${cardFollowList.get(0).address == '富山県'}">selected</c:if>>富山県</option>
					<option value ="ad17"<c:if test="${cardFollowList.get(0).address == '石川県'}">selected</c:if>>石川県</option>
					<option value ="ad18"<c:if test="${cardFollowList.get(0).address == '福井県'}">selected</c:if>>福井県</option>
					<option value ="ad19"<c:if test="${cardFollowList.get(0).address == '山梨県'}">selected</c:if>>山梨県</option>
					<option value ="ad20"<c:if test="${cardFollowList.get(0).address == '長野県'}">selected</c:if>>長野県</option>
					<option value ="ad21"<c:if test="${cardFollowList.get(0).address == '岐阜県'}">selected</c:if>>岐阜県</option>
					<option value ="ad22"<c:if test="${cardFollowList.get(0).address == '静岡県'}">selected</c:if>>静岡県</option>
					<option value ="ad23"<c:if test="${cardFollowList.get(0).address == '愛知県'}">selected</c:if>>愛知県</option>
					<option value ="ad24"<c:if test="${cardFollowList.get(0).address == '三重県'}">selected</c:if>>三重県</option>
					<option value ="ad25"<c:if test="${cardFollowList.get(0).address == '滋賀県'}">selected</c:if> >滋賀県</option>
					<option value ="ad26"<c:if test="${cardFollowList.get(0).address == '京都府'}">selected</c:if>>京都府</option>
					<option value ="ad27"<c:if test="${cardFollowList.get(0).address == '大阪府'}">selected</c:if>>大阪府</option>
					<option value ="ad28"<c:if test="${cardFollowList.get(0).address == '兵庫県'}">selected</c:if>>兵庫県</option>
					<option value ="ad29"<c:if test="${cardFollowList.get(0).address == '奈良県'}">selected</c:if>>奈良県</option>
					<option value ="ad30"<c:if test="${cardFollowList.get(0).address == '和歌山県'}">selected</c:if>>和歌山県</option>
					<option value ="ad31"<c:if test="${cardFollowList.get(0).address == '鳥取県'}">selected</c:if>>鳥取県</option>
					<option value ="ad32"<c:if test="${cardFollowList.get(0).address == '島根県'}">selected</c:if>>島根県</option>
					<option value ="ad33"<c:if test="${cardFollowList.get(0).address == '岡山県'}">selected</c:if>>岡山県</option>
					<option value ="ad34"<c:if test="${cardFollowList.get(0).address == '広島県'}">selected</c:if>>広島県</option>
					<option value ="ad35"<c:if test="${cardFollowList.get(0).address == '山口県'}">selected</c:if>>山口県</option>
					<option value ="ad36"<c:if test="${cardFollowList.get(0).address == '徳島県'}">selected</c:if>>徳島県</option>
					<option value ="ad37"<c:if test="${cardFollowList.get(0).address == '香川県'}">selected</c:if>>香川県</option>
					<option value ="ad38"<c:if test="${cardFollowList.get(0).address == '愛媛県'}">selected</c:if>>愛媛県</option>
					<option value ="ad39"<c:if test="${cardFollowList.get(0).address == '高知県'}">selected</c:if>>高知県</option>
					<option value ="ad40"<c:if test="${cardFollowList.get(0).address == '福岡県'}">selected</c:if>>福岡県</option>
					<option value ="ad41"<c:if test="${cardFollowList.get(0).address == '佐賀県'}">selected</c:if>>佐賀県</option>
					<option value ="ad42"<c:if test="${cardFollowList.get(0).address == '長崎県'}">selected</c:if>>長崎県</option>
					<option value ="ad43"<c:if test="${cardFollowList.get(0).address == '熊本県'}">selected</c:if>>熊本県</option>
					<option value ="ad44"<c:if test="${cardFollowList.get(0).address == '大分県'}">selected</c:if>>大分県</option>
					<option value ="ad45"<c:if test="${cardFollowList.get(0).address == '宮崎県'}">selected</c:if>>宮崎県</option>
					<option value ="ad46"<c:if test="${cardFollowList.get(0).address == '鹿児島県'}">selected</c:if>>鹿児島県</option>
					<option value ="ad47"<c:if test="${cardFollowList.get(0).address == '沖縄県'}">selected</c:if>>沖縄県</option>
					</select>
				</label></td></tr>
				<!-- フリースペース -->
				<tr><td><label>
					一言コメント
					<input type="text" name="comment" value="${e.freespace}">
				</label></td></tr>
				</c:forEach>


											<!-- 更新する -->
				<tr><td><input type="submit" name="SUBMIT" value="更新する"></td></tr>
											<!--戻るボタン--->
				<tr><td><input class ="exit" type = "button" onclick ="history.back()" value="戻る"></td></tr>
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