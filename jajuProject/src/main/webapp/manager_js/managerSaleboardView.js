//이전글, 다음글
$(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/managerSaleboard/getPage_sale',
		data: {'sale_seq' : $('#sale_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#prevSpan').text(data.saleboardDTO.prev_subject);
			if(data.saleboardDTO.prev_subject != '이전글이 없습니다'){
				$('#prevBtn').attr('href', '/jaju/managerSaleboard/managerSaleboardView?sale_seq='+data.saleboardDTO.prev_num+'&pg=1');
			}
			
			$('#nextSpan').text(data.saleboardDTO.next_subject);
			if(data.saleboardDTO.next_subject != '다음글이 없습니다'){
				$('#nextBtn').attr('href', '/jaju/managerSaleboard/managerSaleboardView?sale_seq='+data.saleboardDTO.next_num+'&pg=1');
			}
			
		},
		error: function(err){
			console.log(err);
		}
	});
});
