<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/boardList.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>게시글 목록</title>
</head>
<body>
	<div class="container">
		<c:set var="length" value="${fn:length(list)}"/>
		<table class="table table-striped">
			<thead>
				<tr>
					<th><input id="allChk" type="checkbox"
						onclick="allChks(this.checked)" /></th>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>REFER</th>
					<th>STEP</th>
					<th>DEPTH</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${requestScope.list}" var="list" varStatus="vs">
					<c:if test="${list.delflag eq 'N'}">
						<tr>
							<td><input type="checkbox" name="chk"/></td>
							<td>${length - vs.index}</td>
							<td>${list.id}</td>
							<td>
								<a href='./boardDetail.do?seq=${list.seq}'>${list.title}</a>
							</td>
							<td>${list.refer}</td>
							<td>${list.step}</td>
							<td>${list.depth}</td>
							<td>${list.regdate}</td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>