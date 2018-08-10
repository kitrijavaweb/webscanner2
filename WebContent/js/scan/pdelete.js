$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

function userDelete(getpattern){
	var pattern= getpattern;
	$.ajax({
		type: 'POST',
		url: '/webscanner/main/admin/patterndelete.do',
		data: {pattern: pattern},
		success: function(result){
			if(result ==1){
				$('#checkMessage').html("삭제완료");
				$('#checkType').attr('class', 'modal-content panel-success');
			}else{
				$('#checkMessage').html("삭제할 수 없습니다.");
				$('#checkType').attr('class', 'modal-content panel-warning');
			}
			$('#checkModal').modal("show");
		}
	})
}
function trDelete(obj){
	$(obj).parent().parent().remove();
}