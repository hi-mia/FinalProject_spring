$(function(){
	$.ajax({
		url: '/jaju/main/board',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			if(data.list.length == 0) {
				$('<tr />').append($('<td />', {
					style : 'padding: 150px 0 148px; border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6; font-size: 14px; color: #4c4c4c; text-align: center; margin-bottom: 20px;',
					colspan: '5',
					text : '게시글이 존재하지 않습니다.'
				})).appendTo($('#boardTable'));
			}else{
				$.each(data.list, function(index, items){
					$('<tr />', {
						style : 'border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6;'
					}).append($('<td />',{
						style: 'padding: 5px 0;',
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
					if(data.memId == null){
						alert('먼저 로그인 하세요.')
					}else{
						var seq = $(this).parent().prev().text();
						
						location.href = '/jaju/freeboard/freeboardView?board_seq=' + seq + '&pg=1';
					}
				});
			}
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#b_linkBtn').click(function(){
	location.href = '/jaju/freeboard/freeboardList?pg=1';
});