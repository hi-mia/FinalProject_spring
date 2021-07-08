$(function(){
	$.ajax({
		url: '/jaju/main/board',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<tr />').append($('<td />',{
					align : 'center',
					text : items.board_seq
				})).append($('<td />',{
					
				}).append($('<a />',{
					style : 'cursor:pointer;',
					id : 'b_subject',
					text : items.board_subject 
				}))).append($('<td />',{
					align : 'center',
					text : items.board_id
				})).append($('<td />',{
					align : 'center',
					text : items.logtime
				})).append($('<td />',{
					align : 'center',
					text : items.board_hit
				})).appendTo($('#boardTable'));
				
			});
			
			$(document).on('click', '#b_subject', function(){
				var seq = $(this).parent().prev().text();
				
				location.href = '/jaju/freeboard/freeboardView?board_seq=' + seq + '&pg=1';
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#b_linkBtn').click(function(){
	location.href = '/jaju/freeboard/freeboardList?pg=1';
});