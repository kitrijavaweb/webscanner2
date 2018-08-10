/*$(document).ready(function() {
	$("#insertPattern").on("click", function() {
		var pattern = $("#attackweb").val();
		alert(pattern)
		$.ajax({
			type : "GET",
			url : "/webscanner/main/adminPageInfo.do",
			data : {pattern:pattern},
			success : function() {
				alert("test");
			},
			error: function(){
				alert("실패");
			}
		})
	});
	$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
		$("#myTable tr").filter(function() {
			$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		});
	});
});*/

