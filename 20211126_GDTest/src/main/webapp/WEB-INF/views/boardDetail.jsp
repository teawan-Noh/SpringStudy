<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container" class="table-response">
		<h3>상세글 조회</h3>
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>${boardOne.id}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${boardOne.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="50">${boardOne.content}</textarea></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td>${boardOne.regdate}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>