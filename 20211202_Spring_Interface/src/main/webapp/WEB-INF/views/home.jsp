<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1> ${envText}
	<P>The time on the server is ${serverTime}.</P>
	<form action="./home.do" method="post">
		<input type="submit" value="home이동">
	</form>
	<hr>
	<fieldset>
		<legend>처리 방식에 따른 Controller 연습</legend>
		<ul>
			<li>
				getHome.do GET 호출방식 <a href="./getHome.do?name=devleoper">getHome호출</a>
			</li>
			<li>getHome.do POST 호출방식
				<form action="./getHome.do" method="post">
					<input type="text" name="title" value="come back home"> <inputtype="submit" value="Post 전송">
				</form>
			</li>
		</ul>
	</fieldset>
	<hr>
	<h3>전달 값</h3>
	model : ${requestScope.str}
	<br> model : ${sessionScope.str}
	<br> request : ${req_str}

	<fieldset>
		<legend>게시글 전체보기</legend>
		<a href="./selectBoard.do">글 보기</a>
	</fieldset>
	<hr>

	<fieldset>
		<legend>Spring Education Book</legend>
		<p>Spring Book은 com.min.edu.bookctrl에서 작동</p>
		<b><a href="./book/home.do?lang=ko">Spring Book</a></b>
	</fieldset>
</body>
</html>
