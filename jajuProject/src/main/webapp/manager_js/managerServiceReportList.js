//신고글 뿌려지기
$(function(){
	//alert($('#pg').val());
	$.ajax({
		url: '/jaju/manager/getManagerReportList',
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
	        		width: '75px',
	                align: 'center',
	                text: items.report_seq
	            })).append($('<td/>',{
	            	width: '135px',
	            	align: 'center',
	            	text: items.reportType
	            })).append($('<td/>',{
	            	
	            	}).append($('<a/>',{
	            		href: '#',
	            		width: '274px',
	            		text: items.report_subject,
	            		class: 'subject'+items.report_seq
	            	}))
	            ).append($('<td/>',{
	            	width: '100px',
	                align: 'center',
	                text: items.report_id
	            })).append($('<td/>',{
	            	width: '105px',
	            	align: 'center',
	            	text: items.logtime
	            })).append($('<td/>',{
	            	width: '105px',
	            	align: 'center',
	            	text: items.report_state,
	            	class: 'state',
	            })).appendTo('.mangerReportTable');
	        	
	        	$('.subject'+items.report_seq).click(function(){
					location.href = '/jaju/serviceCenter/reportView?report_seq='+items.report_seq+'&pg='+$('#pg').val();
				});
	        	
	        	//처리중 처리완료 색 변경
	        	$("td.state:contains('처리중')").css({color:"red"});
	        	$("td.state:contains('처리완료')").css({color:"blue"});
	        }); //each
			
			//페이징 처리
	        $('#pagingArea').html(data.reportPaging.pagingHTML);
	        
		},
      	error: function(err){
      		console.log(err);
      	}
	});
});

//페이징 이동
function reportPaging(pg){
	location.href = "/jaju/manager/managerServiceReportList?pg="+pg;
}