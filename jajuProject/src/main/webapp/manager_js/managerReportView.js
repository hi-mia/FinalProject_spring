//view 한사람 글 불러오기
$(function(){
	//alert($('#report_seq').val());
	//alert($('#comment_seq').val());
	$('#managerReport').addClass('on');
	
	
	$.ajax({
		type: 'post',
		url: '/jaju/serviceCenter/getReport',
		data: {'report_seq' : $('#report_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			if(data.reportDTO == null){
			
				$('.View1').hide();
				$('.View2').hide();
				
			}else if(data.reportDTO != null){
			
				$('#sale_seq').val(data.reportDTO.sale_seq);
				$('#sale_id').val(data.reportDTO.sale_id);
			
				
				//신고 글 링크
				$('#sale_subject').attr('href', '/jaju/managerSaleboard/managerSaleboardView?sale_seq='+data.reportDTO.sale_seq+'&pg=1&sale_category=*');
				
				
				$('#subjectSpan').text(data.reportDTO.report_subject);
				$('#idSapn').text(data.reportDTO.report_id);
				$('#talSpan').text(data.reportDTO.report_tal);
				$('#dateSpan').text(data.reportDTO.logtime);
				$('#contentSpan').text(data.reportDTO.report_content);
				$('#sale_subjectSpan').text(data.reportDTO.sale_subject);
	
				
				if(data.reportDTO.report_image1 != null){
					$('#imageSpan1').attr('src','/jaju/storage/'+data.reportDTO.report_image1);
					$('#imageSpan1').css({'width': '150px', 'height': '150px'});
				}
				if(data.reportDTO.report_image2 != null){
					$('#imageSpan2').attr('src','/jaju/storage/'+data.reportDTO.report_image2);
					$('#imageSpan2').css({'width': '150px', 'height': '150px'});
				}
				if(data.reportDTO.report_image3 != null){
					$('#imageSpan3').attr('src','/jaju/storage/'+data.reportDTO.report_image3);
					$('#imageSpan3').css({'width': '150px', 'height': '150px'});
				}
			
			
			}
			
		},
		error: function(err){
			console.log(err);
		}
	});
});

function mode(num, seq){
	
	if(num==1){ //댓글수정 -> 수정할 글 불러오기
		//alert(seq);
		$('.replyList').hide();
		$('.reply').hide();
		$('.replyModify').show();
		
		//var comment_seq = $(this).parent().parent().prev().prev().find('td:frist').attr('id');
		//alert(seq+"=seq");
		
		$(function(){
			$.ajax({
				type: 'post',
				url: '/jaju/manager/getComment',
				data: {'comment_seq':+seq},
				dataType: 'json',
				success: function(data){
					//alert(JSON.stringify(data));
					$('.comment_content').text(data.commentDTO.comment_content);
					
				},
				error: function(err){
			         console.log(err);
			    }
			});
		});
		
	}else if(num==2){ //댓글삭제
		
		if(confirm("정말로 삭제하시겠습니까?")){
			$.ajax({
				type: 'post',
				url: '/jaju/manager/commentDelete',
				data: {'comment_seq':+seq,
					   'report_seq': $('#report_seq').val(),//이부분 아니래
		 		       'comment_content': $('#comment_content').val()},
		 		success: function(data){
					alert('댓글 삭제가 완료되었습니다');
					location.href='/jaju/manager/managerReportView?report_seq='+$('#report_seq').val()+'&pg='+$('#pg').val();
		 		},
				error: function(err){
					console.log(err);
					alert('댓글 삭제에 실패하였습니다');
				}
			});
		}
	}	
}

//댓글 수정
$('.reportBtn.comReWrite').click(function(){		
	$('.commentDiv').empty();
	//alert($('.comment_content').val());
	
	if($('.comment_content').val() == ''){
		$('.commentDiv').text('내용을 입력하세요');
		$('.commentDiv').css('color', 'red');
	    $('.commentDiv').css('font-size', '10pt');
	    $('.commentDiv').css('font-weight', 'bold');
	}else{
		if(confirm("정말로 수정하시겠습니까?")){
			$.ajax({
				type: 'post',
				url: '/jaju/manager/commentModify',
				data: {'comment_seq': $('#comment_seq').val(),
		 		       'comment_content': $('.comment_content').val()},
		 		success: function(data){
					alert('댓글 수정이 완료되었습니다');
					location.href='/jaju/manager/managerReportView?report_seq='+$('#report_seq').val()+'&pg='+$('#pg').val();
		 		},
				error: function(err){
					console.log(err);
					alert('댓글 수정에 실패하였습니다');
				}
			});
		}
	}

});


