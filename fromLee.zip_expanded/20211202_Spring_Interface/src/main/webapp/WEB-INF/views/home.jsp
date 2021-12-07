<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="./home.do" method="post">
	<input type="submit" value="home 이동">
</form>

<hr>
<fieldset>
	<legend>처리 방식에 따른 Controller 연습</legend>
	<ul>
		<li>
			getHome.do GET 호출방식<br>
			<a href="./getHome.do?name=developer">getHome 호출</a>
			
		</li>
		<li>
			getHome.do POST 호출방식
			<form action="./getHome.do" method="post">
				<input type="text" name="title" value="come back home">
				<input type="submit" value="POST 전송">
			</form>
		</li>
	</ul>
</fieldset>
<hr>
<h3>전달값</h3>
model : ${sessionScope.str} <br>
request : ${req_str}
<fieldset>
	<legend>게시글 전체보기</legend>
	<a href="./selectBoard.do">글 보기</a>
</fieldset>
</body>
</html>







