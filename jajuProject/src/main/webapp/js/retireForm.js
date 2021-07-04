$(function(){
	$('.sign_up_item a').css('color', '#064acb')
});

$('#nextBtn').click(function(){
	if(!$('#idAgree').is(':checked') || !$('#serviceAgree').is(':checked') || !$('#boardAgree').is(':checked')){
		$('#idAgree').focus()
		$('.dimmed_layer').show();
		$('#wrongLayer').show();
	}else {
		location.href = '/jaju/member/retireCheck';
	}
});

$('.btn_comm').click(function(){
	$('.dimmed_layer').hide();
	$('#wrongLayer').hide();
});