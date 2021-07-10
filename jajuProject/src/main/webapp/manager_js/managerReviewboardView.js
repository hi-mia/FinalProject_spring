$(function(){
	//alert($('#review_seq').val())
	
	$.ajax({
		type:'post',
		url: '/jaju/manager/getManagerReviewboardView', //한 사람거 가져와서 getBoard 가져옴
		data: {'review_seq': $('#review_seq').val(),
			'sale_seq': $('#sale_seq').val()},
		dataType:'json',
		success:function(data){
//			alert(JSON.stringify(data))
			$('#member_id').val(data.reviewboardDTO.member_id);
			
			$('#subjectSpan').text(data.reviewboardDTO.review_subject);
			$('#idSpan').text(data.reviewboardDTO.review_id);
			$('#dateSpan').text(data.reviewboardDTO.review_date);
			$('#hitSpan').text(data.reviewboardDTO.review_hit);
			//평점
			//$('#mannerSpan').text(data.reviewboardDTO.review_manner);
			if(data.reviewboardDTO.review_manner<=21.5){
				$('#mannerSpan').text('★☆☆☆☆');
			}
			else if(data.reviewboardDTO.review_manner<=29){
				$('#mannerSpan').text('★★☆☆☆');
			}
			else if(data.reviewboardDTO.review_manner<=36.5){
				$('#mannerSpan').text('★★★☆☆');
			}
			else if(data.reviewboardDTO.review_manner<=44){
				$('#mannerSpan').text('★★★★☆');
			}
			else if(data.reviewboardDTO.review_manner<=51.5){
				$('#mannerSpan').text('★★★★★');
			}
			
			
			//구매상품 사진 + 글제목
			$('#sale_subjectSpan').text(data.reviewboardDTO.sale_subject);
			$('#image1').attr('src', '/jaju/storage/'+data.reviewboardDTO.sale_image1);
			//판매자id
			$('#member_idSpan').text(data.reviewboardDTO.member_id);
			$('#contentSpan').text(data.reviewboardDTO.review_content);
			
			//이미지 맵
			let map = new Map();
		
			map.set("image1", data.reviewboardDTO.review_image1+'');
			map.set("image2", data.reviewboardDTO.review_image2+'');
			map.set("image3", data.reviewboardDTO.review_image3+''); //null값 방지
			
			for(var i=1; i<=3; i++){
				if(map.get('image'+i) != 'null'){
					$('#imageDiv').append($('<img/>',{
						width:"300",
						height:"300",
						class:"review_boardImg",
						src: '/jaju/storage/'+map.get('image'+i)
					}));
				}
			}
			
			//로그인 한다면
			//if(data.memId == data.boardDTO.id)
			//	$('#reviewboardViewSpan').show();
			//else
			//	$('#reviewboardViewSpan').hide();
		},
		error: function(err){
			console.log(err);
		}
	});
});

//이전글
$(function(){
	$.ajax({
		type: 'post',
		url: '/jaju/manager/getPage_review',
		data: {'review_seq' : $('#review_seq').val()},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#prevSpan').text(data.reviewboardDTO.prev_subject);
			if(data.reviewboardDTO.prev_subject != '이전글이 없습니다'){
				$('#prevBtn').attr('href', '/jaju/manager/managerReviewboardView?review_seq='+data.reviewboardDTO.prev_num+'&pg=1');
			}
			
			$('#nextSpan').text(data.reviewboardDTO.next_subject);
			if(data.reviewboardDTO.next_subject != '다음글이 없습니다'){
				$('#nextBtn').attr('href', '/jaju/manager/managerReviewboardView?review_seq='+data.reviewboardDTO.next_num+'&pg=1');
			}

		},
		error: function(err){
			console.log(err);
		}
	});
});
