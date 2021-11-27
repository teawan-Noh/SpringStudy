<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="./js/insertBoard.js"></script>
<title>Insert title here</title>
</head>
<body>
<div id="changeTextArea">

</div>
	<div class="container">
		<h2>새글입력</h2>
		<form class="form-horizontal" action="./insertBoard.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">아이디:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요" name="id" value="${sessionScope.userid}">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">title:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" placeholder="제목을 입력해주세요" name="title">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="content">content:</label>
				<div class="col-sm-10">
				<textarea class="form-control" rows="10" id="content" name="content"></textarea>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-primary btn-block" onclick="validateForm()">새글입력</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>