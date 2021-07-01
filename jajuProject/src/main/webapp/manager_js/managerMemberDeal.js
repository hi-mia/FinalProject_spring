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
			
			console.log(JSON.stringify(data));
			
			 if(JSON.stringify(data.list)=='[]'){
					
					
					$('<div/>').append($('<div/>',{
						align:'center',
						text:'판 매 중이 없습니다.',
						style:'height:200px;'
					})).appendTo($('#historyDiv4'));
				}
				
	    	  else {
	    		  $.each(data.list, function(index, items){
	    			 $('<div/>').append($('<div/>',{
							align:'center',
							style:'cursor: pointer',
							id:'subject_' 
					}).append($('<a/>',{
						text:items.sale_subject,
						class:'subject_'+items.sale_seq //글제목 부분
					}))).appendTo($('#historyDiv4'));
					
					
	    			 //페이징처리
	    			 $('#memberDealListPageDiv').html(data.myDealPaging.pagingHTML); 
	    		  });//each
	    		  		
	    		  		
	  						
	    	  }//else
		},
		error: function(err){
			console.log('dealList에러발생'+err);
		}
	});
});