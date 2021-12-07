<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${lists[0]}
	<hr>
	<fieldset>
		<legend>기본Parameter</legend>
		<form action="./insertBoard.do" method="post">
			<input type="text" name="id" value="GD1206">
			<input type="text" name="title" value="비대면교육">
			<input type="text" name="content" value="오늘도 최선을 다해">
			<input type="submit" value="전송">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>기본Parameter</legend>
		<form action="./insertBoardMap.do" method="post">
			<input type="text" name="id" value="GD1206">
			<input type="text" name="title" value="월요일">
			<input type="text" name="content" value="월요일 따뜻함">
			<input type="submit" value="전송">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>@RequestParam</legend>
		<p>
			화면에서 요청되는 name값을 변경하여 처리 가능<br>
			화면에서는 pw 넘겨줌. 하지만 WAS에서는 password로 처리한다면 <br>
			String password = request.getParameter(pw); 이런식으로 jsp에서는 사용했었음<br>
		</p>
		<p>
			화면에서 content와 같이 어떤 특정한 값이 NN이 허용된다면 default로 처리했음<br>
			값이 null이라면 값을 변경하여 입력
		</p>
		<form action="./insertRequestParam.do" method="post">
			<input type="text" name="a" value="GD1205">
			<input type="text" name="b" value="날씨가 좋아지고 있어요">
			<input type="text" name="c" value="예보는 눈이 온다고 했습니다">
			<input type="text" name="page">
			<input type="submit" value="전송">
		</form>
	</fieldset>
	
	<fieldset>
		<legend>주소값을 처리하는 방식</legend>
		<ol>
			<li>
				@Controller와 하위의 @GetMapping등을 사용할 시<br>
				@Controller @RequestMapping(value="/user/")선언을 하면 @Controller의 하위의 <br>
				메소드의 매핑은 모두 /user/로 요청된 처리만을 담당한다.<br>
				<pre>
					http://localhost:8096/test/user/login.do
					
					@Controller()
					@RequestMapping(value="/user")
					public Class A{
					
						@GetMapping(value="/login.do")
						public String test(){
							
						}
					}
					
				</pre>
			</li>
			<li>
				Parameter에서 전달받은 값을 화면의 요청 주소에서 추출
				<form action="./com/min/edu/PramePath.do" method="get">
					<input type="text" name="val" value="화면에서 param으로 전송">
					<input type="submit" value="주소처리">
				</form>
			</li>
		</ol>
	</fieldset>
	<fieldset>
		<legend>Transaction 처리</legend>
		<p>
			Spring에서 Transaction 처리는 <br>
			TransactionManager &lt;bean&gt; 이 처리해줌.<br>
			&lt;tx:annotation-drive&gt;에 의해서 사용하는 annotation <br>
			aop 설정을 통한 rollback 상황시 동작되도록 함.
		</p>
		<p>
			OCP구조에 의해서 개발이 진행<br>
			&lt;MVC:annotation-driven&gt; 에 의해서 MVC가 동작됨<br>
			IoC에 의해서 Spring Container가 제어를 역전하여 실행시킴<br>
			
			@Service는 Dao를 조합하여 처리함
			@Service에서 조합되어 있는 메소드를 @Transactional을 처리하여 Commit 혹은 Rollback이 될수 있도록 처리
			
		</p>
		<form action="./transactionTest.do" method="post">
			<input type="text" name="id" value="DG1204">
			<input type="text" name="title" value="Transaction 테스트">
			<input type="text" name="content" value="Spring 구조상 IoC에 의해서 Transaction을 처리해야 함">
			<input type="submit" value="전송">
		</form>
	</fieldset>
</body>
</html>







