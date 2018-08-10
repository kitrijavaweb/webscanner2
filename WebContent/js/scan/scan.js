$(document).ready(function(){
	$("#scanstart").on("click",function(){
		var urldata = $("#url").val();
		alert(urldata)
		$.ajax({
			type:"GET",
			url:"/webscanner/main/scan/basicSqlScan.do",
			data:urldata,
			datatype:"text",
			success:function(data){
				alert("test"+data)
			/*	var str='';
				for(var i=1;i<111;i++){
					str+="안녕하세요 지금은 테스트중 입니다\n";
				}
				$("#resultText").html(str);*/
			},
			error:function(e){
				alert("에러발생")
			}
		})
	});
	$("#scanstop").on("click",function(){
		return;
	});
});
