function category(category){
	alert(category)
	
	$.ajax({
		url: '/jaju/main/recommend',
		type: 'post',
		data: {'category': category},
		dataType: 'json',
		success: function(data){
			alert(JSON.stringify(data));
		},
		error: function(err){
			console.log(err);
		}
	});	
}