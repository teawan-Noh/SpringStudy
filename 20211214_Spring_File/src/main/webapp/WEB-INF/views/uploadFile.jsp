<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일다운로드</title>
</head>
<body>
	경로 : ${path} <br>
	파일명 : ${fileObj.filename}<br>
	설명 : ${fileObj.desc}<br>
	<form action="./download.do" method="post">
		<input type="hidden" name="filename" value="${fileObj.filename}">
		<input type="submit" value="다운로드">
	</form>
	
	<img src="./storage/${fileObj.filename}"/>
</body>
</html>