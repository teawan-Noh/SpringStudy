<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
전체조회 결과
${lists}<br>
단일조회 결과
${requestScope.vo}<br>
수정결과 출력 <textarea rows="5" cols="40">${mvo.content}</textarea><br>
${mvo.content}
</body>
</html>