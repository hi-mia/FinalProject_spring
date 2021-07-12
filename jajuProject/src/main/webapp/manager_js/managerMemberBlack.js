//똑같이 블랙리스트 append 즉 상태가 1인 사람들 불러오고, 여기서는 1을 0으로 바꾸기

$(function(){
	$('#sortinSelect').val($('#sortinSelected').val()).prop("selected", true);
	$('#managerMemberBlack').addClass('on');
	$('#memberListBody tr').remove();
	$('#memberPagingBlackDiv').hide();
	$('#memberPagingDiv').show();
//창이 열리자 마자 , (활동중지 회원) 정보 가져오기. 
	$.ajax({
		url: '/jaju/manager/getManagerMemberBlack',
		type:'post',
		dataType:'json',
		data: {'pg':  $('#pg').val(), 
			   'sortinSelect': $('#sortinSelect').val()
		},
				//'pg': $('#pg').val() 
		success:function(data){
			
			
			if(JSON.stringify(data.list)=='[]'){
				 $('<tr/>').append($('<td/>',{
	    			 	colspan:8,
						align:'center',
						text:'활동정지 된 회원이 없습니다.',
						style:'bordercolor="#ededed"; width:860px; height:300px;'
					})).appendTo($('#memberListBody'));
			}else{
			
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
					text:items.member_manner.toFixed(1)+'℃',
					style:'text-align:center;'					
				})).append($('<td/>',{
					class:'member_warning_span',
					text:items.member_warning,
					style:'text-align:center;'
				})).append($('<td/>',{
					class:'member_sell_span'+items.member_id,
					text:'판매리스트 이동',
					style:'cursor:pointer;'	
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
				
				$('.member_sell_span'+items.member_id).click(function(){
		               
					var popupWidth=540;
		               var popupHeight=660;

		               var popupX = (window.screen.width/2)-(popupWidth/2);
		               // 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

		               var popupY= (window.screen.height/2)-(popupHeight/2);
		               // 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음
		               
		               window.open("/jaju/manager/managerMemberHistory?id="+items.member_id, 
		                        "managerMemberHistory", 
		                        'status=no, scroll=no,  height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY); 
		         });//member_sell span click
				
			});//each
			
			$('#memberPagingDiv').html(data.managerPagingBlack.pagingHTML);
		}//else
		
		},error:function(err){
			console.log("관리자-회원 쪽 에러발생"+err);
		}		
	});//ajax
});
//리스트에 따라 결과 가져오기
$('#sortinSelect').change(function(){
	$('#memberPagingBlackDiv').hide();
	$('#memberPagingDiv').show();
	$('#memberListBody tr').remove();
	
	if($(this).val()=='delete_member'){
		$("#again_member_id").hide();
		$("#btnWithdraw").hide();
	}else{
		$("#again_member_id").show();
		$("#btnWithdraw").show();
	}
	//console.log($(this).val()); //value값 가져오기
	
	
	$.ajax({
		url: '/jaju/manager/getManagerMemberBlack',
		type:'post',
		dataType:'json',
		data: {'pg':  $('#pg').val(), 'sortinSelect': $('#sortinSelect').val(),
		},
				//'pg': $('#pg').val()
		success:function(data){
			
			if(JSON.stringify(data.list)=='[]'){
				$('#memberPagingDiv').hide();
				if($('#sortinSelect').val()=='delete_member'){
					$("#again_member_id").hide();
					$("#btnWithdraw").hide();
					$('#memberListBody tr').remove();
					 $('<tr/>').append($('<td/>',{
		    			 	colspan:8,
							align:'center',
							text:'강제탈퇴 된 회원이 없습니다.',
							style:'bordercolor="#ededed"; width:860px; height:300px;'
						})).appendTo($('#memberListBody'));
				}else{
					$("#again_member_id").show();
					$("#btnWithdraw").show();
					 //alert("찾는 내용이 없습니다.");
					 $('#memberListBody tr').remove();
					 $('<tr/>').append($('<td/>',{
		    			 	colspan:8,
							align:'center',
							text:'활동정지 된 회원이 없습니다.',
							style:'bordercolor="#ededed"; width:860px; height:300px;'
						})).appendTo($('#memberListBody'));
			    	 //$('#memberListBody tr').remove();
				}
				
	    		

	    		
	    	}else{
	    		$('#memberPagingDiv').show();
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
					class:'member_sell_span'+items.member_id,
					text:'판매리스트 이동',
					style:'cursor:pointer;'	
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
				
				$('.member_sell_span'+items.member_id).click(function(){
		               
					var popupWidth=540;
		               var popupHeight=660;

		               var popupX = (window.screen.width/2)-(popupWidth/2);
		               // 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

		               var popupY= (window.screen.height/2)-(popupHeight/2);
		               // 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음
		               
		               window.open("/jaju/manager/managerMemberHistory?id="+items.member_id, 
		                        "managerMemberHistory", 
		                        'status=no, scroll=no,  height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY); 
		         });//member_sell span click	
				
			});//each
			
			$('#memberPagingDiv').html(data.managerPagingBlack.pagingHTML);
			}//else (each문 밖에 위치)

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
			if(confirm(checkboxValues+"의 아이디의 활동중지상태를 해제 하시겠습니까?")){
				$("#managerMemberBlackForm").attr("action", "/jaju/manager/changeBlackMemberStateRollback");
				$('#managerMemberBlackForm').submit();
				alert('변경이 완료 되었습니다.');
				//location.reload();
			}else{
				alert('변경에 실패했습니다. 다시 선택해주세요.');
			}
		}
});

/*==검색==*/
$('#search-text_Btn').click(function(){
	$('#memberListBody tr').remove();
	$('#memberPagingBlackDiv').show();
	$('#memberPagingDiv').hide();
	
	if($('#search-text').val() == ""){
		alert("검색어를 입력해 주세요");
		$('#search-text').focus();
	}else{
		$.ajax({
			url: '/jaju/manager/getSearchManagerMemberBlack',
			type:'post',
			dataType:'json',
			data: {'pg':  $('#pg').val(), 
					'sortinSelect': $('#sortinSelect').val(),//==sortinSelect
					'searchMode': $('#searchMode').val(), 
					'search-text' : $('#search-text').val() //==searchText
					//'pg': $('#pg').val()
			},
			success:function(data){
				
				if(JSON.stringify(data.list)=='[]'){
					if($('#sortinSelect').val()=='delete_member'){
						$("#again_member_id").hide();
						$("#btnWithdraw").hide();
						$('#memberListBody tr').remove();
						 $('<tr/>').append($('<td/>',{
			    			 	colspan:8,
								align:'center',
								text:$('#search-text').val()+'에 대한 검색결과가 없습니다.',
								style:'bordercolor="#ededed"; width:860px; height:300px;'
							})).appendTo($('#memberListBody'));
					}else{
						$("#again_member_id").show();
						$("#btnWithdraw").show();
						 //alert("찾는 내용이 없습니다.");
						 $('#memberListBody tr').remove();
						 $('<tr/>').append($('<td/>',{
			    			 	colspan:8,
								align:'center',
								text:$('#search-text').val()+'에 대한 검색결과가 없습니다.',
								style:'bordercolor="#ededed"; width:860px; height:300px;'
							})).appendTo($('#memberListBody'));
				    	 //$('#memberListBody tr').remove();
					}
					
		    		

		    		
		    	}else{
					
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
						class:'member_sell_span'+items.member_id,
						text:'판매리스트 이동',
						style:'cursor:pointer;'	
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
					
					$('.member_sell_span'+items.member_id).click(function(){
			               
						var popupWidth=540;
			               var popupHeight=660;

			               var popupX = (window.screen.width/2)-(popupWidth/2);
			               // 만들 팝업창 width 크기의 1/2 만큼 보정값으로 빼주었음

			               var popupY= (window.screen.height/2)-(popupHeight/2);
			               // 만들 팝업창 height 크기의 1/2 만큼 보정값으로 빼주었음
			               
			               window.open("/jaju/manager/managerMemberHistory?id="+items.member_id, 
			                        "managerMemberHistory", 
			                        'status=no, scroll=no,  height=' + popupHeight  + ', width=' + popupWidth  + ', left='+ popupX + ', top='+ popupY); 
			         });//member_sell span click	
					
				});//each
				$('#memberPagingBlackDiv').html(data.managerSearchBlackPaging.pagingHTML);
				}//else (each문 밖에 위치)

			},error:function(err){
				console.log("관리자-Black회원 쪽 에러발생"+err);
			}		
		});//ajax
		
	}
	
	
});
