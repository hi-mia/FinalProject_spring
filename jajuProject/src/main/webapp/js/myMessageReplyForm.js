/*$(window).on('beforeunload', function(){
    //do something
    return "창을 종료 하시겠습니까?";
});
*/
$(function() {
	//alert('잘넘어왔는지 확인' + $('#seq').val());
	$.ajax({
		url : '/jaju/mypage/myMessageFormLoad',
		type : 'post',
		data : {
			'seq' : $('#seq').val(),
		// 'pg':$('#pg').val()
		},
		async: false,
		dataType : 'json',
		success : function(data) {
			//console.log(data.messageDTO);
			$('#message_reader_span').html(data.messageDTO.message_writer);
			$('#message_reader_span').text($('#message_reader').val());
			$('#message_writer_Span').text($('#message_writer').val());

		$(document).on("click", "#sendBtn", function() {
				if ($('#message_subject').val() == "") {
					alert('제목을 작성해 주세요');
				} else if ($('#message_content_Span').val() == "") {
					alert('내용을 작성해 주세요');
				} else {			
						$.ajax({
							type : 'post',
							url : '/jaju/mypage/replyMyMessage',
							async: false,
							data : {
								'message_reader' : data.messageDTO.message_writer,
								// data.messageDTO.message_writer,
								'message_writer' : $('#id').val(),
								'message_subject' : $('#message_subject').val(),
								'message_content' : $('#message_content_Span').val(),
								'sale_seq' : data.messageDTO.sale_seq
							},
							success : function() {
								alert('메세지가 보내졌습니다');
								//window.location.href = '/jaju/mypage/myMessage?pg=1';
								window.close();
							},
							error : function(err) {
								console.log(err);
								alert('메세지 보내기 에러');
							}
						});
					}
			}); // send btn

		},
		error : function(err) {
			console.log("err발생" + err);
		}
	});// ajax

});// function
