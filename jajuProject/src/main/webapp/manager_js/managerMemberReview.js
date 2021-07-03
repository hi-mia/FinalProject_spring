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
	    	  
	    	  console.log(JSON.stringify(data));
	    	  
	    	  $('#historyDiv1').empty();
	    	  
	    	 // saleContentSpan
	         
	    	  if(JSON.stringify(data.list)=='[]'){
					
					
					$('<div/>').append($('<div/>',{
						align:'center',
						text:'판매 후기가 없습니다.',
						style:'height:200px;'
					})).appendTo($('#historyDiv1'));
				}
				
	    	  else {
	    		  $.each(data.list, function(index, items){
	                  $('<div/>').append($('<div/>',{
	                      align:'center',
	                      style:'margin-right:40px; cursor: pointer; height:15px; padding:10px;',
	                      id:'subject_' 
	                }).append($('<a/>',{
	                   text:' 제 목: '+items.review_subject+' ',
	                   class:'subject_'+items.review_seq, //글제목 부분
	                   style:'cursor: pointer;'
	                }).append($('<span/>',{
	                         align:'center',
	                         style:'margin-left:40px;   cursor: pointer;',
	                         id:'reviewDate' ,
	                         text:' 작성일: '+items.review_date
	                   })))).appendTo($('#historyDiv1'));
					
	    			 //페이징처리
	    			 $('#memberReviewListPageDiv').html(data.getMyProfileReviewListPage.pagingHTML); 
	    		  });//each
	       	  }//else
	      },error:function(err){
	         console.log("memberHistory.js error 발생"+err);
	      }

 	});
});