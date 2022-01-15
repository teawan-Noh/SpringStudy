function check(){
	var name = document.getElementById('name').value;
	var id = document.getElementById('id').value;
	var password = document.getElementById('password').value;
	var passOk = document.getElementById('passOk').value;
	var i_agree2 = document.getElementById('i_agree2').checked;
	var chkval = document.getElementById('chkval').value;
	
	var frm = document.forms[0];
	
	console.log(name, id, password, passOk, i_agree2, chkval, frm);
	
	
	if(password != passOk){
		swal("회원가입 오류", "비밀번호가 잘못되었습니다");
		return false;
	}else if(chkval == "0"){
		swal("회원가입 오류", "아이디를 확인해 주세요");
		return false;
	}else if(i_agree2 == false){
		swal("회원가입 오류", "개인정보 수집 동의(필수) 해주세요");
		return false;
	}else{
		frm.submit();
	}
}


//$(document).ready(function(){});
// window.onload = function(){};
$(function(){
	$("#id").keyup(function(){
		var idVal = $(this).val();
		console.log(idVal);
		
		if(idVal.indexOf(" ") != -1){
			$("#result").css("color","red");
			$("#result").html("공백이 포함된 아이디는 사용할 수 없습니다");
			$("#chkval").val("0");
		}else if(idVal.length <= 5 || idVal.length >= 20){
			$("#result").css("color","red");
			$("#result").html("아이디는 5~20자리 만 입력해주세요");
			$("#chkval").val("0");
		}else{
			$("#result").html("");
			jQuery.ajax({
				type:'post',
				url:'./idCheck.do',
				data:"id="+idVal,
				async:true,
				success: function(msg){
					console.log("전달 받은 값 :",msg);
					
//					console.log(typeof(msg.isc)); //string
//					
//					var obj2 = Boolean(msg.isc); // 익명함수
//					console.log(typeof(obj2)); //boolean
//					
//					var obj3 = new Boolean(msg.isc)//객체화
//					console.log(typeof(obj3)); //Object
//					console.log(obj3); //Object

//					if(msg){
//						console.log("msg 확인");
//					}else{
//						console.log("msg 확인 실패");
//					}

				if(msg.isc == 'true'){
					$("#chkval").val("0");
					$("#result").css("color","red");
					$("#result").html("사용중이 아이디 입니다");
				}else{
					$("#chkval").val("1");
					$("#result").css("color","green");
					$("#result").html("사용가능한 아이디 입니다");
				}
					
					
				},
				error:function(){
					alert("잘못된 요청 입니다");
				}
				
			});
		}
		
	});
})












