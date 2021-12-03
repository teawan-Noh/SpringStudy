$(function(){
	getJson();
});


function getJson(){
	$.getJSON("json/BikeLoc.json",function(data){
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
					"<input type='hidden' name='bike' value='"+
					oneData.NEW_ADDR+"/"+
					oneData.CONTENT_ID+"/"+
					oneData.ADDR_GU+"/"+
					oneData.LONGITUDE+"/"+
					oneData.CRADLE_COUNT+"/"+
					oneData.LATITUDE+"/"+
					oneData.CONTENT_NM
					+"'/>  </td>"+
				    "</tr>");
				}
			}
		});  
	});	
	
}