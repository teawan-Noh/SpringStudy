<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<hr>
<select id="lang" onchange="langChange()">
	<option value="en" ${param.lang=="en"?"selected":""}>영어</option>
	<option value="ko" ${param.lang=="ko"?"selected":""}>한국어</option>
</select>
<h1 id="title" align="center">
	-- Spring Framework Workbook <br>
	<spring:message code="label.title" />
</h1>
<hr>
<div class="container">
	<form action="./login.do" method="post">
		<table class="table">
			<tr class="warning">
				<th><spring:message code="label.id" /> </th>
				<td><input type="text" name="id" required="required"></td>
			</tr>
			<tr>
				<th><spring:message code="label.password" /></th>
				<td><input type="password" name="pw" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value='<spring:message code="label.login" />'>
					<input type="button" value="회원가입1" onclick="registForm1()">
					<input type="button" value="회원가입2" onclick="registForm2()">
				</td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
	//checkbox, radio button, select는 checked로 갖고옴.
	//selectedIndex, options
	function langChange() {
		var lang = document.getElementById("lang");
		var choiceValue = lang.options[lang.selectedIndex].value;
		location.href="../book/home.do?lang="+choiceValue;
	}
</script>
</body>
</html>