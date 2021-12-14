/**
 * 
 */

/*document.onkeydown = function(){
   console.log(event);
   if((event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82) || event.keyCode == 116)){
      // event.ctrlKey : ctrl키를 눌렀을때
      // event.keyCode == 78 : N키
      // event.keyCode == 116 : F5키
      // event.keyCode == 82 : R키
      event.keycode = 0;
      event.cancelBubble = true;
      event.returnValue = false;
   }   
   document.onkeydown = doNotReload
}*/


var isShow = true;
function validateForm(){
	var form = document.forms[0];
	console.log(form);	
	
	var id = document.getElementById("id");
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	
	if(id.value == "" || title.value == "" || content.value == ""){
		alert("필수값을 입력해 주세요");
	}else{
		var str = content.value;
		str= str.replace(/\r\n|\r|\n|\n\r/g, '<br>');
		//content.innerHTML = str;
		content.textContent = str;
		//document.getElementById("changeTextArea").innerHTML = str;
		isShow = false;
		form.submit();
	}
}

window.onbeforeunload = function(){
	if(isShow){
	return "화면을 벗어납니다";
		
	}
}