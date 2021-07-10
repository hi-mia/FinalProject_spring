$(function(){
	
	var followId = $('#followId').val();
	//alert($('#followId').val());
	//alert($('#pg').val());
			//가입일,매너온도, 이미지1, 한개더 생각
	$.ajax({
		url:'/jaju/mypage/getMyFollowProfile',
		type:'post',
		data: {
			'followId' : $('#followId').val()
		},
		dataType:'json',
		success:function(data){
			//alert("data? "+data);
			//console.log(JSON.stringify(data));
				//리스트가 null이라면, 
	        	// && data.myRecodePaging2 != null
		
			//var subject = items.sale_subject;
			//console.log(JSON.stringify(data));
			
			$.each(data.list, function(index, items){
				$('<ul/>',{
					class:'list_order'
					}).append($('<li/>')
						.append($('<div/>',{
							class:'date',
						})).append($('<div/>',{
								class:'order_goods'
							})
							.append($('<div/>',{
								class:'order_info'
								
							}).append($('<div>',{
								class:'thumb'
							}).append($('<img/>',{
								src:'/jaju/storage/'+items.member_image, 
								alt:'Profile_img',
								style:'text_align:left;'
							}))).append($('<div/>',{
								class:'desc'
							}).append($('<dl/>')
							.append($('<dt/>',{
								text:'매너온도'
								})).append($('<dd/>',{
									text:items.member_manner.toFixed(1)+'℃'
								}))).append($('<dl/>')
								.append($('<dt/>',{
									text:'주요지역'
								})).append($('<dd/>',{
									text:items.member_sido+' '+items.member_sigungu
								}))).append($('<dl/>')
								.append($('<dt/>',{
									text:'가입일'
								})).append($('<dd/>',{
									text:items.member_date,
									class:'status end'	
								}))
									
								))))).appendTo($('#profileTable'));
				
				
			});// each
			

		},
		error: function(err){
			console.log('Follow_saleList에러발생'+err);
		}
	});
	
	//===============
	
	$.ajax({
		url:'/jaju/mypage/getMyFollowSaleList',
		type:'post',
		data: {
			'followId' : $('#followId').val(),
			'pg' : $('#pg').val()
		},
		dataType:'json',
		success:function(data){
			
			//alert("data? "+data);
			//console.log(JSON.stringify(data));
				//리스트가 null이라면, 

	        	// && data.myRecodePaging2 != null
			
			
			//var subject = items.sale_subject;
			
			//console.log(JSON.stringify(data));
			
			if(JSON.stringify(data.list)=='[]' ){
				$('.title').remove();
				
				$('<tr/>').append($('<td/>',{
					align:'center',
					text:'판매중인 내역이 없습니다.',
					style:'height:250px;'
				})).appendTo($('#myDealRecordTableBottom'));
			}
			
			else {
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
								href:'#',
								text:items.sale_subject,
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
									text:'주문상태'
								})).append($('<dd/>',{
									text:items.sale_state,
									class:'status end'	
								}))
									
								))))).appendTo($('#tabTable'));
				
				$(document).on("click",".subject_"+items.sale_seq,function(){		
					location.href="/jaju/saleboard/saleboardView?sale_seq="+items.sale_seq+"&pg=1";
					});
			});// each
			
			// 페이징처리
			$('#myDealRecodePagingDiv').html(data.getMyFollowSaleListPage.pagingHTML);
			
			}//else

		},
		error: function(err){
			console.log('Follow_saleList에러발생'+err);
		}
	});
});			

				
				

	
	
