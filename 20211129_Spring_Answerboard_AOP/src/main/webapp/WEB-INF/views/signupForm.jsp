<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript">
	function duplication(){
		console.log("작동");
		//open(url, title, 속성)
		var url = './duplication.do';
		var title = '아이디 중복검사';
		var attr = 'width=450px, height=550px';
		window.open(url, title, attr);
	}
</script>
</head>
<body>
	<div class="container">
		<form action="./signup.do" method="post">
			<h2>&lt;회원가입&gt;</h2>
			<h3>필수 정보를 입력해주세요</h3>
			<div>
				<input class="form-control" type="text" id="name" name="name" placeholder="성명을 작성하세요">
				<input class="form-control" type="text" id="id" name="id" placeholder="아이디(클릭시 중복체크)" maxlength="10" onclick="return duplication()">
				<span id="result"></span>
				<input class="form-control" type="text" id="pw" name="pw" placeholder="비밀번호">
				<input class="form-control" type="text" id="passOk" placeholder="비밀번호 확인">
			</div>
			<hr>
			<div>
				<input type="submit" value="회원가입">
				<input type="button" value="가입취소" onclick="history.back(-1)">
			</div>
		</form>
	</div>
</body>
</html>