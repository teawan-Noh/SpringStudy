<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/login.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<script type="text/javascript" src="./js/login.js"></script>

</head>
<body>
<div>
	사용자 : USER03/1234<br>
	관리자 : USER04/1234<br>
</div>
	<div id="container">
		<div id="title">Total Board</div>
	
		<form method="post">
		
			<div class="inputWord">아 이 디</div>
			<input type="text" name="id" id="inputId" placeholder="아이디 입력" value="USER03">
			
			<div class="inputWord">비밀번호</div>
			<input type="password" name="pw" id="inputPw" placeholder="비밀번호 입력" value="1234" onkeyup="enterKey()">
				
			<div style="text-align: center">
				<input type="button" id="login" name="login" value="LOGIN" onclick="loginCheck()">
			</div>
		
			<div id="bottom" >
				<input type="button" id="signUp" value="회원가입">
				<input type="button" value="아이디 찾기">
				<input type="button" value="비밀번호 찾기">
			</div>
		
		
		</form>
	</div>
</body>
</html>