<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<fieldset>
	<legend>회원가입</legend>
	<div>
		<form action="./join.do" method="post">
			<input type="text" name="name" placeholder="성명을 작성하세요"> <br>
			<input type="text" name="password" placeholder="비밀번호를 작성하세요"> <br>
			<input type="submit" value="SingUp">
		</form>
	</div>
</fieldset>

<fieldset>
	<legend>로그인</legend>
		<div>
		<form action="./login.do" method="post">
			<input type="text" name="name" placeholder="성명을 작성하세요"> <br>
			<input type="text" name="password" placeholder="비밀번호를 작성하세요"> <br>
			<input type="submit" value="SingIn">
		</form>
	</div>
</fieldset>
</body>
</html>
