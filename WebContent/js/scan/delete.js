$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

function userDelete(getUserId){
	var userId= getUserId;
	$.ajax({
		type: 'POST',
		url: '/webscanner/main/admin/userdelete.do',
		data: {userId: userId},
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