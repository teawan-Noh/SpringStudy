<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 작성 화면</title>
</head>
<body>
	<!-- 메일 작성하는 상황 1)text글로 2) html로 작성된 3) 첨부파일이 있는 글 -->
	<h2>메일보내기</h2>
	<div id="container">
		<form action="./mailSender.do" method="post">
			<div align="center">
				<input type="text" name="tomail" placeholder="상대방 메일">
			</div>
			<div align="center">
				<input type="text" name="title" placeholder="메일제목">
			</div>
			<div align="center">
				<textarea rows="20" cols="30" name="content" placeholder="메일내용"></textarea>
			</div>
			<div align="center">
				<input type="submit" value="메일보내기">
			</div>
		</form>
	</div>
</body>
</html>