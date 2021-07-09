$('#boardDelete').click(function(){
	
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerFreeboardView',
		data: {'board_seq': $('#board_seq').val()},
		dataType: 'json',
		success: function(data){
				if(confirm('정말로 삭제하시겠습니까?')){ 
					$.ajax({
	                type: 'post',
	                url: '/jaju/manager/managerFreeboardDelete',
	                data: {'board_seq': $('#board_seq').val()},
	                success: function(){
	                   alert('게시글 삭제 완료');
	                   location.href='/jaju/manager/managerFreeboardList?pg=1';
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
