<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이징 처리</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> <!-- bootstrap -->
<link rel="stylesheet" href="./css/paging.css" > <!-- 사용자 Css -->
<script type="text/javascript" src="./js/paging.js"></script> <!-- 사용자 js -->
</head>
<body>
${lists}
${paging}

<hr>

<div class="container">
	<div id="select">
		<span>
			<select class="btn btn-primary" id="listCount" name="listCount"
				onchange="listCnt()">
				<option>-선택-</option>
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
			</select>
		</span>
	</div>
	
	<form action="./paging.do" method="post" id="frmPaging">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${lists}">
					<tr>
						<td>${dto.title}</td>
						<td>${dto.regdate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<!-- paging 처리 관련 값 -->
		<input type="hidden" id="index" name="index" value="${paging.index}">
		<input type="hidden" id="pageStartNum" name="pageStartNum" value="${paging.pageStartNum}">
		<input type="hidden" id="listCnt" name="listCnt" value="${paging.listCnt}">
		
		<div class="center">
			<ul class="pagination">
				<li><a href="#" onclick="pageFirst()">&laquo;</a></li>
				<li><a href="#" onclick="pagePre(${paging.pageStartNum},${paging.pageCnt})">&lsaquo;</a></li>
				
				<!-- 페이지 번호 -->
				<c:forEach var="i" begin="${paging.pageStartNum}" end="${paging.pageLastNum}" step="1">
					<li><a onclick="pageIndex(${i})">${i}</a></li>
				</c:forEach>
				
				<li><a href="#" onclick="pageNext(${paging.pageStartNum},${paging.total},${paging.listCnt},${paging.pageCnt})">&rsaquo;</a></li>
				<li><a href="#" onclick="pageLast(${paging.pageStartNum},${paging.total},${paging.listCnt},${paging.pageCnt})">&raquo;</a></li>
			</ul>
		</div>
	</form>



<hr>
<div><a href="./revoce.do">모두삭제</a></div>
<div><a href="./list.do?num=100">리스트 100개 추가</a></div>
</div>
</body>
</html>