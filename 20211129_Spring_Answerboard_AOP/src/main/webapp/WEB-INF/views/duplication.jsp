<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript">
	$(document).ready(function(){
		$("#btnUseId").css('display','none')
	});
	
	function checkId(){
		var doc = document.getElementById("id").value;
		console.log(doc);
		if(doc !=""){
			$.ajax({
				url:'./duplicationAjax.do',
				type:'post',
				data:'checkId='+doc,
				async:true,
				//dataType: json, // 비동기식 처리를 한 후 서버에서 반환되는 값
				success: function(msg){
					console.log(msg);
					if(msg == 'false'){
						document.getElementById('idCondition').innerHTML = "사용가능한 아이디 입니다.";
						document.getElementById('btnUseId').style.display = 'block';
					}else{
						document.getElementById('idCondition').innerHTML = "사용할 수 없는 아이디 입니다.";
						document.getElementById('btnUseId').style.display = 'none';
						
					}
				},
				error:function(){
					alert("잘못된 요청입니다");
				}
			})
		}else{
			document.getElementById('idCondition').innerHTML = "사용할 수 없는 아이디 입니다.";
			document.getElementById('btnUseId').style.display = 'none';
		}
	}
	
	function useId(){
		var id = document.getElementById('id');
		opener.document.getElementById('id').value = id.value;
		opener.document.getElementById('name').focus();
		window.close();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h4>아이디 중복검사</h4>
		<h4>ID를 입력해주세요</h4>
		<input type="text" id="id" class="form-control">
		<input type="button" class="btn btn-success" value="확인" onclick="checkId()">
		<input type="button" class="btn btn-warning" value="사용하기" id="btnUseId" onclick="useId()">
	</div>
	<div id="idCondition"></div>
</body>
</html>