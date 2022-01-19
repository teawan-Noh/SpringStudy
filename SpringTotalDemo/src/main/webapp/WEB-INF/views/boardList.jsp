<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<title>게시판</title>
</head>
<body>
	<div class="container">
		<h2>Basic Table</h2>
		<table class="table">
			<thead>
				<tr>
					<c:if test="${mem.auth eq 'A' }">
						<th><input type="checkbox" id="checkAll"
							onclick="checkAllFn(this.checked)"></th>
					</c:if>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
					<c:if test="${mem.auth eq 'A' }">
						<th>삭제여부</th>
					</c:if>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${boardList}">
				<tr>
					<td>${board.seq}</td>
					<td>${board.title}</td>
					<td>${board.id}</td>
					<td>${board.readcount}</td>
					<td>${board.regdate}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>