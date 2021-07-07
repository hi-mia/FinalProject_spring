function mode(num){
	if(num == 1){
		document.managerQuestionView.method="post";
		document.managerQuestionView.action="/jaju/manager/managerQuestionModifyForm";
		document.managerQuestionView.submit();
	}
}

$(function(){
	$.ajax({
		type : 'post',
		url : '/jaju/manager/getManagerQuestionView',
		data : 'seq='+$('input[name=seq]').val(),
		dataType : 'json',
		success : function(data){
			//alert(JSON.stringify(data));
			
			$('#question_subject').text(data.questionDTO.question_subject);
			$('#question_contents').text(data.questionDTO.question_content);
			
			if(data.questionDTO.question_image1 != null){
				$('#question_image1').attr('src','/jaju/storage/'+data.questionDTO.question_image1);
				$('#question_image1').css({'width': '150px', 'height': '150px'});
			}
			if(data.questionDTO.question_image2 != null){
				$('#question_image2').attr('src','/jaju/storage/'+data.questionDTO.question_image2);
				$('#question_image2').css({'width': '150px', 'height': '150px'});
			}
			if(data.questionDTO.question_image3 != null){
				$('#question_image3').attr('src','/jaju/storage/'+data.questionDTO.question_image3);
				$('#question_image3').css({'width': '150px', 'height': '150px'});
			}
		},
		error : function(err){
			console.log(err);
		}
	});
});