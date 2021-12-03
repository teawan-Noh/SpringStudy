//만약에 DOM탐색된 문자가 깨짐이 있거나 혹은 주소로 되어있는 : ? & 등이 포함되어있다면 브라우저가 호출하지 못함
// 값을 encodeURI(특수문자를 제거해서 보냄)/ encodeURIComponent(보여지는 값 묶음으로 보내줌)
function getParameterValue(){
	var name = "name="+$('#name').val();
	var kor = "kor="+$('#kor').val();
	var eng = "eng="+$('#eng').val();
	var math = "math="+$('#math').val();
	console.log(name+"&"+kor+"&"+eng+"&"+math);
	return (name+"&"+kor+"&"+eng+"&"+math);
}

$(function(){
	//Ajax GET방식
	$("#Process").click(function(){
		ajaxLoad();	
	});
	//Ajax POST방식
	$("#Process2").click(function(){
		ajaxLoad2();	
	});
});
/*
	XMLHttpRequest : javascript에서 Object를 통한 HTTP 데이터 송수신을 가능하도록 만들어 주는 객체
	
	state(작동진행) / status(작동 후 상태)
	
	<onreadystatechange> : state 상태 정보를 callback으로 알려주는 상태 function
	- readystate 상태
		0. uninitialized : 실행(load)가 되어있지 않음
		1. loading : 로드진행
		2. loaded : 로드완료
		3. interactive : 통신
		4. complete : 완료
		
	- status code
		200 : 성공
		404 : 페이지가 없음
		403 : forbidden 암호화된 폴더나 접근이 불가능한 것을 접근 시도 했을때
		500 : 서버문제
*/

// XMLHttpRequest 객체를 선언
var httpRequest = null;
//GET
function ajaxLoad(){
	var url = "./StudentCal.do?" + getParameterValue();
	console.log("요청 주소 : ", url);
	
	httpRequest = new XMLHttpRequest(); // 서버와 송수신을 위한 통신 객체 생성
	
	httpRequest.onreadystatechange = callback; // 송수신시 0 -> 4 단계 송수신을 하면서 콜백함수를 생성 및 입력
	httpRequest.open("GET", url, true); // protocol 처리방식, 요청주소, 비동기
	httpRequest.send(); // GET방식으로 url에 비동기식으로 처리하겠다.
}

function callback(){// 0->1->2->3->4
//	alert("httpRequest.readyState : "+httpRequest.readyState);
//	alert("서버에서 처리된 결과 코드 : "+ httpRequest.status);
	if(httpRequest.readyState == 4){
		alert("통신이 완료되었습니다");
		if(httpRequest.status == 200){
			alert("서버와 interactive 성공");
			console.log(httpRequest.responseText);
			
			var obj = JSON.parse(httpRequest.responseText);
//			$("#result").html(obj.name+"총점은?"+obj.sum+"이고 평균은 "+obj.avg);
//			출력값 아래에 추가로 출력해주는법
			var result = document.getElementById("result");
			var p = document.createElement("p");
			var txt = document.createTextNode(obj.name+"총점은?"+obj.sum+"이고 평균은 "+obj.avg);
			p.appendChild(txt);
			result.appendChild(p);
		}else{
			alert("데이터를 수신하지 못했습니다");
		}
	}
}






//POST
function ajaxLoad2(){
	var url = "./StudentCal.do?";
	httpRequest = new XMLHttpRequest(); // 서버와 송수신을 위한 통신 객체 생성
	httpRequest.onreadystatechange = callback2; // 콜백함수
	alert(httpRequest.onreadystatechange);
	httpRequest.open("POST", url); // protocol 처리방식, 요청주소, 비동기, default가 true / false를 사용할 경우는 ID중복검사와 같이 정확한 데이터를 요구할때
	httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded")
	httpRequest.send(getParameterValue());
}

function callback2(){// 0->1->2->3->4
//	alert("httpRequest.readyState : "+httpRequest.readyState);
//	alert("서버에서 처리된 결과 코드 : "+ httpRequest.status);
	if(httpRequest.readyState == 4){
		alert("통신이 완료되었습니다");
		if(httpRequest.status == 200){
			alert("서버와 interactive 성공");
			console.log(httpRequest.responseText);
			
			var obj = JSON.parse(httpRequest.responseText);
//			$("#result").html(obj.name+"총점은?"+obj.sum+"이고 평균은 "+obj.avg);
//			출력값 아래에 추가로 출력해주는법
			var result = document.getElementById("result");
			var p = document.createElement("p");
			var txt = document.createTextNode(obj.name+"총점은?"+obj.sum+"이고 평균은 "+obj.avg);
			p.appendChild(txt);
			result.appendChild(p);
		}else{
			alert("데이터를 수신하지 못했습니다");
		}
	}
}






