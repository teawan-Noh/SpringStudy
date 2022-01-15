<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 후 첫화면</title>
<%@ include file="./boardTopMenu.jsp" %>
</head>
<body>
	<div class="container" id="container">
		<form action="./multiDel.do" method="post" id="frm" onsubmit="return chkbox()">
			<div id="select">
				<span>
					<select class="btn btn-primary" id="list" name="list" onchange="pageList()">
<%-- 						<option value="5" ${row.listNum == 5 ? "selected" : "" } >5</option> --%>
<%-- 						<option value="10" ${row.listNum == 10 ? "selected" : "" }>10</option> --%>
<%-- 						<option value="15" ${row.listNum == 15 ? "selected" : "" }>15</option> --%>
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="15">15</option>
					</select>
				</span>
			</div>
			
			
			<table class="table table-border">
				<thead>
					<tr>
						<c:if test="${mem.auth eq 'A' }">
							<th><input type="checkbox" id="checkAll" onclick="checkAllFn(this.checked)"> </th>
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
					<jsp:useBean id="format" class="com.min.edu.bean.InputList" scope="page"/>
					<jsp:setProperty property="lists" name="format" value="${lists}"/>
					<jsp:setProperty property="mem" name="format" value="${mem}"/>
					<jsp:getProperty property="listForm" name="format"/>
				</tbody>
			</table>
				
			<input type="hidden" name="index" id="index" value="${row.index}">
			<input type="hidden" name="pageNum" id="pageNum" value="${row.pageNum}">
			<input type="hidden" name="listNum" id="listNum" value="${row.listNum}">
			
			<div style="text-align: center;">
				<ul class="pagination pagination-lg">
				  <li><a href="#" onclick="pageFirst()"><span class="glyphicon glyphicon-fast-backward"></span> </a></li>
				  <li><a href="#" onclick="pagePrev(${row.pageNum},${row.pageList})"><span class="glyphicon glyphicon-step-backward"></span></a></li>
				  
				  <c:forEach var="i" begin="${row.pageNum}" end="${row.count}" step="1" >
					  <li><a href="#" onclick="pageIndex('${i}')">${i}</a></li>
				  </c:forEach>
				  
				  <li><a href="#" onclick="pageNext(${row.pageNum},${row.total},${row.listNum},${row.pageList})"><span class="glyphicon glyphicon-step-forward"></span> </a></li>
				  <li><a href="#" onclick="pageLast(${row.pageNum},${row.total},${row.listNum},${row.pageList})"><span class="glyphicon glyphicon-fast-forward"></span> </a></li>
				</ul>
			</div>
			
			<c:if test="${mem.auth eq 'A'}">
				<div>
					<input type="submit" class="btn btn-danger" value="다중삭제">
				</div>
			</c:if>
		</form>	
		
		
			<!-- Modal 영역	-->
			
			<!-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#write">새글</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modify">수정</button>
			<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#reply">답글</button> -->
			
			<!-- Modal 새글쓰기-->
			<div id="write" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">게시글 입력</h4>
			      </div>
			      <div class="modal-body">
			       	<form class="form-margin" method="post" id="frmWrite">
			       	</form>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Modal 글수정하기-->
			<div id="modify" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">게시글 수정</h4>
			      </div>
			      <div class="modal-body">
			     	<form class="form-margin" method="post" id="frmModify"></form>
			      </div>
			    </div>
			  </div>
			</div>
			
			<!-- Modal 답글-->
			<div id="reply" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">답글 작성</h4>
			      </div>
			      <div class="modal-body">
			        <form class="form-margin" method="post" id="frmReply">
			        	
					    
			        </form>
			      </div>
			    </div>
			  </div>
			</div>
		
	</div>
</body>
</html>






