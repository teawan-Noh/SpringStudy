<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<button>화면 넘기기</button>
</body>

<script type="text/javascript">
	var click = document.getElementsByTagName("button")[0];
	
	click.onclick = function(){
		location.href="./home.do?name=happy";
		
	}

</script>
</html>