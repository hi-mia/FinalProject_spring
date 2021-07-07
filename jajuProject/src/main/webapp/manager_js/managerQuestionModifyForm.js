//자주 하는 질문 글 불러오기
$(function(){
	$('.image1Name').hide();
	$('.image2Name').hide();
	$('.image3Name').hide();
	//alert($('input[name=question_seq]').val());
	var formData = new FormData($('#managerQuestionModifyForm')[0])
	$.ajax({
		type : 'post',
		url : '/jaju/manager/getManagerQuestionModify',
		data : 'seq='+$('input[name=question_seq]').val(),
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$('#questionType').val(data.questionDTO.questionType).prop('select', true);
			$('#question_subject').val(data.questionDTO.question_subject);
			$('#question_content').val(data.questionDTO.question_content);
			
			if (data.questionDTO.question_image1 != null) {
				$('#image1Name').text(data.questionDTO.question_image1)
				$('#question_image1').val(data.questionDTO.question_image1)
				$('.image1Name').show();
	
			}
			if (data.questionDTO.question_image2 != null) {
				$('#image2Name').text(data.questionDTO.question_image2)
				$('#question_image2').val(data.questionDTO.question_image2)
				$('.image2Name').show();
	
			}

			if (data.questionDTO.question_image3 != null) {
				$('#image3Name').text(data.questionDTO.question_image3)
				$('#question_image3').val(data.questionDTO.question_image3)
				$('.image3Name').show();
				
			}
			
		},
		error : function(err){
			console.log(err);
		}
	});
});

//자주 하는 질문 글 수정하기
$('#questionModifyBtn').click(function(){
	$('#questionTypeDiv').empty();
	$('#question_subjectDiv').empty();
	$('#question_contentDiv').empty();
	
	if($('#questionType').val() == ''){
		$('#questionTypeDiv').text('문의 유형을 선택해 주세요');
		$('#questionTypeDiv').css('color','red');
		$('#questionTypeDiv').css('font-size','8pt');
		$('#questionTypeDiv').css('font-weight','bold');
		
	}else if($('#question_subject').val() == ''){
		$('#question_subjectDiv').text('제목을 입력하세요');
		$('#question_subjectDiv').css('color','red');
		$('#question_subjectDiv').css('font-size','8pt');
		$('#question_subjectDiv').css('font-weight','bold');
		
	}else if($('#question_content').val() == ''){
		$('#question_contentDiv').text('내용을 입력하세요');
		$('#question_contentDiv').css('color','red');
		$('#question_contentDiv').css('font-size','8pt');
		$('#question_contentDiv').css('font-weight','bold');
	}else{
		var formData = new FormData($('#managerQuestionModifyForm')[0])
		$.ajax({
			type : 'post',
			url : '/jaju/manager/managerQuestionModify',
			enctype : 'multipart/form-data',
			processData : false,
			contentType : false,
			data : formData,
			success : function(data){
				alert("수정이 완료되었습니다");
				location.href = '/jaju/manager/managerServiceQuestion';
			},
			error : function(err){
				console.log(err);
			}
		});
	}
});