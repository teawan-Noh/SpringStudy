<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world! ${envText}
</h1>
<P>  The time on the server is ${serverTime}. </P>
<form action="./home.do" method="post">
	<input type="submit" value="home이동">
</form>
<hr>
<fieldset>
	<legend>처리방식에 따른 Controller</legend>
	<ul>
		<li>
			getHome.do GET 호출방식<br>
			<a href="./getHome.do?name=developer">getHome호출</a>
		</li>
		
		<li>
			getHome.do POST 호출방식
			<form action="./getHome.do" method="post">
				<input type="text" name="title" value="I want to go home">
				<input type="submit" value="POST전송">
			</form>
		</li>
	</ul>
</fieldset>
<hr>
<h3>전달값</h3>
model : ${requestScope.str}<br>
request : ${req_str}
<fieldset>
	<legend>게시글 전체보기</legend>
	<a href="./selectBoard.do">글보기</a>
</fieldset>
<hr>
<fieldset>
	<legend>Spring Education Book</legend>
	<p>Spring Book은 com.min.edu.bookctrl에서 작동</p>
	<b><a href="./book/home.do?lang=ko">Spring Book</a></b>
</fieldset>
<hr>
<fieldset>
	<legend>Spring Session과 HttpSession의 범위</legend>
	<ul>
		<li><a href="./sessionCreate.do">Session확인</a></li>
	</ul>
</fieldset>

<hr>
<fieldset>
	<legend>메일 보내기</legend>
	<a href="./mailform.do">메일보내기</a>
</fieldset>

<hr>
<fieldset>
	<legend>카카오 검색</legend>
	<input type="text" id="book_name">
	<button onclick="kakaobook()">카카오 도서검색</button>
</fieldset>

<script type="text/javascript">
	function kakaobook(){
		var book = document.getElementById("book_name").value;
		location.href="./kakao_book.do?searchWord="+book;
	}
</script>
</body>
</html>
