$(function(){
	
	$.ajax({
		
		type:'post',
		url: '/jaju/manager/getManagerFreeboardView', //한 사람거 가져와서 getBoard 가져옴
		data: {'board_seq': $('#board_seq').val()},
		dataType:'json',
		success:function(data){
			//alert(JSON.stringify(data));
			
			$('#subjectSpan').text(data.freeboardDTO.board_subject);
			$('#idSpan').text(data.freeboardDTO.board_id);
			$('#dateSpan').text(data.freeboardDTO.logtime);
			$('#hitSpan').text(data.freeboardDTO.board_hit);
			$('#contentSpan').text(data.freeboardDTO.board_content);
			
			//이미지 맵
			let map = new Map();
			
			map.set("image1", data.freeboardDTO.image1+'');
			map.set("image2", data.freeboardDTO.image2+'');
			map.set("image3", data.freeboardDTO.image3+''); //null값 방지
			
			for(var i=1; i<=3; i++){
				if(map.get('image'+i) != 'null'){
					$('#imageDiv').append($('<img/>',{
						width:"300",
						height:"300",
						class:"boardImg",
						src: '/jaju/storage/'+map.get('image'+i)
					}));
				}
			}
			
		},
		error: function(err){
			console.log(err);
		}
	});
	
	//댓글 불러오기
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerFreeboardComment',
		data: {'board_seq': $('#board_seq').val(), 'pg': $('#pg').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			 if(JSON.stringify(data.list)=='[]'){
				 $('#commentTable tr').remove();
				 
					$('<tr/>').append($('<div/>',{
						align:'center',
						style:'height:10px; width:800px;'
					})).appendTo($('#commentTable'));
				}
			 else {	
			
			$.each(data.list, function(index,items){
				
				$('<tr/>').append($('<td/>',{
					text : items.comment_seq
				})).append($('<td/>',{
					style : 'text-align: left;'
					
					}).append($('<a/>',{
						text : items.comment_content,
						id: 'subjectA',
						class: 'content_'+ items.comment_seq
					}))
				).append($('<td/>',{
					text : items.board_id
				})).append($('<td/>',{
					class: 'trLast',
					text : items.logtime
				})).appendTo($('#commentTable'));
				
				
			}); //each

			$('.trLast').append($('<img>',{
				src: '/jaju/jajuImage/delete.png',
				id: 'commentDeleteBtn',
				style: 'cursor: pointer; float: right;',
				width: '20px',
				height: '20px'
			}));
			
			$('#pagingDiv').html(data.freeboardCommentPaging.pagingHTML);
			 }//else
		},error: function(err){
			alert("댓글 불러오기 에러");
			console.log(err);
		}
	});
	
});

//댓글 삭제 
$(document).on('click', '#commentDeleteBtn', function(){
	var comment_seq = $(this).parent().parent().find('td:first').text();
	//alert(comment_seq);
	
	if(confirm('정말 삭제하시겠습니까?')){
		$.ajax({
			type: 'post',
			url: '/jaju/manager/managerCommentDelete',
			data: {'comment_seq': comment_seq},
			success: function(data){
				
				location.href='/jaju/manager/managerFreeboardView?board_seq='+$('#board_seq').val()+'&pg=1';
				
			},error: function(err){
				alert("댓글 삭제 에러");
				console.log(err);
			}
		});
	}
	
	
});

//이전글, 다음글
$(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getPage',
		data: {'board_seq' : $('#board_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#prevSpan').text(data.freeboardDTO.prev_subject);
			if(data.freeboardDTO.prev_subject != '이전글이 없습니다'){
				$('#prevBtn').attr('href', '/jaju/manager/managerFreeboardView?board_seq='+data.freeboardDTO.prev_num+'&pg=1');
			}
			
			$('#nextSpan').text(data.freeboardDTO.next_subject);
			if(data.freeboardDTO.next_subject != '다음글이 없습니다'){
				$('#nextBtn').attr('href', '/jaju/manager/managerFreeboardView?board_seq='+data.freeboardDTO.next_num+'&pg=1');
			}
			
		},
		error: function(err){
			console.log(err);
		}
	});
});
