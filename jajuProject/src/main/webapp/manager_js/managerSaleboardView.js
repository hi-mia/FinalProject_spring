
//이전글, 다음글
$(function(){
	
		$.ajax({
			type: 'post',
			url: '/jaju/saleboard/getSaleboardViewReview',
			data: {'sale_seq': $('#sale_seq').val()},
			dataType: 'json',
			success: function(data){
				//alert(JSON.stringify(data));
	
			$('#subjectSpan').text(data.saleboardDTO.sale_subject);
			$('#idSpan').text(data.saleboardDTO.member_id);
			$('#dateSpan').text(data.saleboardDTO.sale_date);
			$('#hitSpan').text(data.saleboardDTO.sale_hit);
			let map = new Map();
			
			map.set("image1", data.saleboardDTO.sale_image1);
			map.set("image2", data.saleboardDTO.sale_image2);
			map.set("image3", data.saleboardDTO.sale_image3+'');
			map.set("image4", data.saleboardDTO.sale_image4+'');
			map.set("image5", data.saleboardDTO.sale_image5+'');
			map.set("image6", data.saleboardDTO.sale_image6+'');
			map.set("image7", data.saleboardDTO.sale_image7+'');
			map.set("image8", data.saleboardDTO.sale_image8+'');
			map.set("image9", data.saleboardDTO.sale_image9+'');
			map.set("image10", data.saleboardDTO.sale_image10+'');
			
			
			for(var i=1; i<=10; i++){
				if(map.get('image'+i) != 'null'){
					$('#imageDiv').append($('<img/>',{
						class:"miniImg",
						src: '/jaju/storage/'+map.get('image'+i),
						id: map.get('image'+i),
						style: 'cursor : pointer; width : 50px; height:50px;'
					}));
				}
			}
			$('#imageTd').append($('<img/>',{
				width:"200",
				height:"200",
				class:"miniImg",
				src: '/jaju/storage/'+map.get('image1'),
				
			}));
			$(document).on('click', '.miniImg', function(){				
				$('#imageTd img').attr('src', $(this).attr('src'));
			});
			
			$('#locationSpan').text(data.saleboardDTO.member_sido+ " "+ data.saleboardDTO.member_sigungu);
			$('#linkSpan').html('<a id="linkA" href="/jaju/saleboard/saleboardView?sale_seq='+$('#sale_seq').val()+'&pg=1">' + '/jaju/saleboard/saleboardView?sale_seq='+$('#sale_seq').val()+'&pg=1</a>');
			$('#contentSpan').text(data.saleboardDTO.sale_content);
			
			//댓글 불러오기
			$.ajax({
				type: 'post',
				url: '/jaju/saleboard/getSaleboardComment',
				data: {'sale_seq': $('#sale_seq').val(), 'pg': $('#pg').val()},
				dataType: 'json',
				success: function(data){
					//alert(JSON.stringify(data));
					
					$('#commentTable tr:gt(0)').remove();
					
					$.each(data.list, function(index,items){
						
						$('<tr/>').append($('<td/>',{
							text : items.comment_seq,
							style:'text-align:center;'
						})).append($('<td/>',{
							style : 'text-align: center;'
							
							}).append($('<a/>',{
								text : items.comment_content,
								id: 'subjectA',
								style:'text-align:center;',
								class: 'content_'+ items.comment_seq
							}))
						).append($('<td/>',{
							text : items.member_id,
							style:'text-align:center;'

						})).append($('<td/>',{
							class: 'trLast'+items.comment_seq,
							text : items.logtime,
							style:'text-align:center;'
						})).appendTo($('#commentTable'));
						
						for(var i=1; i<items.comment_lev; i++){
							$('.content_'+items.comment_seq).before('&emsp;');
						}
						if(items.comment_pseq != 0 ){
							$('.content_'+items.comment_seq).before($('<img>',{
								src: '/jaju/jajuImage/reply.gif'
							}));
						}
						
						$('.trLast'+items.comment_seq).append($('<img>',{
							src: '/jaju/jajuImage/delete.png',
							id: 'commentDeleteBtn',
							style: 'cursor: pointer; float: right;',
							width: '20px',
							height: '20px'
						}));
					}); //each
					
					
					$('#pagingDiv').html(data.saleboardCommentPaging.pagingHTML);
					
					$.ajax({
						type: 'post',
						url: '/jaju/managerSaleboard/getPage_sale',
						data: {'sale_seq' : $('#sale_seq').val(), 'sale_category' : $('#sale_category').val()},
						dataType: 'json',
						success: function(data){
							//alert(JSON.stringify(data));
							

							$('#prevSpan').text(data.saleboardDTO.prev_subject);
							if(data.saleboardDTO.prev_subject != '이전글이 없습니다'){
								$('#prevBtn').attr('href', '/jaju/managerSaleboard/managerSaleboardView?sale_seq='+data.saleboardDTO.prev_num+'&pg=1'+'&sale_category='+$('#sale_category').val());
							}
							
							$('#nextSpan').text(data.saleboardDTO.next_subject);
							if(data.saleboardDTO.next_subject != '다음글이 없습니다'){
								$('#nextBtn').attr('href', '/jaju/managerSaleboard/managerSaleboardView?sale_seq='+data.saleboardDTO.next_num+'&pg=1'+'&sale_category='+$('#sale_category').val());
							}
							
						},
						error: function(err){
							console.log(err);
						}
					});
					
					
				},error: function(err){
					alert("댓글 불러오기 에러");
					console.log(err);
				}
			});
			
		},error: function(err){
			console.log(err);
			alert('판매 게시글 불러오기 에러')
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
			url: '/jaju/saleboard/commentDelete',
			data: {'comment_seq': comment_seq},
			success: function(){				
				//댓글 불러오기
				$.ajax({
					type: 'post',
					url: '/jaju/saleboard/getSaleboardComment',
					data: {'sale_seq': $('#sale_seq').val(), 'pg': $('#pg').val()},
					dataType: 'json',
					success: function(data){
						//alert(JSON.stringify(data));
						
						$('#commentTable tr:gt(0)').remove();
						
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
								text : items.member_id
							})).append($('<td/>',{
								class: 'trLast'+items.comment_seq,
								text : items.logtime
							})).appendTo($('#commentTable'));
							
							for(var i=1; i<items.comment_lev; i++){
								$('.content_'+items.comment_seq).before('&emsp;');
							}
							if(items.comment_pseq != 0 ){
								$('.content_'+items.comment_seq).before($('<img>',{
									src: '/jaju/jajuImage/reply.gif'
								}));
							}
							
							$('.trLast'+items.comment_seq).append($('<img>',{
								src: '/jaju/jajuImage/delete.png',
								id: 'commentDeleteBtn',
								style: 'cursor: pointer; float: right;',
								width: '20px',
								height: '20px'
							}));
						}); //each
						
						
						$('#pagingDiv').html(data.saleboardCommentPaging.pagingHTML);
						
						
					},error: function(err){
						alert("댓글 불러오기 에러");
						console.log(err);
					}
				});			
			},error: function(err){
				alert("댓글 삭제 에러");
				console.log(err);
			}
		});
	}
	
});

$('#managerSaleboardDeleteBtn').click(function(){
	
	$.ajax({
		type: 'post',
		url: '/jaju/saleboard/getSaleboardView',
		data: {'sale_seq': $('#sale_seq').val()},
		dataType: 'json',
		success: function(data){
				if(confirm('정말로 삭제하시겠습니까?')){ 
					$.ajax({
	                type: 'post',
	                url: '/jaju/saleboard/saleboardDelete',
	                data: {'sale_seq': $('#sale_seq').val()},
	                success: function(){
	                   alert('게시글 삭제 완료');
	                   //location.href='/jaju/saleboard/saleboardList';
	                   location.href='/jaju/managerSaleboard/managerSaleboardList?pg=1&sale_category=*';
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

