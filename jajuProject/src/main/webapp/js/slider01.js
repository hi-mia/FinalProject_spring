$(function(){
	$.ajax({
		url: '/jaju/main/slider01',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data))

			$.each(data.list, function(index, items){
				$('#img' + index).prop('src', '/jaju/storage/' + items.sale_image1);
				$('#subject' + index).text(items.sale_subject);
				$('#price' + index).text(items.sale_price);
			})
		},
		error: function(err){
			console.log(err);
		}
	});
});