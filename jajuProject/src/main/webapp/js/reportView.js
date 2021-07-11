//view 한사람 글 불러오기
$(function(){
	//alert($('#report_seq').val());
	//alert($('#comment_seq').val());
	$('#type4').addClass('on');
	
	
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
				$('.View3').hide();
				
			}else if(data.reportDTO != null){
				
				
				$('#sale_seq').val(data.reportDTO.sale_seq);
				
				
				//신고 글 링크
				$('#sale_subject').attr('href', '/jaju/saleboard/saleboardView?sale_seq='+data.reportDTO.sale_seq+'&pg=1');
				
				
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
	if(num==1){ //글수정
		document.reportViewForm.method="post";
		document.reportViewForm.action="/jaju/serviceCenter/reportModifyForm";
		document.reportViewForm.submit();

	}else if(num==2){ //글삭제
		if(confirm("정말로 삭제하시겠습니까?")){
		document.reportViewForm.method='post';
		document.reportViewForm.action="/jaju/serviceCenter/reportDelete";
		document.reportViewForm.submit();
		}
	}
}	

$(document).ready(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/serviceCenter/getCommentList',
		data: {'report_seq': $('#report_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			//alert(data.list.length);
			if(data.list.length != 0){
				$('.replyRealTotal').show();
				
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
							
						}))
						
					).appendTo($('.replyList'));
				
				$('#comment_seq').val(items.comment_seq);
			});//each
			//alert($('#comment_seq').val());
				
				
			}
			else if(data.list.length == 0){
				$('.replyRealTotal').hide();
				
			}
		},
	 	error: function(err){
	 		console.log(err);
	 	}
	});
});