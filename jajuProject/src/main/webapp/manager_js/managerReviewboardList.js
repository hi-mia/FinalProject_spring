//리스트
$(function(){
	$.ajax({
		
		type: 'post',
		url: '/jaju/manager/getManagerReviewboardList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
		
			  $.each(data.list, function(index, items){
		            $('<tr/>').append($('<td/>', {
		            	align: "center"
		            }).append($('<input/>', {
		            	type: 'checkbox',
		            	name: 'check',
		            	value: items.review_seq
		            }))).append($('<td/>',{
		               align:'center',
		               text: items.review_seq
		               
		            })).append($('<td/>',{
			               
		               }).append($('<a/>',{
		            	   style: "cursor:pointer;",
			               text: items.review_subject,
			               id: 'item',
		                  
		               })) 
		            ).append($('<td/>',{
		               align:'center',
		               text: items.review_id
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.review_date
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.review_hit
		               
		            })).appendTo($('#managerReviewboardTable'));
	
			}); //each
			  
//			  $(document).on('click', '#item', function(){
//
//		               var seq = $(this).parent().prev().text();
//		               location.href = '/jaju/manager/managerReviewboardView?board_seq='+seq+'&pg=1';
//
//		         });

			  //페이징 처리
			$('#pagingArea').html(data.reviewboardPaging.pagingHTML);		   
		}, 
			error:function(err){
			console.log(err);
			alert('error');
		}
	});
});

function reviewboardPaging(pg){
	location.href="managerReviewboardList?pg="+pg;
}

//검색
//$('#managerBoardSearchBtn').click(function(){
	//alert($('input[name=pg]').val());
	//alert($('#pg').val());
	//alert('이미지클릭')
//	if($('#searchText').val() == ""){
//		alert("검색어를 입력해 주세요");
//		$('#searchText').focus();
//	}  else{
//	
//	$.ajax({
//		type: 'post',
//		url: '/jaju/manager/getManagerReviewboardSearchList',
//		data: $('#managerReviewboardSearchList').serialize(),
//		dataType: 'json',
//		success: function(data){
//			//alert(JSON.stringify(data));
//			
//			$('#managerReviewboardTable tr:gt(0)').remove();
//			
//			  $.each(data.list, function(index, items){
//				  $('<tr/>').append($('<td/>', {
//		            	align: "center"
//		            }).append($('<input/>', {
//		            	type: 'checkbox',
//		            	name: 'check',
//		            	value: items.board_seq
//		            }))).append($('<td/>',{
//		               align:'center',
//		               text: items.board_seq
//		               
//		            })).append($('<td/>',{
//			               
//		               }).append($('<a/>',{
//		            	   style: "cursor:pointer;",
//			               text: items.board_subject,
//			               id: 'item',
//		                  
//		               })) 
//		            ).append($('<td/>',{
//		               align:'center',
//		               text: items.board_id
//		               
//		            })).append($('<td/>',{
//		               align:'center',
//		               text: items.logtime
//		               
//		            })).append($('<td/>',{
//		               align:'center',
//		               text: items.board_hit
//		               
//		            })).appendTo($('#managerReviewboardTable'));
//	
//	
//			}); //each
//			  
//			  $(document).on('click', '#item', function(){
//
//	               var seq = $(this).parent().prev().text();
//	               location.href = '/jaju/manager/managerReviewboardView?board_seq='+seq+'&pg=1';
//
///	         });
//
//			
//				$('#pagingArea').html(data.reviewboardPaging.pagingHTML);		   
//			
//		}, error: function(err){
//			console.log(err);
//			alert('검색 리스트 생성 오류');
//			
//		}
//	});
//
//	return false;
//	}
//});

//전체 선택 또는 해제
//$('#all').click(function(){
//	
//	if($('#all').prop('checked')) {
//		$('input[name=check]').prop('checked', true);	
//	}else{
//		$('input[name=check]').prop('checked', false);
//	}
//
//});

//선택 삭제
//$('#choiceDeleteBtn').click(function(){
//	var count = $('input[name=check]:checked').length; //체크된 개수가 나온다
//	
//	if(count == 0){
//		alert("삭제할 게시물을 선택해주세요");
//	}else{
//		if(confirm("정말로 삭제하시겠습니까?")){
//			   $('#managerReviewboardListDelete').attr("action", "/jaju/manager/managerReviewboardListDelete");
//				$('#managerReviewboardListDelete').submit();
//				alert('게시글 삭제 완료');
//		}
//	}
//});

