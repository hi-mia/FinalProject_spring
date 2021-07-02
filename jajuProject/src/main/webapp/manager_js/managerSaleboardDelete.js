$('#managerSaleboardDeleteBtn').click(function(){
	
	$.ajax({
		type: 'post',
		url: '/jaju/managerSaleboard/getManagerSaleboardView',
		data: {'sale_seq': $('#sale_seq').val()},
		dataType: 'json',
		success: function(data){
				if(confirm('정말로 삭제하시겠습니까?')){ 
					$.ajax({
	                type: 'post',
	                url: '/jaju/managerSaleboard/managerSaleboardDelete',
	                data: {'sale_seq': $('#sale_seq').val()},
	                success: function(){
	                   alert('게시글 삭제 완료');
	                   location.href = '/jaju/managerSaleboard/managerSaleboardView?sale_seq='+seq+'&pg=1';
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
