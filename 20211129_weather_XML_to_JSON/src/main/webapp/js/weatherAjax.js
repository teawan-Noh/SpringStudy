/**
 * 
 */

$(function(){
	$("#weaView").click(function(){
		console.log("ajax좀 해볼까?");
		var code = $("#address option:selected").val();
		console.log("필요한 주소값 : ", code);
		
		$.ajax({
			url:"./weatheropen.do",
			data:"zone="+code,
			type:"post",
			dataType:"text",
			success: function(msg){
//				alert(msg);
//				console.log(msg);
				var obj = JSON.parse(msg);
//				console.log(typeof obj);
//				console.log(obj.data);

				$("#x").val(obj.x);
				$("#y").val(obj.y);
				$("#pubDate").val(obj.pubDate);
				$("#wfKor").val(obj.wfKor);
				$("#temp").val(obj.temp);
				$("#pop").val(obj.pop);
				$("#reh").val(obj.reh);

				var weather_Condition = obj.wfKor;
				switch(weather_Condition){
					case '맑음': $("#weatherImg").attr('src','./img/clear.png'); break;
					case '구름 많음': $("#weatherImg").attr('src','./img/clear.png'); break;
				}
			},
			error: function(){
				console.log("잘못된 요청 처리");
			}
		});
	});
});