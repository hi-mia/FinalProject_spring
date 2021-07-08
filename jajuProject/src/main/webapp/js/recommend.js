$(function(){
	$.ajax({
		url: '/jaju/main/recommend',
		type: 'post',
		data: {'category': 'digital'},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			if(data.list.length != 0){
				$('.no_data').hide();
				
				$.each(data.list, function(index, items){
					$('#r_img' + index).prop('src', '/jaju/storage/' + items.sale_image1);
					$('#r_subject' + index).text(items.sale_subject);
					$('#r_price' + index).text(items.sale_price + '원');
				});
				
				$('.list_goods').show();
			}else{
				$('.list_goods').hide();
				$('.no_data').show();
			}
			
			$('#linkBtn').text('digital 전체보기')
		},
		error: function(err){
			console.log(err);
		}
	});	
});

var cateGory = 'digital';

function category(category){
	cateGory = category;
	$.ajax({
		url: '/jaju/main/recommend',
		type: 'post',
		data: {'category': category},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			if(data.list.length != 0){
				$('.no_data').hide();
				
				$.each(data.list, function(index, items){
					$('#r_img' + index).prop('src', '/jaju/storage/' + items.sale_image1);
					$('#r_subject' + index).text(items.sale_subject);
					$('#r_price' + index).text(items.sale_price + '원');
				});
				
				$('.list_goods').show();
			}else{
				$('.list_goods').hide();
				$('.no_data').show();
			}
			
			$('#linkBtn').text(category + ' 전체보기')
		},
		error: function(err){
			console.log(err);
		}
	});	
};

$('#linkBtn').click(function(){
	//alert("hover 중 한개 선택 했음 그 값은?"+ $(this).children('a').attr('class'));
	location.href = '/jaju/saleboard/saleboardListCategory?pg=1&sortinSelect=sale_date&sale_category=' + cateGory;
});