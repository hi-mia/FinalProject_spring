$(function(){
	$.ajax({
		type: 'post',
		url : '/jaju/mypage/myDealRecodeList',
		// data: 'pg=${pg}', //컨트롤러부터 넘어온 값이고
		data: 
		{
			'pg':$('#pg').val(),
			'id':$('#id').val()
					
		}, // --->hidden의 값을 쓸때
		dataType: 'json',
		success: function(data){
			
			//console.log(JSON.stringify(data));
			
			//data.list.length != 0
			
			 if(JSON.stringify(data.list)=='[]'){
				 	$('.title').remove();
		            $('<tr/>').append($('<td/>',{
		                align:'center',
		                text:'판매 중인 내역이 없습니다.',
		                style:'height:200px;'
		             })).appendTo($('#historyTable'));
			}
			 else {
				 
	    		  $.each(data.list, function(index, items){
	    			  
	    			  $('<tr/>').append($('<td/>').append($('<a/>',{
		                   text:items.sale_subject+' ',
		                   style:'cursor: pointer;font-size: 18px;',
		                   class:'subject_'+items.sale_seq //글제목 부분
		                }))).append($('<td/>').append($('<span/>',{
	                         align:'left',
	                         style:'font-size: 18px;',
	                         id:'dealDate',
	                         text:items.sale_date
	                   }))).appendTo($('#historyTable'));
					
					
	    			 //페이징처리
	    			 $('#memberDealListPageDiv').html(data.myDealPaging.pagingHTML); 
	    			 $(document).on("click",".subject_"+items.sale_seq,function(){		
	    				 window.opener.location.href="/jaju/saleboard/saleboardView?sale_seq="+items.sale_seq+"&pg=1";
	    				 });
	    		  });//each
	    	  }//else
		},
		error: function(err){
			console.log('dealList에러발생'+err);
		}
	});
});