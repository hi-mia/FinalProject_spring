//1:1문의글 리스트 뿌리기
$(function(){
	$.ajax({
		url : 'jaju/manager/getManagerInquire',
		type : 'post',
		data : 'pg = '+$('#pg').val(),
		dataType : 'json',
		success : function(data){
			alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				
				$('<tr/>').append($('<td/>',{
					align: 'center'
					}).append($('<input/>',{
						type : 'checkbox',
						id : 'all',
						onclick : 'checkAll()'
					}))
				).append($('<td/>',{
					width: '75px',
	                align: 'center',
	                text: items.inquiry_seq
				})).append($('<td/>',{
					
				})).append($('<td/>',{
					
				})).append($('<td/>',{
					
				})).append($('<td/>',{
					
				})).append($('<td/>',{
					
				})).appendTo($('#tbl_admin'))
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});