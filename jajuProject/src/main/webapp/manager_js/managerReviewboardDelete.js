$('#managerReviewboardDeleteBtn').click(function(){
	
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerReviewboardView',
		data: {'review_seq': $('#review_seq').val()},
		dataType: 'json',
		success: function(data){
				if(confirm('정말로 삭제하시겠습니까?')){ 
					$.ajax({
	                type: 'post',
	                url: '/jaju/manager/managerReviewboardDelete',
	                data: {'review_seq': $('#review_seq').val()},
	                success: function(){

	            //----매너점수 변경     
	   				$.ajax({
						type: 'post',
						url: '/jaju/reviewboard/getAllReviewboardList',
						data: {'member_id':$('#member_id').val()},
						dataType: 'json',
						success: function(data){
							//alert(JSON.stringify(data));
							
							var review_manner = 36.5
							var count = 1;
							
							$.each(data.list, function(index,items){
								review_manner = review_manner + parseFloat(items.review_manner);
								count = count + 1;
							}); //each
							
							$.ajax({
								type: 'post',
								url: '/jaju/reviewboard/review_mannerModify',
								data: {'member_id':$('#member_id').val(), 'member_manner': review_manner/count},
								dataType: 'json',
								success: function(data){
									
									
								}, error: function(err){
									console.log(err);
									alert('매너점수 변경 에러')
								}
							});
							
						}, error: function(err){
							console.log(err);
							alert('매너점수 변경 에러')
						}
					});
	                   
	                   alert('게시글 삭제 완료');
	                   location.href='/jaju/manager/managerReviewboardList?pg=1';
	                },
	                error:function(err){
	        			console.log(err);
	        		}
	        	});
			} //정말로 삭제하시겠습니까?
		}, error:function(err){
			console.log(err);
		}
	             
	});
	
});
