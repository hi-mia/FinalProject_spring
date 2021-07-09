//리스트
$(function(){
	$.ajax({
		
		type: 'post',
		url: '/jaju/manager/getManagerReviewboardList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
			
			 if(JSON.stringify(data.list)=='[]'){
					
					$('<tr/>').append($('<div/>',{
						align:'center',
						text:'등록된 게시물이 없습니다',
						style:'height:300px; width:800px; line-height:300px;'
					})).appendTo($('#managerReviewboardTable'));
				}
			 else {
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
			  
			  $(document).on('click', '#item', function(){

		               var seq = $(this).parent().prev().text();
		               location.href = '/jaju/manager/managerReviewboardView?review_seq='+seq+'&pg=1';

		         });

			  //페이징 처리
			$('#pagingArea_review').html(data.reviewboardPaging.pagingHTML);	
			 }//else
		}, 
			error:function(err){
			console.log(err);
			alert('error');
		}
	});
});

//function reviewboardPaging(pg){
//	location.href="managerReviewboardList?pg="+pg;
//}

//검색
$('#managerReviewSearchBtn').click(function(){
	//alert($('input[name=pg]').val());
	//alert($('#pg').val());
	//alert('이미지클릭')
	//search_managerReview
	$('#search_managerReview').val($('#keyword').val())
	if($('#keyword').val() == ""){
		alert("검색어를 입력해 주세요");
		$('#keyword').focus();
	}  else{
	
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerReviewboardSearchList',
		data: $('#managerReviewboardSearchList').serialize(),
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#managerReviewboardTable tr:gt(0)').remove();
			
			   if(data.list.length == 0){
				   alert('검색어가 없습니다');
				   location.href = '/jaju/manager/managerReviewboardList?pg=1'
				   
			   }else{
			
			
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
			  
			  $(document).on('click', '#item', function(){

	               var seq = $(this).parent().prev().text();
	               location.href = '/jaju/manager/managerReviewboardView?review_seq='+seq+'&pg=1';

	         });
			   }
				$('#pagingArea_review').html(data.reviewboardPaging.pagingHTML);	   
			
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
	
	if($('#all').prop('checked')) {
		$('input[name=check]').prop('checked', true);	
	}else{
		$('input[name=check]').prop('checked', false);
	}

});

//선택 삭제
$('#choiceDeleteBtn_review').click(function(){
	var count = $('input[name=check]:checked').length; //체크된 개수가 나온다
	
	if(count == 0){
		alert("삭제할 게시물을 선택해주세요");
	}else{
		if(confirm("정말로 삭제하시겠습니까?")){
			   $('#managerReviewboardListDelete').attr("action", "/jaju/manager/managerReviewboardListDelete");
				$('#managerReviewboardListDelete').submit();
				alert('게시글 삭제 완료');
		}
	}
});

