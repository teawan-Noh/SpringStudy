<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>책검색 단어 : ${searchWord}</h3>

<c:forEach var="book" items="${kakaoBook.documents}">
	제목 : ${book.title} <br>
	저자 : ${book.authors} <br>
	내용 : ${book.contents} <br>
	이미지 : <img src="${book.thumbnail}">
</c:forEach>
</body>
</html>