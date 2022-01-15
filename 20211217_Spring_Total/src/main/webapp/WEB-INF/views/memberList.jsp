<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="./boardTopMenu.jsp" %>
</head>
<body>
<div id="container" class="container">
	<table class="table table-border">
		<thead>
			<tr class="warning">
				<th>연번</th>
				<th>아이디</th>
				<th>이름</th>
				<th>삭제여부</th>
				<th>권한</th>
				<th>등록일</th>
				<th>회원변경</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="user" items="${mList}" varStatus="vs" >
				<tr><td>${vs.count}</td><td>${user.id}</td><td>${user.name}</td><td>${user.delflag}</td>
				<td>${user.auth =="U"?"사용자":"관리자"}</td>
				<td>${user.regdate}</td>
				<td><button class="btn btn-default">${(user.delflag == "Y")?"복구":"탈퇴"}</button> </td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<input type="button" class="btn btn-warning btn-block btn-lg" value="돌아가기" onclick="history.back(-1)">
	</div>
</div>
<script type="text/javascript">
	window.onload = function(){
		var buttons = document.getElementsByTagName("button");
		console.log(buttons.length);
		for (var i = 0; i < buttons.length; i++) {
			buttons[i].onclick = function(){
				console.log(this.innerHTML);
				console.log(this.parentNode.parentNode.childNodes[1].innerHTML);
				console.log(this.parentNode.parentNode.childNodes[3].innerHTML);
				this.parentNode.parentNode.childNodes[3].innerHTML = (this.parentNode.parentNode.childNodes[3].innerHTML =="Y"?"N":"Y")
				this.innerHTML = (this.innerHTML == "복구")?"탈퇴":"복구";
			}
		}
	}

</script>


</body>
</html>