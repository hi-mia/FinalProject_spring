$(function(){
	
	$.ajax({
		type: 'post',
		url : '/jaju/mypage/myBuyRecodeList',
		//data: 'pg=${pg}', //컨트롤러부터 넘어온 값이고 
		data: 
		{
			'pg':$('#pg').val(),
			'id':$('#id').val()
		},  // --->hidden의 값을 쓸때
		dataType: 'json',
		async:false,
		success: function(data){
			
			//console.log(JSON.stringify(data));
			
			if(JSON.stringify(data.list)=='[]' && data.myBuyPaging != null){
				
				$('.title').remove();
				
				$('<tr/>',{style:'height:250px;'}).append($('<td/>',{
					align:'center',
					text:'구매한 내역이 없습니다.',
					style:'height:250px;'
				})).appendTo($('#myBuyRecordTable'));
			}
			else{
			
			$.each(data.list, function(index, items){
				//console.log(items.review_seq);
				
				
				$('<ul/>',{
					class:'list_order'
					}).append($('<li/>')
						.append($('<div/>',{
							class:'date',
						})).append($('<div/>',{
								class:'order_goods'
							}).append($('<div/>',{
								class:'deal_name'
							}).append($('<a/>',{
								href:'#',text:items.sale_subject,
								class:'subject_'+items.sale_seq //글제목 부분
							}))
							).append($('<div/>',{
								class:'order_info'
								
							}).append($('<div>',{
								class:'thumb'
							}).append($('<img/>',{
								src:'/jaju/storage/'+items.sale_image1, alt:'img',
								style:'text_align:left;'
							}))).append($('<div/>',{
								class:'desc'
							}).append($('<dl/>')
							.append($('<dt/>',{
								text:'가격'
								})).append($('<dd/>',{
									text:items.sale_price.toLocaleString()+'원'
								}))).append($('<dl/>')
								.append($('<dt/>',{
									text:'날짜'
								})).append($('<dd/>',{
									text:items.sale_date
								}))).append($('<dl/>')
								.append($('<dt/>',{
									text:'주문상태',
								})).append($('<dd/>',{
									text:items.sale_state,
									class:'status end'})).
									append($('<button/>',{
									class:'state_'+items.sale_seq,
									id:"change_state_btn",
									text:' 리뷰작성', 
									style:'height: 30px;width: 90px; background-color: #617aad;color: #fff;border: none;border-radius: 3px; float:right;'	
						}))))))).appendTo($('#tabTable'));
				
				//리뷰 작성 이라는 버튼 누르면 리뷰작성 폼으로 이동한다.. click 이벤트
				$('.state_'+items.sale_seq).click(function(){
					//만약 미경이가 주소 바꾸면, 주소만 바꾸기. 
					location.href='/jaju/reviewboard/reviewboardWriteForm?sale_seq='+items.sale_seq;
				});
				
				
			$(document).on("click",".subject_"+items.sale_seq,function(){		
				location.href="/jaju/saleboard/saleboardView?sale_seq="+items.sale_seq+"&pg=1";
				});
			});//each
			//페이징처리
			$('#myBuyRecodePagingDiv').html(data.myBuyPaging.pagingHTML);
		}//else
	
		},
		error: function(err){
			console.log('buyList에러발생'+err);
		}
	});

	
	$.ajax({
		type: 'post',
		url: '/jaju/mypage/reviewListCheck',
		data: 	{
			'id':$('#id').val()
		}, 
		async:false,
		dataType: 'json',
		success: function(data) { 
			//console.log("id에대한 리뷰리스트"+JSON.stringify(data))

			$.each(data.list, function(index, items){
					
			console.log("보자"+'.state_'+items.sale_seq);
			$('.state_'+items.sale_seq).remove();
			
		});
			
		}, 
		error:function(err){
		console.log(err);
		}
	});
	
});


/*==검색==*/
$('#search-text_Btn').click(function(){
	//$('.mySaleRecordTable$').remove();
	$('.list_order').remove();
	
	//console.log("보여야3-1모드"+$('#searchMode').val())
	//console.log("보여야3-2텍스트"+$('#search-text').val())
	$.ajax({
		type: 'post',
		url : '/jaju/mypage/myBuyRecodeSearchList',
		//data: 'pg=${pg}', //컨트롤러부터 넘어온 값이고 
		async: false,
		data: 		
		{
			'searchMode': $('#searchMode').val(), //==sortinSelect
			'search-text' : $('#search-text').val(), //==searchText
			'pg':$('#searchPg').val(),
			'id':$('#id').val()
		},   // --->hidden의 값을 쓸때
		dataType: 'json',
		success: function(data){
			//console.log(JSON.stringify(data));
			if(JSON.stringify(data.list)=='[]'){
				
				//$('.title').remove();
				$('<tr/>',{
					class:'list_order'
				}).append($('<td/>',{
					align:'center',
					text:$('#search-text').val()+'에 대한 검색결과가 없습니다.',
					style:'height:250px;'
				})).appendTo($('#myBuyRecordTable'));
			}
			else{
				
			$.each(data.list, function(index, items){
					
				$('<ul/>',{
					class:'list_order'
					}).append($('<li/>')
						.append($('<div/>',{
							class:'date',
						})).append($('<div/>',{
								class:'order_goods'
							}).append($('<div/>',{
								class:'deal_name',
							}).append($('<a/>',{
								href:'#',text:items.sale_subject,
								class:'subject_'+items.sale_seq //글제목 부분
							}))
							).append($('<div/>',{
								class:'order_info'
								
							}).append($('<div>',{
								class:'thumb'
							}).append($('<img/>',{
								src:'/jaju/storage/'+items.sale_image1, alt:'img',
								style:'text_align:left;'
							}))).append($('<div/>',{
								class:'desc'
							}).append($('<dl/>')
							.append($('<dt/>',{
								text:'가격'
								})).append($('<dd/>',{
									text:items.sale_price.toLocaleString()+" 원"
								}))).append($('<dl/>')
								.append($('<dt/>',{
									text:'날짜'
								})).append($('<dd/>',{
									text:items.sale_date
								}))).append($('<dl/>')
								.append($('<dt/>',{
									text:'주문상태'
								})).append($('<dd/>',{
									text:items.sale_state,
									class:'status end'	
						}))))))).appendTo($('#tabTable'));
				
			$(document).on("click",".subject_"+items.sale_seq,function(){		
				location.href="/jaju/saleboard/saleboardView?sale_seq="+items.sale_seq+"&pg=1";
				});
			});//each
			
			//페이징처리
			$('#myBuyRecodePagingDiv').html(data.myBuySearchPaging.pagingHTML);
			
			
			}//else

		},
		error: function(err){
			console.log('buyList에러발생'+err);
		}
	});
});
