// 게시글에서 title을 클릭했을 경우 content가 생성되고, 선택된 title외의 다른 content를 class를 변경하여 닫기게 함
var collapse = function(seq){
	$(".panel-collapse").not("#collapse"+seq).each(function(){
		$(this).attr("class","panel-collapse collapse");
	})
}

// 페이징 request인 row에서 전달받은 값을 사용하여 화면의 게시글의 리스트 갯수를 자동으로 선택되도록 함
$(document).ready(function(){
	var listNum = $("#listNum").val();
	$("#list option").each(function(){
		if(listNum == $(this).val()){
			$(this).prop("selected",true);
		}else{
			$(this).prop("selected",false);
		}
	});


//3) 선택된 chkval 모든 checkbox가 선택이 되면 자동으로 checkAll의 checkbox 해제/선택되도록 함	
	var chkval = document.getElementsByName("chkVal");
	var checkAll = document.getElementById("checkAll");
	for(let i=0; i<chkval.length; i++){
		chkval[i].onclick = function(){
			if(chkval.length == chsConfirm()){
				checkAll.checked = true;
			}else{
				checkAll.checked = false;
			}
		}
	}
	
});

// 다중삭제 관련 기능
// 1) 선택된 chkval의 갯수를 확인 하는 기능
function chsConfirm(){
	var chkval = document.getElementsByName("chkVal");
	var choiceCnt = 0;
	for(let i=0; i< chkval.length; i++){
		if(chkval[i].checked){
			choiceCnt++;
		} 
	}
	return choiceCnt;
}

// 2)전체 선택 기능
function checkAllFn(bool){
	var chkval = document.getElementsByName("chkVal");
//	console.log(chkval.length);
	for(let i=0; i< chkval.length; i++){
		chkval[i].checked = bool;
	}
}

function submitForm(){
	document.forms[0].submit();
}

function chkbox(){
	var isc = false;
	if(chsConfirm() >0){
				swal({
			        title: "다중삭제",
			        text: "삭제를 진행하시겠습니까?",
			        type: "warning",
			        showCancelButton: true,
			        confirmButtonClass: "btn-danger",
			        confirmButtonText: "예",
			        cancelButtonText: "아니요",
			        closeOnConfirm: true,
			        closeOnCancel: false 
			    },
			    function(isConfirm) {
			        if (isConfirm) {
			            swal("", "삭제를 실행하겠습니다");
						submitForm();
			        } else {
			            swal("", "삭제를 취소하셨습니다");
			        }
			    }
			);
	}else{
		swal("삭제 오류","선택된 게시글이 없습니다");
	}
	return isc;
}


// 페이징 처리를 통한 SPA 화면 구현

function pageFirst(){
	console.log("pageFirst");
	var index = document.getElementById("index"); // 현재 눌려진 페이지 0부터 시작
	var pageNum = document.getElementById("pageNum"); // 보여지는 페이지 시작번호
	index.value=0;
	pageNum.value=1;
	pageAjax();
}

//pagePrev(1,5)
function pagePrev(num,pageList){
	console.log(num, pageList);
	if(0<num-pageList){
		num -= pageList;
		var index = document.getElementById("index"); // 현재 눌려진 페이지 0부터 시작
		var pageNum = document.getElementById("pageNum");
		index.value=num-1;
		pageNum.value=num;
	}
	pageAjax();
	
}
//pageNext
function pageNext(num, total, listNum, pageList){
	console.log(num, total, listNum, pageList);
	
	var idx = Math.ceil(total/listNum);
	var max = Math.ceil(idx/pageList);
	
	if(max*pageList > num+pageList){
		num += pageList;
		var index = document.getElementById("index"); // 현재 눌려진 페이지 0부터 시작
		var pageNum = document.getElementById("pageNum");
		
		index.value = num-1;
		pageNum.value = num;
	}
	pageAjax();
}
//pageLast
function pageLast(num, total, listNum, pageList){
	console.log(num, total, listNum, pageList);
	var idx = Math.ceil(total/listNum);//
	var max = Math.ceil(idx/pageList)//
	
	while(max*pageList > num+pageList){
		num += pageList;
	}
	
	var index = document.getElementById("index"); // 현재 눌려진 페이지 0부터 시작
	var pageNum = document.getElementById("pageNum");
		
	index.value = idx-1;
	pageNum.value = num;
	
	pageAjax();
}

