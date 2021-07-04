//똑같이 블랙리스트 append 즉 상태가 1인 사람들 불러오고, 여기서는 1을 0으로 바꾸기

$(function(){
//창이 열리자 마자 , (활동중지 회원) 정보 가져오기. 
	$.ajax({
		url: '/jaju/manager/getManagerMemberBlack',
		type:'post',
		dataType:'json',
		data: {'pg':  $('#pg').val(), 'sortinSelect': $('#sortinSelect').val()},
				//'pg': $('#pg').val()
		success:function(data){
			$.each(data.list, function(index, items){
				
				//if문 돌려서, member_state 1 은 활동정지, 2는 강제탈퇴 로 변경해서 넣기 !!!
				
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
			
			$('#memberPagingDiv').html(data.managerPagingBlack.pagingHTML);

		},error:function(err){
			console.log("관리자-회원 쪽 에러발생"+err);
		}		
	});//ajax
});
//리스트에 따라 결과 가져오기
$('#sortinSelect').change(function(){
	
	//console.log($(this).val()); //value값 가져오기
	
	$('#memberListBody tr').remove();
	$.ajax({
		url: '/jaju/manager/getManagerMemberBlack',
		type:'post',
		dataType:'json',
		data: {'pg':  $('#pg').val(), 'sortinSelect': $('#sortinSelect').val()},
				//'pg': $('#pg').val()
		success:function(data){
			
			if(JSON.stringify(data.list)=='[]'){ 
	    		 alert("찾는 내용이 없습니다.");
		    	 $('#memberListBody tr').remove();

	    		 $('<tr/>').append($('<td/>',{
	    			 	colspan:8,
						align:'center',
						text:'강제탈퇴 된 회원이 없습니다.',
						style:'bordercolor="#ededed"; width:860px; height:300px;'
					})).appendTo($('#memberListBody'));
	    	}
			else{
				
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
			}//else (each문 밖에 위치)
			$('#memberPagingDiv').html(data.managerPagingBlack.pagingHTML);

		},error:function(err){
			console.log("관리자-회원 쪽 에러발생"+err);
		}		
	});//ajax
});

//활동중지해제 눌렀을 경우
/*==활동중지==*/
$('#btnWithdraw').click(function(){
	var checkboxValues = [];
		$("input[name='check']:checked").each(function(i) {
		checkboxValues.push($(this).val());
	 });
	var count = $('input[name=check]:checked').length;
		//유효성검사
		if(count==0){
			alert("활동 중지를 해지할 아이디를 선택 하세요");
		}
		else {
			if(confirm(checkboxValues+"의 아이디를 활동 중지로 변경 하시겠습니까?")){
				$("#managerMemberBlackForm").attr("action", "/jaju/manager/changeBlackMemberState");
				$('#managerMemberBlackForm').submit();
				alert('변경이 완료 되었습니다.');
				//location.reload();
			}else{
				alert('변경에 실패했습니다. 다시 선택해주세요.');
			}
		}
});
