<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>상세글보기</title>
<style type="text/css">
#container {
	width: 800px;
	height: 500px;
	margin: 20px auto;
}
</style>
</head>
<body>
	<div id="container" class="table-response">
		<h3>상세글 조회</h3>
		<table class="table">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>${avo.id}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${avo.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="10" cols="50">${avo.content}</textarea></td>
				</tr>
				<tr>
					<th>등록일</th>
					<td><fmt:parseDate var="wDate" value="${avo.regdate}"
							pattern="yyyy-MM-dd" /> <fmt:formatDate value="${wDate}"
							pattern="yyyy년 MM월 dd일" /></td>
				</tr>
			</tbody>
		</table>
		<form action="#" method="post" name="frm">
			<input type="hidden" id="seq" name="seq">
			<div style="text-align: center;">
				<c:if test="${sessionScope.userid eq avo.id}">
					<input class="btn-success" type="button" value="글삭제"
						onclick="location.href='./deleteBoard.do?seq=${avo.seq}'">
					<input class="btn-info" type="button" value="글수정" onclick="location.href='./modifyBoardForm.do?seq=${avo.seq}'">
				</c:if>
				<%-- <input type="button" value="답글작성" onclick="location.href='./replyBoardForm.do?seq=${avo.seq}'"> --%>
				<button type="button" class="btn btn-default" data-toggle="modal"
					data-target="#reply">Open Modal</button>
				<input type="button" value="전체글목록" onclick="history.back(-1)">
			</div>
		</form>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="reply" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">답글 작성</h4>
				</div>
				<form action="" method="post" id="frmReply" class="form-margin">
					<div class="modal-body">
						<div class="form-group">
							<label>작성자</label>
							<p>${sessionScope.userid}</p>
						</div>
						<div class="form-group">
							<label>제목</label> <input type="text" class="form-control" id="title" name="title">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea rows="5" class="form-control" id="content" name="content"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<input type="hidden" name="seq" value="${avo.seq}">
						<input type="button" class="btn btn-success" value="답글작성" onclick="replyValue()">
						<input type="reset" class="btn btn-success" value="초기화">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</form>
			</div>

		</div>
	</div>


	<!-- post로 req보내는 방법 -->
	<script type="text/javascript">
	
	function replyValue(){
		console.log('답글 submit');
		var frm = document.getElementById('frmReply');
		frm.action = './replyBoard.do';
		frm.submit();
	}
	
	
	
	
	
		/* window.onload = function() {
			const btns = document.querySelectorAll('input[type=button]');
			const seq = ${avo.seq};
			console.log(btns.length, seq);
			for(let b in btns){
				btns[b].onclick = function(){
					switch(this.value){
					case '글삭제':	formProcess('./deleteBoard.do', seq);		break;
					case '글수정':	formProcess('./modifyBoardForm.do', seq);		break;
					case '답글작성': 	formProcess('./replyBoardForm.do', seq);		break;
					}
				}
			}
		} */

		function formProcess(req, seq) {
			console.log(req);
			document.getElementById('seq').value = seq;
			const frm = document.frm;
			frm.action = req;
			frm.submit();
		}
	</script>
</body>
</html>