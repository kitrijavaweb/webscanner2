$(document).ready(function(){
	$("#scanstart").on("click",function(){
		var url = $("#url").val();
		$.ajax({
			type:"POST",
			url:"/main/scan/basicSqlScan.do",
			contentType: "application/x-www-form-urlencoded; charset=euc-kr",
			success:function(){
				var str='';
				for(var i=1;i<111;i++){
					str+="안녕하세요 지금은 테스트중 입니다\n";
				}
				$("#resultText").html(str);
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
