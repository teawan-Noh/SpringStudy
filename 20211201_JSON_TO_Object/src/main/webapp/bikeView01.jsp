<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>화면에서 DB로</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript" src="./js/bike01.js" ></script>
</head>
<body>
	<form action="./bikeController.do" method="post">
		<input type="hidden" name="command" value="first_db">
		<input type="submit" value="DB에 저장하기">
		<table>
			<thead></thead>
			<tbody></tbody>
		</table>
	</form>
	



</body>
</html>