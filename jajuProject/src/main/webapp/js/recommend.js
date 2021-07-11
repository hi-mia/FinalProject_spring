var cateGory = 'digital';
var memId = '';
function category(category){
	cateGory = category;
	$.ajax({
		url: '/jaju/main/recommend',
		type: 'post',
		data: {'category': category},
		dataType: 'json',
		success: function(data){
			//console.log(JSON.stringify(data));
			//alert("개수 " + data.list.length);
			if(data.list.length != 0){
				memId = data.memId;
				$('.r_no_data').hide();
				
				$.each(data.list, function(index, items){
					$('#r_a' + index).prop('href', '/jaju/saleboard/saleboardView?sale_seq=' + items.sale_seq + '&pg=1')
					$('#r_img' + index).show();
					$('#r_img' + index).prop('src', '/jaju/storage/' + items.sale_image1);
					$('#r_subject' + index).text(items.sale_subject);
					$('#r_price' + index).text(items.sale_price.toLocaleString() + '원');

				});

				if(data.list.length < 4){
					for(i = data.list.length; i < 4; i++){
						$('#r_a' + i).prop('href', 'javascript: void(0)')
						$('#r_img' + i).hide();
						$('#r_subject' + i).text('');
						$('#r_price' + i).text('');
					}
				}
				
				$('.list_goods').show();
				

				
				
			}else{
				alert('없다')
				$('.list_goods').hide();
				$('.r_no_data').show();
			}
			
			if(category == 'digital'){
				$('#linkBtn').text('디지털/가전 전체보기');		
			}else if(category == 'life'){
				$('#linkBtn').text('생활 전체보기');		
			}else if(category == 'instant_food'){
				$('#linkBtn').text('가공식품 전체보기');		
			}else if(category == 'women_cloth'){
				$('#linkBtn').text('여성의류 전체보기');		
			}else if(category == 'beauty'){
				$('#linkBtn').text('뷰티 / 미용 전체보기');		
			}else if(category == 'furniture'){
				$('#linkBtn').text('가구 / 인테리어 전체보기');		
			}else if(category == 'sport'){
				$('#linkBtn').text('스포츠 / 레저 전체보기');		
			}else if(category == 'men_choth'){
				$('#linkBtn').text('남성 / 패션잡화 전체보기');		
			}else if(category == 'dogCat'){
				$('#linkBtn').text('반려동물용품 전체보기');		
			}else if(category == 'kids'){
				$('#linkBtn').text('유아동 / 유아도서 전체보기');		
			}else if(category == 'womenAcc'){
				$('#linkBtn').text('여성잡화 전체보기');		
			}else if(category == 'game'){
				$('#linkBtn').text('게임 / 취미 전체보기');		
			}else if(category == 'kitchen'){
				$('#linkBtn').text('주방용품 전체보기');		
			}else if(category == 'book'){
				$('#linkBtn').text('도서 / 티켓 / 음반 전체보기');		
			}else if(category == 'else'){
				$('#linkBtn').text('기타 중고물품 전체보기');		
			}
		},
		error: function(err){
			console.log(err);
		}
	});	
};

$(document).on('click', '.thumb_goods', function(){
	if(memId == null){
		alert('먼저 로그인 하세요.');
		return false;
	}
});

$('#linkBtn').click(function(){
	//alert("hover 중 한개 선택 했음 그 값은?"+ $(this).children('a').attr('class'));
	location.href = '/jaju/saleboard/saleboardListCategory?pg=1&sortinSelect=sale_date&sale_category=' + cateGory;
});