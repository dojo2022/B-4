<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>今日はどっち派？</title>
<link rel="stylesheet" href="/dotchiha/css/common.css">
<!-- 自分のスタイルシート -->
<link rel="stylesheet" href="/dotchiha/css/board.css">
</head>
<body>
<div class ="wrapper">
  <!--  ヘッダーここから  -->
  <header class="header">
    <h1 id="logo" >
      <a href="/dotchiha/CorDBrowsServlet"><img src="/dotchiha/img/title_logo.png" width="300" height="" alt="今日はどっち派？"></a>
    </h1>
  </header>
  <!--  ヘッダーここまで  -->
  <!--メインここから-->
  <main>
    <h1 class = "title">新規掲示板</h1>
    <br>
    <br>
    <form method="POST" action="/dotchiha/BoardPostServlet">
    <!-- 投稿内容 -->
      <table>
      <!-- タイトル -->
        <tr>
          <td><p>タイトル</p></td>
        </tr>
        <tr>
          <td><input type="text" name="title"></td>
        </tr>
        <!-- 内容 -->
        <tr>
          <td><p>投稿内容</p></td>
        </tr>
        <tr>
          <td><input type="text" name="text"></td>
        </tr>
        <!-- 犬猫選択ボタン -->
        <tr>
          <td colspan="2">
            <input type="checkbox" name="cat" value="1"><label>猫</label>
            <input type="checkbox" name="dog" value="1"><label>犬</label>
          </td>
        </tr>
	      <!-- 投稿ボタン -->
	      <tr>
		      <td colspan="2">
		      <input type="submit"  onclick="return confirm('下記の内容で登録します。よろしいですか？')" class="button" name="POST" value="投稿">
		      <input type="reset" name="reset" value="リセット">
		      </td>
	      </tr>
      </table>
    </form>
    <br>
    <br>

    <!--戻るボタン--->
    <button class ="exit" type = "button" onclick ="history.back()">やめる</button>

  </main>

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
<script src ="/dotchiha/js/common.js"></script>
</body>
</html>