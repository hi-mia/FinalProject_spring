//1:1문의글 리스트 뿌리기
$(function(){
	$.ajax({
		url : 'jaju/manager/getManagerInquire',
		type : 'post',
		data : 'pg = '+$('#pg').val(),
		dataType : 'json',
		
	});
});