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

		<c:forEach var="e" items="${cardFollowList}" >
						<!-- アイコン表示 -->

					画像:
					<%-- <img src="./img/${e.icon}"> --%>
					<input type="file" name="image" accept="image/*" onchange="previewImage(this);"><br>
					<input type="hidden" name="imagefile" accept="image/*" onchange="previewImage(this);" value="${e.icon}"><br>
					<canvas id="preview" style="max-width:200px;"></canvas><br>

					<table>
						<!-- 名前入力 -->
					<tr><td>ユーザー名　：</td>
					<td><input type="text" name="user_name" value="${e.user_name}"></td>
					</tr>


				<!-- 住所(プルダウン) -->

					<tr><td>　　住所　　：</td>
					<td>
					<select size="1" name="address">
					<option value =""<c:if test="${cardFollowList.get(0).address == ''}"></c:if>>選択されていません</option>
					<option value ="北海道"<c:if test="${cardFollowList.get(0).address == '北海道'}">selected</c:if>>北海道</option>
					<option value ="青森県"<c:if test="${cardFollowList.get(0).address == '青森県'}">selected</c:if>>青森県</option>
					<option value ="岩手県"<c:if test="${cardFollowList.get(0).address == '岩手県'}">selected</c:if>>岩手県</option>
					<option value ="宮城県"<c:if test="${cardFollowList.get(0).address == '宮城県'}">selected</c:if>>宮城県</option>
					<option value ="秋田県"<c:if test="${cardFollowList.get(0).address == '秋田県'}">selected</c:if>>秋田県</option>
					<option value ="山形県"<c:if test="${cardFollowList.get(0).address == '山形県'}">selected</c:if>>山形県</option>
					<option value ="福島県"<c:if test="${cardFollowList.get(0).address == '福島県'}">selected</c:if>>福島県</option>
					<option value ="茨城県"<c:if test="${cardFollowList.get(0).address == '茨城県'}">selected</c:if>>茨城県</option>
					<option value ="栃木県"<c:if test="${cardFollowList.get(0).address == '栃木県'}">selected</c:if>>栃木県</option>
					<option value ="群馬県"<c:if test="${cardFollowList.get(0).address == '群馬県'}">selected</c:if>>群馬県</option>
					<option value ="埼玉県"<c:if test="${cardFollowList.get(0).address == '埼玉県'}">selected</c:if>>埼玉県</option>
					<option value ="千葉県"<c:if test="${cardFollowList.get(0).address == '千葉県'}">selected</c:if>>千葉県</option>
					<option value ="東京都"<c:if test="${cardFollowList.get(0).address == '東京都'}">selected</c:if>>東京都</option>
					<option value ="神奈川県"<c:if test="${cardFollowList.get(0).address == '神奈川県'}">selected</c:if>>神奈川県</option>
					<option value ="新潟県"<c:if test="${cardFollowList.get(0).address == '新潟県'}">selected</c:if>>新潟県</option>
					<option value ="富山県"<c:if test="${cardFollowList.get(0).address == '富山県'}">selected</c:if>>富山県</option>
					<option value ="石川県"<c:if test="${cardFollowList.get(0).address == '石川県'}">selected</c:if>>石川県</option>
					<option value ="福井県"<c:if test="${cardFollowList.get(0).address == '福井県'}">selected</c:if>>福井県</option>
					<option value ="山梨県"<c:if test="${cardFollowList.get(0).address == '山梨県'}">selected</c:if>>山梨県</option>
					<option value ="長野県"<c:if test="${cardFollowList.get(0).address == '長野県'}">selected</c:if>>長野県</option>
					<option value ="岐阜県"<c:if test="${cardFollowList.get(0).address == '岐阜県'}">selected</c:if>>岐阜県</option>
					<option value ="静岡県"<c:if test="${cardFollowList.get(0).address == '静岡県'}">selected</c:if>>静岡県</option>
					<option value ="愛知県"<c:if test="${cardFollowList.get(0).address == '愛知県'}">selected</c:if>>愛知県</option>
					<option value ="三重県"<c:if test="${cardFollowList.get(0).address == '三重県'}">selected</c:if>>三重県</option>
					<option value ="滋賀県"<c:if test="${cardFollowList.get(0).address == '滋賀県'}">selected</c:if> >滋賀県</option>
					<option value ="京都府"<c:if test="${cardFollowList.get(0).address == '京都府'}">selected</c:if>>京都府</option>
					<option value ="大阪府"<c:if test="${cardFollowList.get(0).address == '大阪府'}">selected</c:if>>大阪府</option>
					<option value ="兵庫県"<c:if test="${cardFollowList.get(0).address == '兵庫県'}">selected</c:if>>兵庫県</option>
					<option value ="奈良県"<c:if test="${cardFollowList.get(0).address == '奈良県'}">selected</c:if>>奈良県</option>
					<option value ="和歌山県"<c:if test="${cardFollowList.get(0).address == '和歌山県'}">selected</c:if>>和歌山県</option>
					<option value ="鳥取県"<c:if test="${cardFollowList.get(0).address == '鳥取県'}">selected</c:if>>鳥取県</option>
					<option value ="島根県"<c:if test="${cardFollowList.get(0).address == '島根県'}">selected</c:if>>島根県</option>
					<option value ="岡山県"<c:if test="${cardFollowList.get(0).address == '岡山県'}">selected</c:if>>岡山県</option>
					<option value ="広島県"<c:if test="${cardFollowList.get(0).address == '広島県'}">selected</c:if>>広島県</option>
					<option value ="山口県"<c:if test="${cardFollowList.get(0).address == '山口県'}">selected</c:if>>山口県</option>
					<option value ="徳島県"<c:if test="${cardFollowList.get(0).address == '徳島県'}">selected</c:if>>徳島県</option>
					<option value ="香川県"<c:if test="${cardFollowList.get(0).address == '香川県'}">selected</c:if>>香川県</option>
					<option value ="愛媛県"<c:if test="${cardFollowList.get(0).address == '愛媛県'}">selected</c:if>>愛媛県</option>
					<option value ="高知県"<c:if test="${cardFollowList.get(0).address == '高知県'}">selected</c:if>>高知県</option>
					<option value ="福岡県"<c:if test="${cardFollowList.get(0).address == '福岡県'}">selected</c:if>>福岡県</option>
					<option value ="佐賀県"<c:if test="${cardFollowList.get(0).address == '佐賀県'}">selected</c:if>>佐賀県</option>
					<option value ="長崎県"<c:if test="${cardFollowList.get(0).address == '長崎県'}">selected</c:if>>長崎県</option>
					<option value ="熊本県"<c:if test="${cardFollowList.get(0).address == '熊本県'}">selected</c:if>>熊本県</option>
					<option value ="大分県"<c:if test="${cardFollowList.get(0).address == '大分県'}">selected</c:if>>大分県</option>
					<option value ="宮崎県"<c:if test="${cardFollowList.get(0).address == '宮崎県'}">selected</c:if>>宮崎県</option>
					<option value ="鹿児島県"<c:if test="${cardFollowList.get(0).address == '鹿児島県'}">selected</c:if>>鹿児島県</option>
					<option value ="沖縄県"<c:if test="${cardFollowList.get(0).address == '沖縄県'}">selected</c:if>>沖縄県</option>
					</select>
					</td>
					</tr>


				<!-- フリースペース -->

					<tr><td>一言コメント :</td>
					<td><input type="text" name="comment" value="${e.freespace}"></td>
					</tr>

				</c:forEach>
				</table>
				<br>
				<br>

											<!-- 更新する -->
				<div  class="back"><input type="submit" name="SUBMIT" value="更新する"></div>

				<br>
											<!--戻るボタン--->

				<div  class="back"><input class ="exit" type = "button" onclick ="history.back()" value="戻る"></div>


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