<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 시작 페이지</title>
</head>
<body>
	<!-- //입력 insertBoard
	public int insertBoard(BoardVo vo); -->
	<fieldset>
		<legend>입력 insertBoard</legend>
		<div>
			<form action="./insertBoard.do" method="post">
				<input type="text" name="title">
				<input type="text" name="content">
				<input type="submit" value="전송">
			</form>
		</div>
	</fieldset>
	<hr>
	<!-- //전체조회 selectAllBoard
	public List<BoardVo> selectAllBoard(); -->
	<fieldset>
		<legend>전체조회 selectAllBoard</legend>
		<div>
			<button onclick="location.href='./selectBoard.do'">전체조회 버튼</button>
		</div>
	</fieldset>
	<hr>
	<!-- //단일조회 selectOneBoard
	public BoardVo selectOneBoard(String seq); -->
	<fieldset>
		<legend>단일조회 selectOneBoard</legend>
		<div>
			<form action="./selectBoard.do" method="post">
				<input type="text" name="seq">
				<input type="submit" value="전송">
			</form>
		</div>
	</fieldset>
	<hr>
	<!-- //수정 modifyBoard
	public int modifyBoard(Map<String, Object> map); -->
	<fieldset>
		<legend>수정 modifyBoard</legend>
		<div>
			<form action="./modifyBoard.do?seq=1" method="post">
				<textarea rows="5" cols="50" name="content"></textarea>
				<input type="submit" value="수정 content">
			</form>
		</div>
	</fieldset>
	
	<!-- //삭제 deleteBoard
	public int deleteBoard(int seq); -->
	<fieldset>
		<legend>삭제 deleteBoard</legend>
		<div>
			<button onclick="location.href='./deleteBoard.do?seq=23'">진짜삭제</button>
		</div>
	</fieldset>
	
</body>
</html>