//pageIndex
function pageIndex(pagenum){
	var index = document.getElementById("index");
	index.value = pagenum-1;
	pageAjax();
}

//pageList
function pageList(){
	var index = document.getElementById("index"); 
	var pageNum = document.getElementById("pageNum");
	var listNum = document.getElementById("listNum");
	
	index.value=0;
	pageNum.value = 1;
	listNum.value = document.getElementById("list").value;
	
	pageAjax();
	
}


var pageAjax = function(){
	console.log($("#frm").serialize);
	
	$.ajax({
		url: "./page.do",
		type:"post",
		async:true,
		data : $("#frm").serialize(),
		dataType : "json",
		success : function(msg){ // {"lists" : [{},{}..], "row",{"","",""}}
			console.log(msg);
			
			
			$.each(msg, function(key,value){
				var varHtml ="";
				var n = $(".table tr:eq(0) th").length;
				
				if(key =='lists'){
					//thead
					varHtml += "<thead>                ";
					varHtml += "	<tr>               ";
					if(n == 7){
						varHtml +="<th>";
						varHtml +="<input type='checkbox' id='checkAll' onclick='checkAllFn(this.checked)'>";
						varHtml +="</th>";
					}
					varHtml += "		<th>글번호</th>";
					varHtml += "		<th>제목</th>  ";
					varHtml += "		<th>작성자</th>";
					varHtml += "		<th>조회수</th>";
					if(n == 7){
						varHtml +="<th>삭제여부</th>";
					}
					varHtml += "		<th>작성일</th>";
					varHtml += "	</tr>              ";
					varHtml += "</thead>               ";
					//tbody
					varHtml += "<tbody>               ";
					$.each(value,function(k,v){
						varHtml+="<tr>                                                                                                                                                     "  ;
						if(n ==7){
							varHtml+="	<td><input type='checkbox' name='chkVal' value='"+v.seq+"'></td>                                                                                              "  ;
						}
						
						varHtml+="	<td>"+v.seq+"</td>                                                                                                                                            "  ;
						varHtml+="	<td><a data-toggle='collapse' href='#collapse"+v.seq+"' onclick='collapse("+v.seq+")'>"+v.title+"</a></td>";
						varHtml+="	<td>"+v.id+"</td>                                                                                                                                          ";
						varHtml+="	<td>"+v.readcount+"</td>                                                                                                                                               ";
						if(n ==7){
							varHtml+="	<td>"+v.delflag+"</td>                                                           	                                                                                 ";
						}
						varHtml+="	<td>"+v.regdate+"</td>                                                                                                                             ";
						varHtml+="</tr>                                                                                                                                                      ";
						
						varHtml+="<tr>                                                                                    ";
						varHtml+="	<td colspan='"+n+"'>                                                                       ";
						varHtml+="		<div id='collapse"+v.seq+"' class='panel-collapse collapse'>                 ";
						varHtml+="			<div class='form-group'>                                                       ";
						varHtml+="				<label>내용</label>                                                        ";
						varHtml+="				<textarea rows='5'  class='form-control' >"+v.content+"</textarea>   ";
						varHtml+="			</div>                                                                         ";
						varHtml+="			<div class='form-group'>                                                       ";
						
						if(v.memid == v.id) {
							varHtml+="					<input type='button' class='btn btn-success' value='글수정' onclick='modify('"+v.seq+"')'>          ";
						}
						if(v.id==v.memid || n==7) {
							varHtml+="					<input type='button' class='btn btn-warning' value='글삭제' onclick='del('"+v.seq+"')'>          ";
						}
						if(n!=7) {
							varHtml+="					<input type='button' class='btn btn-info' value='답글' onclick='reply('"+v.seq+"')'>               ";
						}
						varHtml+="			</div>                                                                         ";
						varHtml+="		</div>                                                                             ";
						varHtml+="	</td>                                                                                  ";
						varHtml+="</tr> ";
						
					});                                                                                                                                                                      
					varHtml += "</tbody>               ";
					
				}else{
					
				  varHtml += "<li><a href='#' onclick='pageFirst()'><span class='glyphicon glyphicon-fast-backward'></span> </a></li>                                                        ";
				  varHtml += "<li><a href='#' onclick='pagePrev("+value.pagenum+","+value.pagelist+")'><span class='glyphicon glyphicon-step-backward'></span></a></li>                            ";
				  varHtml += "                                                                                                                                                               ";
					for(let i= value.pagenum; i<=value.count; i++){
					  varHtml += "  <li><a href='#' onclick='pageIndex("+i+")'>"+i+"</a></li>                                                                                                    ";
					}				  
				  varHtml += "                                                                                                                                                               ";
				  varHtml += "<li><a href='#' onclick='pageNext("+value.pagenum+","+value.total+","+value.listnum+","+value.pagelist+")'><span class='glyphicon glyphicon-step-forward'></span> </a></li>";
				  varHtml += "<li><a href='#' onclick='pageLast("+value.pagenum+","+value.total+","+value.listnum+","+value.pagelist+")'><span class='glyphicon glyphicon-fast-forward'></span> </a></li>";
					
				}
				
				if(key == 'lists'){
					$(".table").html(varHtml);
				}else{
					$(".pagination").html(varHtml);
				}
				
			});
			
		},
		error: function(){
			alert("잘못된 요청 입니다");
		}
		
	});
}


