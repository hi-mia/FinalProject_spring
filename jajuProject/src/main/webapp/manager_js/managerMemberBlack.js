//똑같이 블랙리스트 append 즉 상태가 1인 사람들 불러오고, 여기서는 1을 0으로 바꾸기

$(function(){
//창이 열리자 마자 , (활동중지 회원) 정보 가져오기. 
	$.ajax({
		url: '/jaju/manager/getManagerMemberBlack',
		type:'post',
		dataType:'json',
		data: {'pg': '1', 'sortinSelect': $('#sortinSelect').val()},
				//'pg': $('#pg').val()
		success:function(data){
			$.each(data.list, function(index, items){
				//console.log(JSON.stringify(data));
				$('<tr/>').append($('<td/>',{
					class:'chk',
				}).append($('<input/>',{
					type:"checkbox",
					name:"check",
					id:"check_id"+items.member_seq,
					value:items.member_id,
					class:"checkradio_styled"
				}))).append($('<td/>').append($('<div/>',{
					class:'table_data'
				}).append($('<a/>',{
					href:'#',
					class:'user_info',
					text:items.member_id
				})))).append($('<td/>',{
					class:'member_email',
					text:items.member_email,
					style:'text-align:center;'
				})).append($('<td/>').append($('<div/>',{
					class:'table_data',
					text:'회원',
					style:'text-align:center;'
				}))).append($('<td/>',{
					class:'signin_date_span',
					text:items.member_date,
					style:'text-align:center;'	
				})).append($('<td/>',{
					class:'member_manner_span',
					text:items.member_manner+'℃',
					style:'text-align:center;'					
				})).append($('<td/>',{
					class:'member_warning_span',
					text:items.member_warning,
					style:'text-align:center;'
				})).append($('<td/>',{
					class:'member_sell_span',
					text:'판매리스트 이동'	
				})).appendTo($('#memberListBody'));
				
				// 전체 선택 또는 해제
				$('#all').click(function(){
				   // alter($('#all').attr('checked'));//checked 속성이 없어서 undefind으로 나온다.
				   // alert($('#all').prop('checked'));//attr이 아니라 값으로 가져와야한다.
				   if($('#all').prop('checked')){
				      $('input[name=check]').prop('checked',true);
				   }else {
				      $('input[name=check]').prop('checked',false);
				   }
				});
			});//each
			
			
			
		},error:function(err){
			console.log("관리자-회원 쪽 에러발생"+err);
		}		
	});//ajax
});
