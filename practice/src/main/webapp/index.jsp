<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>첫페이지</h2>
</body>

<script type="text/javascript">
	var init = document.getElementsByTagName("h2")[0];
	init.onclick = function() {
		location.href = "./init.do?name=happy";
	}
</script>
</html>