//리스트
$(function(){
	$.ajax({
		
		type: 'post',
		url: '/jaju/manager/getManagerFreeboardList',
		data: 'pg='+$('#pg').val(), //{'pg':$('#pg').val(),'id':$('#id').val()}
		dataType: 'json',
		success: function(data){
			 if(JSON.stringify(data.list)=='[]'){
					
					$('<tr/>').append($('<div/>',{
						align:'center',
						text:'등록된 게시물이 없습니다',
						style:'height:300px; width:800px; line-height:300px;'
					})).appendTo($('#managerFreeboardTable'));
				}
				
			 else {
		
			  $.each(data.list, function(index, items){
		            $('<tr/>').append($('<td/>', {
		            	align: "center"
		            }).append($('<input/>', {
		            	type: 'checkbox',
		            	name: 'check',
		            	value: items.board_seq
		            }))).append($('<td/>',{
		               align:'center',
		               text: items.board_seq
		               
		            })).append($('<td/>',{
			               
		               }).append($('<a/>',{
		            	   style: "cursor:pointer;",
			               text: items.board_subject,
			               id: 'item',
		                  
		               })) 
		            ).append($('<td/>',{
		               align:'center',
		               text: items.board_id
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.logtime
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.board_hit
		               
		            })).appendTo($('#managerFreeboardTable'));
	
			}); //each
			  
			  

			  $(document).on('click', '#item', function(){

		               var seq = $(this).parent().prev().text();
		               location.href = '/jaju/manager/managerFreeboardView?board_seq='+seq+'&pg=1';

		         });

			  //페이징 처리
			$('#pagingArea').html(data.freeboardPaging.pagingHTML);		   
			 }//else
		}, 
			error:function(err){
			console.log(err);
			alert('error');
		}
	});
});

//function freeboardPaging(pg){
//	location.href="managerFreeboardList?pg="+pg;
//}

//검색
$('#managerBoardSearchBtn').click(function(){
	//alert($('input[name=pg]').val());
	//alert($('#pg').val());
	//alert('이미지클릭')
	//search_managerFree
	$('#search_managerFree').val($('#keyword').val())
	if($('#keyword').val() == ""){
		alert("검색어를 입력해 주세요");
		$('#keyword').focus();
	}  else{
	
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerFreeboardSearchList',
		data: $('#managerFreeboardSearchList').serialize(),
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#managerFreeboardTable tr:gt(0)').remove();
			
			   if(data.list.length == 0){
				   alert('검색어가 없습니다');
				   location.href = '/jaju/manager/managerFreeboardList?pg=1'
				   
			   }else{
			
			  $.each(data.list, function(index, items){
				  $('<tr/>').append($('<td/>', {
		            	align: "center"
		            }).append($('<input/>', {
		            	type: 'checkbox',
		            	name: 'check',
		            	value: items.board_seq
		            }))).append($('<td/>',{
		               align:'center',
		               text: items.board_seq
		               
		            })).append($('<td/>',{
			               
		               }).append($('<a/>',{
		            	   style: "cursor:pointer;",
			               text: items.board_subject,
			               id: 'item',
		                  
		               })) 
		            ).append($('<td/>',{
		               align:'center',
		               text: items.board_id
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.logtime
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.board_hit
		               
		            })).appendTo($('#managerFreeboardTable'));
	
	
			}); //each
			  
			  $(document).on('click', '#item', function(){

	               var seq = $(this).parent().prev().text();
	               location.href = '/jaju/manager/managerFreeboardView?board_seq='+seq+'&pg=1';

	         });

			   }
				$('#pagingArea').html(data.freeboardPaging.pagingHTML);		   
			
		}, error: function(err){
			console.log(err);
			alert('검색 리스트 생성 오류');
			
		}
	});

	return false;
	}
});

//전체 선택 또는 해제
$('#all').click(function(){
	//alert($('#all').attr('checked')); //checked 속성이 없어서 undefined으로 나온다
	//alert($('#all').prop('checked')); //true 또는 false / 값을 들고 와야 한다
	
	if($('#all').prop('checked')) {
		$('input[name=check]').prop('checked', true);	
	}else{
		$('input[name=check]').prop('checked', false);
	}

});

//선택 삭제
$('#choiceDeleteBtn').click(function(){
	var count = $('input[name=check]:checked').length; //체크된 개수가 나온다
	
	if(count == 0){
		alert("삭제할 게시물을 선택해주세요");
	}else{
		if(confirm("정말로 삭제하시겠습니까?")){
			   $('#managerFreeboardListDelete').attr("action", "/jaju/manager/managerFreeboardListDelete");
				$('#managerFreeboardListDelete').submit();
				alert('게시글 삭제 완료');
		}
	}
});


