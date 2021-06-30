//리스트
$(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getManagerFreeboardList',
		data: 'pg='+$('#pg').val(),
		dataType: 'json',
		success: function(data){
		
			  $.each(data.list, function(index, items){
		            $('<tr/>').append($('<td/>', {
		            	align: "center"
		            }).append($('<input/>', {
		            	type: 'checkbox',
		            	name: 'check',
		            	value: items.board_seq
		            }))).append($('<td/>',{
		               align:'center',
		               text: items.board_seq
		               
		            })).append($('<td/>',{
			               
		               }).append($('<a/>',{
		            	   style: "cursor:pointer;",
			               text: items.board_subject,
			               id: 'item',
		                  
		               })) 
		            ).append($('<td/>',{
		               align:'center',
		               text: items.board_id
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.logtime
		               
		            })).append($('<td/>',{
		               align:'center',
		               text: items.board_hit
		               
		            })).appendTo($('#managerFreeboardTable'));
	
			}); //each
			  
//			  $(document).on('click', '#item', function(){ //a태그에 아이디 준거 subjectA 그거의 부모 찾고 그 부모의 앞에거를 찾고
//
//		               var seq = $(this).parent().prev().text();
//		               location.href = '/jaju/freeboard/freeboardView?board_seq='+seq+'&pg=1';
//		               //location.href = '/jaju/freeboard/freeboardView?board_seq='+seq+'&pg='+$('#pg').val();
//
//		         });

			  //페이징 처리
			$('#pagingAreaPg').html(data.freeboardPaging.pagingHTML);		   
		}, 
			error:function(err){
			console.log(err);
			alert('error');
		}
	});
});

function freeboardPaging(pg){
	location.href="managerFreeboardList?pg="+pg;
}