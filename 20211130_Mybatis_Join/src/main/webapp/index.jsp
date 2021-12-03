<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>축구선수와 팀 조인 값</title>
</head>
<body>
<button onclick="location.href='./joinController.do'">결과 확인</button>
<hr>
총 갯수: ${fn:length(lists)}<br>
<%-- <c:forEach var="alldto" items="${lists}">
	${alldto}<br>
</c:forEach> --%>
<fieldset>
	<legend>All_Dto 방식에서 값찾기</legend>
	<div>
		<c:set var="player3" value="${lists[3]}"/>
		3번째 사람 : ${player3.player_name}, ${player3.team_name}
	</div>
</fieldset>

<fieldset>
	<legend>각 DTO 생성 및 TEAM_DTO에 멤버필드로 조인 </legend>
	<%-- ${listsT} --%>
	<div>
		<c:set var="player3" value="${listsT[3]}"/>
		3번째 사람 : ${player3.pdto.player_name}, ${player3.team_name}
	</div>
</fieldset>


<fieldset>
	<legend>각 DTO 생성 후 Mapper &lt;collection&gt;을 사용하여 연결 team -> player</legend>
	<div>총개수: ${fn:length(listsC)}</div>
<%-- 	${listsC} --%>
</fieldset>

<fieldset>
	<legend>각 DTO 생성 후 Mapper &lt;collection&gt;을 사용하여 연결 player -> team</legend>
	<div>총개수: ${fn:length(listsCC)}</div>
	<%-- <c:forEach var="p" items="${listsCC}">
		${p.player_name} ${p.tdo.team_name}
	</c:forEach> --%>
</fieldset>

<fieldset>
	<legend>각 DTO 생성 후 Mapper &lt;collection&gt;을 사용하여 연결 player -> team</legend>
	<div>총개수: ${fn:length(listsCL)}</div>
	<div>
		<c:set var="w" value="${listsCL[0]}"/>
		팀이름 : ${w.team_name} / ${fn:length(w.pdto)}<br>
		팀지역 : ${w.region_name}<br>
		주&nbsp;&nbsp;소 : ${w.address}<br>
		<p>
			<c:forEach var="players" items="${w.pdto}">
				${players}<br>
			</c:forEach>
		</p>
	</div>
</fieldset>

</body>
</html>