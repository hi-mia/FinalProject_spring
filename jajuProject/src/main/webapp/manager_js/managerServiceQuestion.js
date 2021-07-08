//자주 하는 질문 리스트 뿌리기
$(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerQuestionList',
		data: 'pg=' + $('#pg').val(),
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data))
	        $.each(data.list, function(index, items){
	            $('<tr/>').append($('<td/>',{
	            	align: 'center'
		            }).append($('<input/>',{
		            	type : 'checkbox',
						id : 'all',
						name : 'check',
						value : items.question_seq
		            }))
	            ).append($('<td/>',{
	            	width: '75px',
	                align: 'center',
	                text: items.question_seq
	            })).append($('<td/>',{
	            	width: '135px',
	            	align: 'center',
	            	text: items.questionType
	            })).append($('<td/>',{
	            	}).append($('<a/>',{
	            		href: '#',
	            		width: '274px',
	            		text: items.question_subject,
	            		class: 'subject'+items.question_seq
		            }))
	            ).appendTo($('.tbl_admin'))

	            //페이징 처리
	            $('.page_admin').html(data.questionPaging.pagingHTML);
	        
	            $('.subject'+items.question_seq).click(function(){
	            	location.href = '/jaju/manager/managerQuestionView?seq='+items.question_seq+'&pg='+$('#pg').val();
	            });
	        }); //each
	      
	        
         
		},
      	error: function(err){
      		console.log(err);
      	}
      
	});
});

//전체 선택 또는 해제
$('#all').click(function(){
	//alert($('#all').attr('checked')); //checked 속성이 없어서 undefind로 나온다. 존재유무
	//alert($('#all').prop('checked')); //true/false 값을 가져온다.
	
	if($('#all').prop('checked')){
		$('input[name=check]').prop('checked',true);
	}else{
		$('input[name=check]').prop('checked',false);
	}
});
//선택 삭제
$('#choiceDeleteBtn').click(function(){
	var count = $('input[name=check]:checked').length;
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		confirm("정말로 삭제 하시겠습니까?");
		$('#managerQuestionDelete').submit();
	}
});
//페이징 이동
function questionPaging(pg){
	location.href = "/jaju/manager/managerServiceQuestion?pg="+pg;
}

