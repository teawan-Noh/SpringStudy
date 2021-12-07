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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="./js/boardList.js" defer="defer"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>게시글 전체보기</title>
</head>
<body>
	<%@include file="./login.jsp" %>
	<div class="container">
		<form action="./multiDel.do" method="post" name="frm" id="frm" onsubmit="return checkBox()">
			<input class="btn btn-danger" type="submit" value="다중삭제"> 
			<input class="btn btn-success" type="button" value="새글입력" onclick="location.href='./insertBoardForm.do'">
			<c:set var="len" value="${fn:length(lists)}" />
			TOTAL : ${len}
			<table class="table table-striped table-hover" style="margin-top: 20px">
				<thead>
					<tr>
						<th><input id="allChk" type="checkbox" onclick="allChks(this.checked)"></th>
						<th>연변</th>
						<th>작성자</th>
						<th>제목</th>
						<th>REFER</th>
						<th>STEP</th>
						<th>DEPTH</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="obj" items="${requestScope.lists}" varStatus="vs">
					<c:if test="${obj.delflag eq 'N'}">
						<tr>
							<td>
								<input type="checkbox" name="chk" onclick="checkchk()" value="${obj.seq}">
							</td>
							<td>${len - vs.index}</td>
							<td>${obj.id}</td>
							<td>
								<jsp:useBean id="pic" class="com.min.edu.comm.ReplyPhoto"/>
								<jsp:setProperty property="depth" name="pic" value="${obj.depth}"/>
								<jsp:getProperty property="photo" name="pic"/>
								<a href="./detailBoard.do?seq=${obj.seq}">${obj.title}</a>
							</td>
							<td>${obj.refer}</td>
							<td>${obj.step}</td>
							<td>${obj.depth}</td>
							<td>
								<!-- regdate가 String일 경우 처리하는 방법 
									1.SQL문에서 TO_CHAR로 처리해주는게 제일 좋음
								-->
								<fmt:parseDate var="d" value="${obj.regdate}" pattern="yyyy-MM-dd"/>
								<fmt:formatDate value="${d}" pattern="yyyy/MM/dd"/>
							</td>
						</tr>
					</c:if>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>