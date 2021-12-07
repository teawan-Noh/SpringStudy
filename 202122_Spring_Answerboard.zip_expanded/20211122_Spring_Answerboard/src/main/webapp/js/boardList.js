/**
 * 
 */

window.onload = function(){
	console.log("온로드");
	var chks = document.getElementsByName('chk');
	var allChk = document.getElementById('allChk');
	for(let chk in chks){
		chks[chk].onclick = function(){
			//전체체크박스
			const chksCnt = document.querySelectorAll("input[name=chk]");
			//선택된체크박스 : 속성탐색
			const chkedCnt = document.querySelectorAll("input[name=chk]:checked");
			if(chkedCnt.length === chksCnt.length){
				allChk.checked=true;
			}else{
				allChk.checked=false;
			}
		}
	}
}
/** 다중삭제를 위한 checkbox의 상태 조회
	checkbox가 하나라도 check되어 있지 않다면 submit을 실행하지 않음
	propagation(전파방지) / onsubmit = "return false"
 */
function checkBox(){
	const chkedCnt = document.querySelectorAll("input[name=chk]:checked");
	console.log("선택된 삭제 대상 개수", chkedCnt.length);
	if(chkedCnt.length>0){
		return true;
		//아래방법은 input의 submit이 아닌 javascript onsubmit 이벤트를 실행시키키때문에 submit을 button으로 변경해야함
//1.	document.forms[0].action = './multiDel.do'; //이벤트의 기능에 따라서 요청하는 action이 다른경우
//2.	document.frm.onsubmit(); // 가지고있는 form태그중 frm의 이름을 가진 form을 동작시킴
//3.	document.getElementById('frm').onsubmit(); 가지고있는 form태그중 frm의 id를 가진 form을 동작시킴
	}else{
		swal("삭제대상이 없습니다", "반드시 한개 이상의 글을 선택하세요");
		return false;
	}
}

function allChks(bool){
	console.log("전체 checkbox 상태", bool);
	
	var chks = document.getElementsByName('chk');
	console.log(chks.length);
	for(let c in chks){
		chks[c].checked = bool;
	}
}

//jquery 버전
/*
$(document).ready(function(){
	$('#allChk').click(function(){
		$('input[name=chk]').prop('checked', this.checked)
	});
});
*/


/*
function chkall(bool){
	const chks = document.getElementsByName('chks');
	chks.forEach((chk)=>{chk.checked = bool})
}
*/