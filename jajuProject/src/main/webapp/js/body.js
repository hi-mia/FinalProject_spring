$(function(){
	$.ajax({
		url: '/jaju/main/board',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			 
			if(data.list.length == 0) {
				$('<tr />').append($('<td />', {
					style : 'padding: 150px 0 148px; border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6; font-size: 14px; color: #4c4c4c; text-align: center; margin-bottom: 20px;',
					colspan: '5',
					text : '게시글이 존재하지 않습니다.'
				})).appendTo($('#boardTable'));
			}else{
				$.each(data.list, function(index, items){
					$('<tr />', {
						style : 'border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6;'
					}).append($('<td />',{
						style: 'padding: 5px 0;',
						align : 'center',
						text : items.board_seq
					})).append($('<td />',{
						
					}).append($('<a />',{
						style : 'cursor:pointer;',
						id : 'b_subject',
						text : items.board_subject 
					}))).append($('<td />',{
						align : 'center',
						text : items.board_id
					})).append($('<td />',{
						align : 'center',
						text : items.logtime
					})).append($('<td />',{
						align : 'center',
						text : items.board_hit
					})).appendTo($('#boardTable'));
					
				});
				
				$(document).on('click', '#b_subject', function(){
					if(data.memId == null){
						alert('먼저 로그인 하세요.')
					}else{
						var seq = $(this).parent().prev().text();
						
						location.href = '/jaju/freeboard/freeboardView?board_seq=' + seq + '&pg=1';
					}
				});
			}
		},
		error: function(err){
			console.log(err);
		}
	});
	
	category('digital')
	
	$.ajax({
		url: '/jaju/main/slider01',
		type: 'post',
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data))
			
			if(data.list.length != 0){
				$('.s_no_data').hide();
				
				$.each(data.list, function(index, items){
					$('#s_a' + index).prop('href', '/jaju/saleboard/saleboardView?sale_seq=' + items.sale_seq + '&pg=1');
					$('#s_img' + index).prop('src', '/jaju/storage/' + items.sale_image1);
					$('#s_subject' + index).text(items.sale_subject);
					$('#s_price' + index).text(items.sale_price.toLocaleString());
				});
				
				$('.list_goods').show();
				
				$('.s_a').click(function(){
					if(data.memId == null){
						alert('먼저 로그인 하세요.');
						return false;
					}
				});
			}else{
				$('#slider-div').hide();
				$('.s_no_data').show();
			}
		},
		error: function(err){
			console.log(err);
		}
	});
	
	$('.single-item')
	.slick(
			{
				slide : 'div', //슬라이드 되어야 할 태그 ex) div, li 
				infinite : true, //무한 반복 옵션	 
				slidesToShow : 1, // 한 화면에 보여질 컨텐츠 개수
				slidesToScroll : 1, //스크롤 한번에 움직일 컨텐츠 개수
				speed : 100, // 다음 버튼 누르고 다음 화면 뜨는데까지 걸리는 시간(ms)
				arrows : true, // 옆으로 이동하는 화살표 표시 여부
				dots : true, // 스크롤바 아래 점으로 페이지네이션 여부
				autoplay : true, // 자동 스크롤 사용 여부
				autoplaySpeed : 3000, // 자동 스크롤 시 다음으로 넘어가는데 걸리는 시간 (ms)
				pauseOnHover : true, // 슬라이드 이동	시 마우스 호버하면 슬라이더 멈추게 설정
				vertical : false, // 세로 방향 슬라이드 옵션
				prevArrow : "<button type='button' class='slick-prev'>Previous</button>", // 이전 화살표 모양 설정
				nextArrow : "<button type='button' class='slick-next'>Next</button>", // 다음 화살표 모양 설정
				dotsClass : "slick-dots", //아래 나오는 페이지네이션(점) css class 지정
				draggable : true, //드래그 가능 여부 
				enterPadding : '60px',
				responsive : [ // 반응형 웹 구현 옵션
				{
					breakpoint : 960, //화면 사이즈 960px
					settings : {
						//위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
						slidesToShow : 3
					}
				}, {
					breakpoint : 768, //화면 사이즈 768px
					settings : {
						//위에 옵션이 디폴트 , 여기에 추가하면 그걸로 변경
						slidesToShow : 2
					}
				} ]

			});
});

$('#b_linkBtn').click(function(){
	location.href = '/jaju/freeboard/freeboardList?pg=1';
});