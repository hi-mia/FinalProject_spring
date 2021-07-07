//신고글 뿌려지기
$(function(){
	//alert($('#pg').val());
	 $('#managerNotice').addClass('on');
	
	$.ajax({
		url: '/jaju/manager/getManagerNoticeList',
		type:'post',
		data: 'pg='+$('#pg').val(),
		dataType:'json',
		success:function(data){
			//alert(JSON.stringify(data));
			if(data.list.length != 0){
				$('.no_data').hide();
				
				$.each(data.list, function(index, items){
		            
		        	$('<tr/>').append($('<td/>',{
		        		align: 'center',
		        		width: '40px',
			        	}).append($('<input/>',{
							type: 'checkbox',
							name: 'check',
							value: items.notice_seq,
			        	}))
		        	).append($('<td/>',{
		        		width: '80px',
		                align: 'center',
		                text: items.notice_seq
		            })).append($('<td/>',{
		            	width: '594px',
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
			
			}else if(data.list.length == 0){
				$('.no_data').show();
			}
			
			//페이징 처리
	        $('#pagingArea').html(data.noticePaging.pagingHTML);
	        
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
$('#noticeDeleteBtn').click(function(){
	var count = $('input[name=check]:checked').length;
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		confirm("정말로 삭제하시겠습니까?");
		document.managerNoticeList.method='post';
		document.managerNoticeList.action="/jaju/manager/managerNoticeDelete";
		document.managerNoticeList.submit();
	}
});





//검색
$('.noticeSearch').click(function(){
	 if($('#keyword').val() == ''){
		   alert("검색어를 입력하세요")
	   }else{
		   $('#searchHidden').val($('#keyword').val());
		   
		   $('.mangerNoticeTable tr:gt(0)').remove();
		   
		   $.ajax({
			   type: 'post',  
			   url: '/jaju/manager/getNoticeSearchList',
			   data: {'pg':$('input[name=pg]').val(),
				   	  'itemcd':$('#itemcd').val(),
				   	  'keyword':$('#keyword').val()},
			   dataType: 'json',
			   success: function(data){
				   //alert(JSON.stringify(data));
				   if(data.list.length == 0){
					   alert('검색어가 없습니다');
					   location.href = '/jaju/manager/managerNoticeList'
				   }else{
					   
					   $.each(data.list, function(index, items){
				            
				        	$('<tr/>').append($('<td/>',{
				        		align: 'center',
				        		width: '40px',
					        	}).append($('<input/>',{
									type: 'checkbox',
									name: 'check',
									value: items.notice_seq,
					        	}))
				        	).append($('<td/>',{
				        		width: '80px',
				                align: 'center',
				                text: items.notice_seq
				            })).append($('<td/>',{
				            	width: '594px',
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
				   }
					//페이징 처리
			        $('#pagingArea').html(data.noticePaging.pagingHTML);
			   },
			   error: function(err){
		              console.log(err);
		       }
		   });
	   }
});

//페이징 이동
function noticePaging(pg){
	var keyword = document.getElementById('keyword').value;
	//alert(keyword);
	if($('#searchHidden').val() ==''){//keyword가 없을 때
		//alert($('.pg').val());
		location.href = "/jaju/manager/managerNoticeList?pg="+pg;	
	}else{
		//alert(pg);
		
		$('input[name=pg]').val(pg);
		
		$('#keyword').val($('#searchHidden').val())
		$('.noticeSearch').trigger('click');
		
		$('input[name=pg]').val(1);
		//alert($('input[name=pg]').val());
	}
	
}

//글쓰기 창 띄우기
$('.btn_admin.btn_type7_1').click(function(){
	location.href='/jaju/manager/managerNoticeWriteForm'
});