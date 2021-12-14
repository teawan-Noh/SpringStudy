<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일업로드 화면</title>
</head>
<body>

<!-- 
	form tag의 enctype 속성
	1. application/x-www-form-urlencoded : (default값) 문자 Encoding
	2. multipart/form-data : file upload (post)
	3. text/plain : encoding 하지 않음
 -->
<form:form action="./upload.do" method="post" enctype="multipart/form-data" modelAttribute="uploadFile">
	<h3>업로드할 파일</h3>
	파일: <input type="file" name="file"><br>
	<p style="color: red; font-weight: bod;">
		<form:errors path="file"/>
	</p><br>
	설명:<br>
	<textarea rows="10" cols="40" name="desc"></textarea>
	<input type="submit" value="전송">
</form:form>
</body>
</html>