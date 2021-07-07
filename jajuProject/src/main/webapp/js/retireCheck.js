$(function(){
	$('.sign_up_item a').css('color', '#064acb')
	
	$.ajax({
		url: '/jaju/member/getMember',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data))
			
			$('#member_id').text(data.memberDTO.member_id);

			$('#check_password').click(function(){
				$('#pwdDiv').empty();
				
				if($('#password').val() == ''){
					$('#pwdDiv').css({'color': '#b3130b', 'font-size': '8pt', 'font-weight': 'bold'});
					$('#pwdDiv').html('비밀번호를 입력해주세요');
				}else if($('#password').val() != data.memberDTO.member_pwd){
					$('#pwdDiv').css({'color': '#b3130b', 'font-size': '8pt', 'font-weight': 'bold'});
					$('#pwdDiv').html('비밀번호를 확인해주세요');
				}else {
					$('.btn_group').hide();
					$('.wrap_btn').show();
				}
			});
		},
		error: function(err){
			console.log(err);
		}
	});
});

$('#nextBtn').click(function(){
	$.ajax({
		url: '/jaju/member/retireChk',
		type: 'post',
		success: function(){
			
		},
		error: function(err){
			console.log(err);
		}
	});
	location.href = "/jaju/member/retire"
});