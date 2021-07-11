$(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getNotice',
		data: {'notice_seq' : $('#notice_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			$('#notice_subject').val(data.noticeDTO.notice_subject);
			$('#notice_content').val(data.noticeDTO.notice_content);
			
			
		},error: function(err){
			console.log(err);
			alert('노티스 불러오기 에러');
		}
	});
	
	
});


$('#noticeModifyBtn').click(function(){
	
	$('#notice_subjectDiv').empty();
	$('#notice_contentDiv').empty();
	
	if($('#notice_subject').val() == ''){
        $('#notice_subjectDiv').text('제목을 입력하세요');
        $('#notice_subjectDiv').css('color', 'red');
        $('#notice_subjectDiv').css('font-size', '10pt');
        $('#notice_subjectDiv').css('font-weight', 'bold');
	}else if($('#notice_content').val() == ''){
		$('#notice_contentDiv').text('내용을 입력하세요');
		$('#notice_contentDiv').css('color', 'red');
		$('#notice_contentDiv').css('font-size', '10pt');
		$('#notice_contentDiv').css('font-weight', 'bold');
	}else{
	
		var formData = new FormData($('#noticeWriteForm')[0]);
		$.ajax({
			type: 'post',
			url: '/jaju/manager/setNoticeModify',
			enctype: 'multipart/form-data',
			processData: false,
			contentType: false,
		 	data: formData,
			success: function(data){
				//alert(JSON.stringify(data));
				alert('수정을 완료했습니다.');
				
				location.href = '/jaju/manager/managerNoticeList';
				
			},error: function(err){
				console.log(err);
				alert('노티스 불러오기 에러');
			}
		});
	}
});


