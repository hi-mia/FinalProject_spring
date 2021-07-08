//1:1문의글 리스트 뿌리기
$(function(){
	$.ajax({
		url : '/jaju/manager/getManagerInquire',
		type : 'post',
		data : {'pg': $('#pg').val(),
				'inquiry_seq':$('#inquiry_seq').val(),
				'inquiry_id' : $('#inquiry_id').val()},
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
				
			
		if(data.list.length != 0){
			$('.no_data').hide();
				
			$.each(data.list, function(index, items){
				
				$('<tr/>').append($('<td/>',{
					align: 'center'
					}).append($('<input/>',{
						type : 'checkbox',
						id : 'all',
						name : 'check',
						value : items.inquiry_seq
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
					//alert(items.inquiry_seq);
					//alert($('#pg').val());
					location.href = '/jaju/serviceCenter/managerInquireView?seq='+items.inquiry_seq+'&pg='+$('#pg').val()+'&inquiry_id='+items.inquiry_id;
				});
				//처리중 처리완료 색 변경
	        	$("td.state:contains('처리중')").css({color:"red"});
	        	$("td.state:contains('처리완료')").css({color:"blue"});
			});
		}else if(data.list.length == 0){
			$('.no_data').show();
		}
		//페이징 처리
		$('.page_admin').html(data.inquirePaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
});
//전체 선택 또는 해제
$('#all').click(function(){
	//alert($('#all').attr('checked')); //checked 속성이 없어서 undefind로 나온다. 존재유무
	//alert($('#all').prop('checked')); //true/false 값을 가져온다.
	
	if($('#all').prop('checked')){
		$('input[name=check]').prop('checked',true);
	}else{
		$('input[name=check]').prop('checked',false);
	}
});
//선택 삭제
$('#choiceDeleteBtn').click(function(){
	var count = $('input[name=check]:checked').length;
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		confirm("정말로 삭제 하시겠습니까?");
		$('#managerInquireDelete').submit();
	}
});
//페이징 이동
function inquirePaging(pg){
	location.href = "/jaju/manager/managerServiceInquire?pg="+pg;
}

// 검색
$('#managerServiceInquireBtn').click(function(){
	
	if($('input[name=keyword]').val() == ''){
		   alert("검색어를 입력하세요")
	   }else{
		   $('.tbl_admin tr:gt(0)').remove();
		   
		   $.ajax({
			   type : 'post',
			   url : '/jaju/manager/getInquireSearchList',
			   data : {'pg':$('input[name=pg]').val(),
				   	  'itemcd':$('#itemcd').val(),
				   	  'keyword':$('input[name=keyword]').val()},
			   dataType : 'json',
			   success : function(data){
				// alert(JSON.stringify(data))
				 
					   $.each(data.list, function(index, items){
						   $('<tr/>').append($('<td/>',{
								align: 'center'
								}).append($('<input/>',{
									type : 'checkbox',
									id : 'all',
									name : 'check',
									value : items.inquiry_seq
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
							// alert(items.inquiry_seq);
							// alert($('#pg').val());
							location.href = '/jaju/serviceCenter/managerInquireView?seq='+items.inquiry_seq+'&pg='+$('#pg').val()+'&inquiry_id='+items.inquiry_id;
				        	});
				        	
				        	// 처리중 처리완료 색 변경
				        	$("td.state:contains('처리중')").css({color:"red"});
				        	$("td.state:contains('처리완료')").css({color:"blue"});
				        }); // each
					   
				  
			   },
			   error : function(err){
				   console.log(err);  
			   }
		 });
	   }
});

//페이징 이동
function inquirePaging(pg){
	var keyword = $('input[name=keyword]').val();
	
	if(keyword== ''){//keyword가 없을 때
		location.href = "/jaju/manager/managerServiceInquire?pg="+pg;	
	}else{
		
		$('input[name=pg]').val(pg);
		
		$('#managerServiceInquireBtn').trigger('click');
		
		$('input[name=pg]').val(1);
		
	}
	
}













