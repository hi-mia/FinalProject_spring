//1:1문의글 리스트 뿌리기
$(function(){
	
	$.ajax({
		url : '/jaju/manager/getManagerInquire',
		type : 'post',
		data : {'pg ': $('#pg').val(),
				'inquiry_seq':$('#inquiry_seq').val()},
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
				
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
					width: '135px',
	            	align: 'center',
	            	text: items.inquiryType
				})).append($('<td/>',{
					}).append($('<a/>',{
	            		href: '#',
	            		width: '274px',
	            		text: items.inquiry_subject,
	            		class: 'subject'+items.inquiry_seq
	            	}))
				).append($('<td/>',{
					width: '100px',
	                align: 'center',
	                text: items.inquiry_id
				})).append($('<td/>',{
					width: '105px',
	            	align: 'center',
	            	text: items.logtime
				})).append($('<td/>',{
					width: '105px',
	            	align: 'center',
	            	text: items.inquiry_state,
	            	class: 'state',
				})).appendTo($('#tbl_admin'))
				
				$('.subject'+items.inquiry_seq).click(function(){
					alert(items.inquiry_seq);
					alert($('#pg').val());
					location.href = '/jaju/serviceCenter/inquireView?inquiry_seq='+items.inquiry_seq+'&pg='+$('#pg').val();
				});
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});
