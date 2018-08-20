$(document).ready(function(){
	$("#scanstart").on("click",function(){
		var url = {"url":$("#url").val()}
		startTime = new Date();
		$.ajax({
			url:"/webscanner/main/scan/basicXssScan.do",
			type:"GET",  
			data:url,
			datatype:"text",
			cache:false,
			success:function(text){
				$("#resultText").append(text);
			},//http://211.42.204.62:8088/WebProject/main/Main.html
			error:function(e){
				alert("에러발생")
			},
			complete:function(){
				var endTime = new Date();
				timeoff = endTime-startTime
				timeoff/=1000;
				var second = Math.round(timeoff%60);
				$("#resultText").append("검사완료 ("+second+"초)\n");
			}
		})
	});
	$("#scanstop").on("click",function(){
		var endTime = new Date();
		timeoff = endTime-startTime
		timeoff/=1000;
		var second = Math.round(timeoff%60);
		$("#resultText").append("검사중지 ("+second+"초)\n");
		return;
	});
});
