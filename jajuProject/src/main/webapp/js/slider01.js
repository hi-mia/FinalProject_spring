$(function(){
	$.ajax({
		url: '/jaju/main/slider01',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data))
			
			if(data.list.length != 0){
				$('.s_no_data').hide();
				
				$.each(data.list, function(index, items){
					$('#s_a' + index).prop('href', '/jaju/saleboard/saleboardView?sale_seq=' + items.sale_seq + '&pg=1');
					$('#s_img' + index).prop('src', '/jaju/storage/' + items.sale_image1);
					$('#s_subject' + index).text(items.sale_subject);
					$('#s_price' + index).text(items.sale_price);
				});
				
				$('.list_goods').show();
				
				$('.s_a').click(function(){
					if(data.memId == null){
						alert('먼저 로그인 하세요.');
						return false;
					}
				});
			}else{
				$('#slider-div').hide();
				$('.s_no_data').show();
			}
		},
		error: function(err){
			console.log(err);
		}
	});
});