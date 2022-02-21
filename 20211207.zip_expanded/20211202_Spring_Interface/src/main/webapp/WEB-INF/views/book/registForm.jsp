<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>회원가입 입력 폼</title>
</head>

<script type="text/javascript">
	function duplication(){
		var url = "./duplication.do";
		var title = "중복확인";
		var attr = "width=300px, height=500px";
		window.open(url, title, attr);
	}
</script>
<body>
	<div class="container">
		<h2>회원가입 폼</h2>
		<form class="form-horizontal" action="./regist.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">아이디:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" placeholder="Enter id" name="id" readonly>
					<input type="button" class="btn btn-success" value="중복확인" onclick="duplication()">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">성명:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" placeholder="Enter name" name="name">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">비밀번호:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pw">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>