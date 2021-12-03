$(function(){
	parseJSON();
});

function parseJSON(){
	$.getJSON("json/BikeLoc.json", function(data){
		$.ajax({
			url :"./bikeController.do",
			type : "post",
			data : {"obj":JSON.stringify(data),"command":"second_db"}, 
			success : function(msg){
				console.log("전송받은 결과 값", msg);
				
				if(msg > 0){
					$.each(data,function(key,value){ // DESCRIPTION : "JSONObject", DATA :"JSONArray(JSONObject)"
			if(key=="DESCRIPTION"){
				// $tr= $("<tr>");   
				// var tr = document.createElement("tr");
				$("table").attr("border","1");
				$("thead").append("<tr>"+
					"<td>"+value.NEW_ADDR+"</td>"+
					"<td>"+value.CONTENT_ID+"</td>"+
					"<td>"+value.ADDR_GU+"</td>"+
					"<td>"+value.LONGITUDE+"</td>"+
					"<td>"+value.CRADLE_COUNT+"</td>"+
					"<td>"+value.LATITUDE+"</td>"+
					"<td>"+value.CONTENT_NM+"</td>"+
				    "</tr>");
			}else{
				var dList = value; //"JSONArray(JSONObject)"
				for(let i=0; i<dList.length ; i++){
					var oneData = dList[i];
					$("tbody").append("<tr>"+
					"<td>"+oneData.NEW_ADDR+"</td>"+
					"<td>"+oneData.CONTENT_ID+"</td>"+
					"<td>"+oneData.ADDR_GU+"</td>"+
					"<td>"+oneData.LONGITUDE+"</td>"+
					"<td>"+oneData.CRADLE_COUNT+"</td>"+
					"<td>"+oneData.LATITUDE+"</td>"+
					"<td>"+oneData.CONTENT_NM+
					"</td>"+
				    "</tr>");
				}
			}
		}); 
				}
			},
			error : function(){
				alert("잘못된 요청입니다")
			}
		});
	});
}