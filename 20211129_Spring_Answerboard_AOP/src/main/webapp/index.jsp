<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<h2>첫화면</h2>
<div>
	입력되어 있는 세션 정보 :${lvo}
</div>
<fieldset>
	<legend>답변형게시판</legend>
	<button onclick="location.href='./boardList.do'">전체글 보기</button>
	<button onclick="location.href='./loginForm.do'">로그인</button>
</fieldset>

</body>
<script type="text/javascript">

	var init = document.getElementsByTagName("h2")[0];
	init.onclick = function(){
		location.href="./init.do?name=happy";
	}

</script>
</html>