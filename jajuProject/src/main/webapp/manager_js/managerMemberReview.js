$(function(){
		
	$.ajax({
			
	      //아이디 (아이디는 세션값으로 처리),제목만 받아오기
	      //url:'/jaju/manager/memberReviewList',
			url:'/jaju/mypage/getMyProfileReviewList',
	      type:'post',
	      data:
	      {
	         'id':$('#id').val(),
	         'pg':$('#pg').val(),
	      },
	      dataType:'json',
	      success:function(data){
	         //console.log(data.memberDTO);
	         //성공하면 , 기존 span태그에 붙여주기 
	    	  
	    	 // console.log(JSON.stringify(data));
	    	  
	    	  $('#historyDiv1').empty();
	    	  
	    	 // saleContentSpan
				 if(JSON.stringify(data.list)=='[]'){
					 	$('.title').remove();
			            $('<tr/>').append($('<td/>',{
			                align:'center',
			                text:'판매 후기가 없습니다.',
			                style:'height:200px;'
			             })).appendTo($('#historyTable'));
				}
				
	    	  else {
	    		  $.each(data.list, function(index, items){
	                /*  $('<div/>').append($('<div/>',{
	                      align:'left',
	                      style:'margin-right:40px; cursor: pointer; height:15px; padding:10px;',
	                      id:'subject_' 
	                }).append($('<a/>',{
	                   text:' 제 목: '+items.review_subject+' ',
	                   class:'subject_'+items.review_seq //글제목 부분
	                }).append($('<span/>',{
	                         align:'left',
	                         style:'margin-left:40px;   cursor: pointer;',
	                         id:'reviewDate' ,
	                         text:' 작성일: '+items.review_date
	                   })))).appendTo($('#historyDiv1'));*/
	                 
	    			  //historyTable
					$('<tr/>').append($('<td/>').append($('<span/>',{
		                   text:items.review_subject+' ',
		                   style:'cursor: pointer; font-size:18px;',
		                   align:'left',
		                   class:'subject_'+items.review_seq //글제목 부분
		                }))).append($('<td/>').append($('<span/>',{
	                         align:'left',
	                         style:'font-size:18px;',
	                         id:'reviewDate' ,
	                         text:items.review_date
	                   }))).appendTo($('#historyTable'));
	                  
	                  
	    			 //페이징처리
	    			 $('#memberReviewListPageDiv').html(data.getMyProfileReviewListPage.pagingHTML); 
	    		  
	    			// $('.subject_'+items.review_seq).click(function(){
	    				 $(document).on("click",".subject_"+items.review_seq,function(){		
	    					
	    					 window.opener.location.href="/jaju/reviewboard/reviewboardView?review_seq="+items.review_seq+"&pg=1";
	    					
	    					});
	    		  
	    		  });//each
	       	  }//else
	      },error:function(err){
	         console.log("memberHistory.js error 발생"+err);
	      }

 	});
});