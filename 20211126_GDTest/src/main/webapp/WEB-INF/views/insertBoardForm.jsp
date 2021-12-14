<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h2>글쓰기</h2>
		<form class="form-horizontal" action="./insertBoard.do" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="id">아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="id" placeholder="아이디" name="id" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">제목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title" placeholder="제목을 입력하세요" name="title" required>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="content">내용</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="content" placeholder="내용을 입력해주면 좋겠군" name="content" required>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">작성완료</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>