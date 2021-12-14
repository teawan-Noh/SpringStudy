/**
 * duplication.js
 */

$(document).ready(function(){
	$("#userid").css("display","none");// ({:,:}) css여러개 먹일떄
});

function checkid(obj){
	console.log(obj);
	var id = document.getElementById("id").value;
	$.ajax({
		url:"./duplicateAjax"+obj+".do",
		type: "post",
		data:"chkid="+id,
		dataType:"JSON",
		async:true,
		success:function(msg){ //JSON으로 받아왔다.
			/*console.log(msg.val);*/
			console.log(msg.isc);
			if(msg.isc == true){
				document.getElementById("condition").innerHTML = "<div class='success'>사용 가능합니다</div>";
				/*document.getElementById("userid").style.display="block"; 자바스크립트버전*/
				$("#userid").css("display","block"); /*jquery버전*/
			}else{
				document.getElementById("condition").innerHTML = "<div class='success'>사용 불가능합니다</div>";
				document.getElementById("userid").style.display="none";
				
			}
			
		},
		error:function(){
			alert("잘못된 요청 처리");
		}
	});
}

function useid(){
	var doc = document.getElementById("id").value;
	opener.document.getElementById("id").value=doc;
	opener.document.getElementById("name").focus();
	window.close();
}