function modify(seq){
	console.log(seq.trim());
	ajaxModify(seq);
	$("#modify").modal();
}

var ajaxModify = function(val){
	console.log("ajaxModify",val.trim());
	$.ajax({
		url:"./modifyForm.do",
		type:"post",
		data:"seq="+val.trim(),
		dataType:"json",
		success:function(v){
			console.log(v);
			html = "";
			html += "<div class='form-group'>";
			html += "			  <input type='hidden' name='seq' value='"+v.seq+"'>                                    ";
			html += "			  <label id='id'>아이디</label>                                                                      ";
			html += "			  <p class='form-control'>"+v.id+"</p>                                                              ";
			html += "		    </div>                                                                                               ";
			html += "		                                                                                                         ";
			html += "		    <div class='form-group'>                                                                             ";
			html += "			  <label id='id'>작성일</label>                                                                      ";
			html += "			  <p class='form-control'>"+v.regdate+"</p>                                                             ";
			html += "		    </div>                                                                                               ";
			html += "		                                                                                                         ";
			html += "		    <div class='form-group'>                                                                             ";
			html += "			  <label id='id'>제목</label>                                                                        ";
			html += "			  <input type='text' class='form-control' id='title' name='title' required value='"+v.title+"'>";
			html += "		    </div>                                                                                               ";
			html += "		                                                                                                         ";
			html += "		    <div class='form-group'>                                                                             ";
			html += "			  <label id='id'>내용</label>                                                                        ";
			html += "			  <textarea rows='5' class='form-control' id='content' name='content' required>"+v.content+"</textarea>   ";
			html += "		    </div>                                                                                               ";
			html += "		                                                                                                         ";
			html += "		    <div class='modal-footer'>                                                                           ";
			html += "		    	<input type='button' class='btn btn-success' value='글수정' onclick='updateVal()'>               ";
			html += "		    	<input type='reset' class='btn btn-info' value='초기화'>                                         ";
			html += "		    	<button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>                 ";
			html += "		    </div>                                                                                               ";
			$("#frmModify").html(html);
		},                                                                                                                           
		error:function(){
			alert("잘못된 요청 처리입니다");
		}
	});
}

function updateVal(){
	var frm = document.getElementById("frmModify");
	frm.action="./modify.do";
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	if(title.value == "" || content.value==""){
		swal("수정 오류","제목과 내용은 필수입니다");
	}else{
		frm.submit();
	}
}

function del(seq){
	console.log(seq.trim());
	location.href ="./del.do?seq="+seq;
}

function writeBoard(){
	$("#write").modal();
}

function writeVal(){
	console.log("새글작성 submit");
	var frm = document.getElementById("frmWrite");
	frm.action="./write.do";
	var title = document.getElementById("title");
	var content = document.getElementById("content");
	if(title.value == "" || content.value == ""){
		swal("새 글 작성 오류", "제목과 내용은 필수입니다.");
	}else{
		frm.submit();
	}
}

function reply(seq){
	console.log(seq.trim());
	$("#reply").modal();
	ajaxReply(seq);
}

