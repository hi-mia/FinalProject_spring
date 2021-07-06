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
			
			$('#subjectSpan').text(data.reportDTO.report_subject);
			$('#idSapn').text(data.reportDTO.report_id);
			$('#talSpan').text(data.reportDTO.report_tal);
			$('#dateSpan').text(data.reportDTO.logtime);
			$('#contentSpan').text(data.reportDTO.report_content);
			$('#sale_subjectSpan').text(data.reportDTO.sale_subject);
			
			
			$('#sale_seq').val(data.reportDTO.sale_seq);
		
			
			//신고 글 링크
			$('#sale_subject').attr('href', '/jaju/saleboard/saleboardView?sale_seq='+data.reportDTO.sale_seq+'&pg=1');
			
			
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