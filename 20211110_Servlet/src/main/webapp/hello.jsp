<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><marquee>안녕하세요 반갑습니다</marquee></h1>
<button onclick="hello()">HelloServlet 호출</button>
<script type="text/javascript">
	function hello(){
		location.href="./hello.do?address=서울시금천구"
	}
</script>
</body>
</html>