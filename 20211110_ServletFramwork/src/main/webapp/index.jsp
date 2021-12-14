<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 화면 입니다</title>
</head>
<body>

<input type="button" value="Hello" onclick="location.href='./app/Hello?name=funny'">
<form action="./app/List">
	<input type="submit" value="list실행">
</form>
</body>
</html>