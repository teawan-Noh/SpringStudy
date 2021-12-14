<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>회원가입 입력 폼2</title>
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
		<h2>회원가입 폼2</h2>
		<!-- 
			commandName 필수 @ModelAtrribute에 value값 
			Controller에서 전달 객체 scope request 미리 객체를 선언해서 받아놓고 시작
		-->
		
		<form:form modelAttribute="memvervo" class="form-horizontal" action="./regist2.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">아이디:</label>
				<div class="col-sm-10">
					<form:input path="id" type="text" class="form-control" id="id" placeholder="Enter id" name="id" readonly="readonly"/>
					<form:errors path="id"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">성명:</label>
				<div class="col-sm-10">
					<form:input path="name" type="text" class="form-control" id="name" placeholder="Enter name" name="name"/>
					<form:errors path="name"/>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="pwd">비밀번호:</label>
				<div class="col-sm-10">
					<form:input path="pw" type="password" class="form-control" id="pwd" placeholder="Enter password" name="pw"/>
					<form:errors path="pw"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>