var ajaxReply = function(v){
	console.log("답글 작성 modal",v);
	$.ajax({
		url:"./replyForm.do",
		type:"post",
		data:{"seq":v},
		success:function(r){ //{"session_id":"아이디","obj":{"id":"아이디","제목":"글제목"....}}
		//만약에 jackson-binding이 아니라 text로 서버에서 받고, ajax에서 dataType이 json으로 선언되어있지 않다면
		//서버에서 JSON 객체의 모양이 출력 형태를 받게 된다(서버에서는 이를 쉽게 작성하기 위해서 json-simple.jar를 사용)
		//서버에서 반환할 때 json.toString() 하게 되면 자동으로 json형태의 문자열로 만들어진다{"":""}
		//만약 그냥 java문법을 통해서 작성하게 되면 coccatenation 문법을 사용하고 문자열은 escape 문자를 통해서 "(double quote)를 처리해줘야 한다.
		//서버에서 문자열로 반환된 값을 javascript에서 parse를 해줘야 한다
		//var j = JSON.parse('{"key":"val"}');
			console.log("반환값",r);
			/*$("#frmReply").html("");
			var div = $("<div>").attr("class","form-group");
			var input = $("<input>").attr({"type":"hidden","name":"seq","value":r.obj.seq});
			var label = $("<label></label>").text("부모글정보("+r.obj.seq+")");
			var p = $("<p>").text("조회수"+r.obj.readcount+"/작성일"+r.obj.regdate+"/작성자"+r.obj.id);
			div.append(input).append(label).append(p);
			$("#frmReply").append(div);*/
			
				html = "";
				html += "<div class='form-group'>";
				html += "			  <input type='hidden' name='seq' value='"+r.obj.seq+"'>                                    ";
				html += "			  <label id='id'>부모글정보("+r.obj.seq+")</label>                                                                      ";
				html += "			  <p class='form-control'><b>"+"조회수"+r.obj.readcount+"/작성일"+r.obj.regdate+"/작성자"+r.obj.id+"</b></p>                                                              ";
				html += "		    </div>                                                                                               ";
				html += "		                                                                                                         ";
				html += "<div class='form-group'>";
				html += "<label>작성자</div>";
				html += "<p>"+r.session_id+"</p>";
				html += "</div>";
				
				html += "<div class='form-group'>";
				html += "<label id='titl'>제목(원본)</div>";
				html += "<input type='text' class='form-control' id='tt' name='title' value='"+r.obj.title+"'>";
				html += "</div>";
				
				html += "<div class='form-group'>";
				html += "<input type='hidden' class='form-control' id='hiddenContent' value='"+r.obj.content+"'>";
				html += "<label id='con'>내&nbsp;&nbsp;&nbsp;&nbsp;용(원본)</div>";
				html += "<textarea row='5' class='form-control' id='Txtarea' name='content' onclick='chk()'>"+r.obj.content+"</textarea>";
				html += "</div>";
				
				html += "		    <div class='modal-footer'>                                                                           ";
				html += "		    	<input type='button' class='btn btn-success' value='답글작성' onclick='replyVal()'>               ";
				html += "		    	<span onclick='reset()'> <input type='reset' class='btn btn-info' value='초기화'></span>                                         ";
				html += "		    	<button type='button' class='btn btn-default' data-dismiss='modal'>취소</button>                 ";
				html += "		    </div>                                                                                               ";
			
			$("#frmReply").html(html);
		},
		error:function(){
			alert("잘못된 요청 처리입니다.");
		}
	});
}

function chk(){
	var con = document.getElementById("con");
	var titl = document.getElementById("titl");
	
	var title = document.getElementById("tt");
	var txtarea = document.getElementById("Txtarea");
	var hiddenContent = document.getElementById("hiddenContent");
	
	console.log(con,titl,title,txtarea,hiddenContent);
	
	if(txtarea.value == hiddenContent.value){
		con.innerHTML = "내용";
		titl.textContent = "제목";
		txtarea.value="";
		title.value="";
		
	}
}

function reset(){
	document.getElementById("titl").innerHTML="제목(원본)";
	document.getElementById("con").innerHTML="내&nbsp;&nbsp;&nbsp;&nbsp;용(원본)";
}

function replyVal(){
	var frm = document.getElementById("frmReply");
	frm.action = "./reply.do";
	var title = $("#tt").val();
	
	if(title==""){
		swal("답글작성","제목은 필수값입니다.");
	}else{
		var titl = $("#titl").html();
		if(titl == '제목'){
			frm.submit();
		}else{
			swal('답글 작성 오류',"답글이 작성되지 않았습니다");
		}
	}
}






