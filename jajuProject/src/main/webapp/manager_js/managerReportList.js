//신고글 뿌려지기
$(function(){
	//alert($('#pg').val());
	$('#managerReport').addClass('on');
	
	$.ajax({
		url: '/jaju/manager/getManagerReportList',
		type:'post',
		data: 'pg='+$('#pg').val(),
		dataType:'json',
		success:function(data){
			//alert(JSON.stringify(data));
			//console.log(JSON.stringify(data));
			
			if(data.list.length != 0){
				$('.no_data').hide();
				
				$.each(data.list, function(index, items){
		            
		        	$('<tr/>').append($('<td/>',{
		        		align: 'center',
		        		width: '40px',
			        	}).append($('<input/>',{
			        		type: 'checkbox',
							name: 'check',
							value: items.report_seq,
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
		            	width: '274px',
		            	
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
		        	
		        	$('#managerReportList').append($('<input/>', {
		        		type: 'hidden',
		        		name: 'check2',
		        		value: items.sale_seq
		        	}));
		        	
		        	
		        	$('.subject'+items.report_seq).click(function(){
						location.href = '/jaju/manager/managerReportView?report_seq='+items.report_seq+'&pg='+$('#pg').val();
					});
		        	
		        	//처리중 처리완료 색 변경
		        	$("td.state:contains('처리중')").css({color:"red"});
		        	$("td.state:contains('처리완료')").css({color:"blue"});
		        }); //each
			
			}else if(data.list.length == 0){
				$('.no_data').show();
			}
			
			//페이징 처리
	        $('#pagingArea').html(data.reportPaging.pagingHTML);
	        
		},
      	error: function(err){
      		console.log(err);
      	}
	});
});

$('#all').click(function(){

	if($('#all').prop('checked')){
		$('input[name=check]').prop('checked', true);
	}else{
		$('input[name=check]').prop('checked', false);
		
	}
});

//선택 삭제
$('#reportDeleteBtn').click(function(){
	var count = $('input[name=check]:checked').length;
	//alert($('#report_seq').val());
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		confirm("정말로 삭제하시겠습니까?");
		document.managerReportList.method='post';
		document.managerReportList.action="/jaju/manager/managerReportDelete";
		document.managerReportList.submit();
	}
});



//검색
$('.reportSearch').click(function(){
	 if($('#keyword').val() == ''){
		   alert("검색어를 입력하세요")
	   }else{
		   $('#searchHidden').val($('#keyword').val());
		   
		   $('.mangerReportTable tr:gt(0)').remove();
		   
		   $.ajax({
			   type: 'post',  
			   url: '/jaju/manager/getReportSearchList',
			   data: {'pg':$('input[name=pg]').val(),
				   	  'itemcd':$('#itemcd').val(),
				   	  'keyword':$('#keyword').val()},
			   dataType: 'json',
			   success: function(data){
				   //alert(JSON.stringify(data));
				   if(data.list.length == 0){
					   alert('검색어가 없습니다');
					   location.href = '/jaju/manager/managerReportList'
				   }else{
					   $.each(data.list, function(index, items){
				            
				        	$('<tr/>').append($('<td/>',{
				        		align: 'center',
				        		width: '40px',
					        	}).append($('<input/>',{
					        		type: 'checkbox',
									name: 'check',
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
				            	width: '274px',
				            	}).append($('<a/>',{
				            		href: '#',
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
								location.href = '/jaju/manager/managerReportView?report_seq='+items.report_seq+'&pg='+$('#pg').val();
							});
				        	
				        	//처리중 처리완료 색 변경
				        	$("td.state:contains('처리중')").css({color:"red"});
				        	$("td.state:contains('처리완료')").css({color:"blue"});
				        }); //each
				   }
					//페이징 처리
			        $('#pagingArea').html(data.reportPaging.pagingHTML);
			   },
			   error: function(err){
		              console.log(err);
		       }
		   });
	   }
});

//페이징 이동
function reportPaging(pg){
	var keyword = document.getElementById('keyword').value;
	
	if($('#searchHidden').val() ==''){//keyword가 없을 때
		location.href = "/jaju/manager/managerReportList?pg="+pg;	
	}else{
		
		$('input[name=pg]').val(pg);
		
		$('#keyword').val($('#searchHidden').val())
		$('.reportSearch').trigger('click');
		
		$('input[name=pg]').val(1);
		
	}
	
}