//view에 댓글목록 뿌리기
$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getCommentList',
		data: {'report_seq': $('#report_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			//alert(data.list.length);
			if(data.list.length != 0){
				$('.replyList').show();
				$('.reply').hide();
				$('.replyModify').hide();
				
				$.each(data.list, function(index, items){
					$('<tr/>').append($('<td/>',{
						text: items.comment_content,
						class: 'contnet',
						id: items.comment_seq
					})).append($('<tr/>',{
						
						}).append($('<td/>',{
							style:'text-align: right; border-top: 1px solid #333;',
							text: items.logtime,
							class: 'date',
						}))
					).append($('<tr/>',{
						
						}).append($('<td/>',{
							style:'margin-top:10px; margin-bottom: 10px;',
							align: 'right',
							}).append($('<a/>',{
								href: 'javascript:void(0)',
								onclick: 'mode(1,'+items.comment_seq+')',
								
								}).append($('<span/>',{
									style:'float: none;',
									class: 'reportBtn comModify',
									text: '수정',
							}))
							).append($('<a/>',{
								href: 'javascript:void(0)',
								onclick: 'mode(2,'+items.comment_seq+')',
								
								}).append($('<span/>',{
									style:'float: none;',
									class: 'reportBtn comDelete',
									text: '삭제',
						}))))
						
					).appendTo($('.replyList'));
				
				$('#comment_seq').val(items.comment_seq);
			});//each
			//alert($('#comment_seq').val());
				
				
			}
			
			else if(data.list.length == 0){
				$('.replyList').hide();
				$('.reply').show();
				$('.replyModify').hide();
				
			}
		},
	 	error: function(err){
	 		console.log(err);
	 	}
	});
});

//신고글 보이기
$('.reportBtn.show').click(function(){

	$('#commentDiv').empty();
	
	if($('#comment_content').val() == ''){
		$('#commentDiv').text('내용을 입력하세요');
		$('#commentDiv').css('color', 'red');
        $('#commentDiv').css('font-size', '10pt');
        $('#commentDiv').css('font-weight', 'bold');
	}else{
		
		if(confirm("정말로 등록하시겠습니까? (신고글 보이기)")){
			
			$.ajax({
				type: 'post',
				url: '/jaju/manager/commentWriteShow',
				data: {'report_seq': $('#report_seq').val(),
					   'sale_seq': $('#sale_seq').val(),
					   'comment_content': $('#comment_content').val()},
				success: function(data){
					
					alert('댓글 작성이 완료되었습니다');
					location.href='/jaju/manager/managerReportView?report_seq='+$('#report_seq').val()+'&pg='+$('#pg').val();
				},
				error: function(err){
			 		console.log(err);
			 	}
			});
		}
	}
	
});

//신고글 숨기기 -> 삭제
$('.reportBtn.hide').click(function(){
	
	$('#commentDiv').empty();
	
	if($('#comment_content').val() == ''){
		$('#commentDiv').text('내용을 입력하세요');
		$('#commentDiv').css('color', 'red');
        $('#commentDiv').css('font-size', '10pt');
        $('#commentDiv').css('font-weight', 'bold');
	}else{
		if(confirm("정말로 등록하시겠습니까? (신고글 삭제)")){
			$.ajax({
				type: 'post',
				url: '/jaju/manager/commentWriteHide',
				data: {'report_seq': $('#report_seq').val(),
					   'sale_seq': $('#sale_seq').val(),
					   'sale_id': $('#sale_id').val(),
					   'comment_content': $('#comment_content').val()},
				success: function(data){
					alert('신고글이 삭제되었습니다');
					location.href='/jaju/manager/managerReportList;'
				},
				error: function(err){
			 		console.log(err);
			 	}
			});
		}
	}
});