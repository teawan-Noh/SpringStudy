<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>List 호출 화면</title>
</head>
<body>
	<%--  전달 리스트 ${season} --%>
	<div class="container">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>연번</th>
					<th>job_id</th>
					<th>job_title</th>
					<th>min_salary</th>
					<th>max_salary</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${lists}" varStatus="vs">
					<tr>
						<td>${vs.count}</td>
						<td><a href="detail?job_id=${dto.job_id}">${dto.job_id}</a></td>
						<td>${dto.job_title}</td>
						<td>${dto.min_salary}</td>
						<td>${dto.max_salary}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>