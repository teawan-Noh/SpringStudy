<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript" src="./js/duplication.js"></script>
</head>
<body>
	<div>
		<input type="text" id="id">
		<input type="button" value="확인(Spring3.0)" onclick="checkid('3')" >
		<input type="button" value="확인(Spring4.0)" onclick="checkid('4')" >
	</div>
	<div>
		<input type="button" value="사용하기" id="userid" onclick="useid()"> 
	</div>
	<div id="condition">
	
	</div>

</body>
</html>