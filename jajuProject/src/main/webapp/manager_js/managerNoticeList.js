//신고글 뿌려지기
$(function(){
	//alert($('#pg').val());
	$.ajax({
		url: '/jaju/manager/getManagerNoticeList',
		type:'post',
		data: 'pg='+$('#pg').val(),
		dataType:'json',
		success:function(data){
			alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
	            
	        	$('<tr/>').append($('<td/>',{
	        		align: 'center',
	        		width: '40px',
		        	}).append($('<input/>',{
						type: 'checkbox',
						id: 'all',
						onclick: 'checkAll()',
		        	}))
	        	).append($('<td/>',{
	        		width: '80px',
	                align: 'center',
	                text: items.notice_seq
	            })).append($('<td/>',{
	            	
	            	}).append($('<a/>',{
	            		href: '#',
	            		width: '594px',
	            		text: items.notice_subject,
	            		class: 'subject'+items.notice_seq
	            	}))
	            ).append($('<td/>',{
	            	width: '120px',
	            	align: 'center',
	            	text: items.logtime
	            })).appendTo('.mangerNoticeTable');
	        	
	        	$('.subject'+items.notice_seq).click(function(){
					location.href = '/jaju/manager/managerNoticeView?notice_seq='+items.notice_seq+'&pg='+$('#pg').val();
				});
	        	
	        	//처리중 처리완료 색 변경
	        	$("td.state:contains('처리중')").css({color:"red"});
	        	$("td.state:contains('처리완료')").css({color:"blue"});
	        }); //each
			
			//페이징 처리
	        $('#pagingArea').html(data.noticePaging.pagingHTML);
	        
		},
      	error: function(err){
      		console.log(err);
      	}
	});
});

//페이징 이동
function noticePaging(pg){
	location.href = "/jaju/manager/managerNoticeList?pg="+pg;
}

//글쓰기 창 띄우기
$('.btn_admin.btn_type7_1').click(function(){
	location.href='/jaju/manager/managerNoticeWriteForm'
});