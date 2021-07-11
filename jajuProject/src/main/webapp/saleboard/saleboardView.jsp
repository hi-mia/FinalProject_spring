<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/css/saleboardView.css" />
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>
<body>

<div id="total" style="width:1080px; margin: auto; ">

	<div class="section_view">

							<div id="shareLayer">
							<div class="layer_share" style="display: none;">
								<div class="inner_layersns">
									<h3 class="screen_out">SNS 공유하기</h3>
									<ul class="list_share">
										<li><a class="btn btn_fb" data-sns-name="페이스북"
											data-sns="facebook" href="#none"><img
												src="https://res.kurly.com/mobile/service/goodsview/1804/ico_facebook.png"
												alt="페이스북"><span class="txt">공유하기</span></a></li>
										<li><a class="btn btn_tw" data-sns-name="트위터"
											data-sns="twitter" href="#none"><img
												src="https://res.kurly.com/mobile/service/goodsview/1804/ico_twitter.png"
												alt="트위터"><span class="txt">트윗하기</span></a></li>
										<li class="btn_url"><input type="text" class="inp"
											value="" readonly="readonly"> <a class="btn_copy off"
											data-sns-name="링크 복사" data-sns="copy" href="#none">URL 복사<img
												src="https://res.kurly.com/mobile/service/goodsview/1804/ico_checked_x2.png"
												alt=""></a></li>
									</ul>
								</div>
							</div>
						</div>
						
		<div id="sectionView">
			<div class="inner_view">
				
				<div class="thumb">
					<img
						src=""
						alt="상품 대표 이미지" class="bg">
				</div>
				
				<div class="subjectDiv">
					<p class="goods_name">
						<strong class="name"></strong><span class="short_desc"></span>
					</p>
					<p class="goods_price">
						<span class="position"><span class="dc">
								<!----> <span class="dc_price">10<span class="won">원</span></span>
								<span id="sale_nego" style="font-size: 12pt;"></span>
						</span></span>
						
					</p>
				</div>
				
				<div class="goods_info">
					<!---->
					<dl class="list" id="member_id">
						<dt class="tit" ><img alt="프로필" src="" style="width: 50px; height: 50px;"></dt>
						<dd align="right" class="tooltip">매너온도&ensp;<i class="far fa-question-circle"></i><span class="tooltip-text" align="left">매너온도는 자주 마켓 사용자로부터 받은 리뷰, 신고, 운영자 징계등을 종합해서 만든 매너 지표에요. </span></dd>
						<dd class="desc"></dd>
					</dl>
					<dl class="list" id="sale_condition">
						<dt class="tit">매물 상태</dt>
						<dd class="desc"></dd>
					</dl>
					<dl class="list" id="howTrade">
						<dt class="tit">거래 방법</dt>
						<!---->
						<dd class="desc"></dd>
					</dl>
					<dl class="list" id="member_sido">
						<dt class="tit">거래 지역</dt>
						<dd class="desc"></dd>
					</dl>
					
					<dl class="list" id="sale_date">
						<dt class="tit">올린 날짜</dt>
						<dd class="desc"></dd>
					</dl>
					
					<dl class="list" id="sale_state">
						<dt class="tit">매물 상태</dt>
						<dd class="desc"></dd>
					</dl>
					<!---->
				</div>
				
				
				<!---->
			</div>
			</div>						

		<div id="cartPut">
			<div class="cart_option cartList cart_type2">
				<div class="inner_option">					
					<div class="group_btn off">
						<!-- 찜 자리 -->
						<span class="btn_type_scrap" id="btn_type_scrap">
							<button type="button" class="txt_type_scrap" id="scrapBtn">찜♡</button> <!---->
						</span>
						<span class="btn_type_follow" id="txt_type_follow">
							<button type="button"class="txt_type_follow" id="followBtn">팔로우</button> <!---->
						</span>
						<span class="btn_type_message">
							<button type="button"class="txt_type">쪽지 보내기</button> <!---->
						</span>
						<!--
						<a id="scrapBtn">
							<img alt="하트" src="/jaju/jajuImage/blackhart.png" width="50" height="50">
						</a>
						-->
			
					</div>
				</div>
			</div>

		</div>
	</div>
	<div id="imageDiv">
			
	</div>
	<div id="contentDiv" >
		<pre class="viewPre" style=" min-height: 300px; background: #f2f2f2; user-select: auto; border: 1px solid #ddd;"><span id="contentSpan" >

</span></pre>
	</div>

<div id="memberreportDiv">
			
				<a id="memberreportA" style="cursor: pointer;">
					<button id="memberreportSpan">신고</button>
				</a>
				
				<a href="/jaju/saleboard/saleboardModifyForm?sale_seq=${param.sale_seq }" id="memberModifyA" style="cursor: pointer;">
					<button id="memberModifySpan">수정</button>			
				</a>
				
				<button id="saleboardDeleteBtn">삭제</button>
				<!-- <input type="button" value="삭제" id="saleboardDeleteBtn">	 -->	
				
			</div>
			

	
	<!-- 댓글 -->
	<div id="commentDiv">
		<table id="commentTable" style="margin-top: -10px;">
			<tr style="border-bottom: 1px solid #f5f5f5;">
				<th width="200" style="padding-bottom: 10px;">번호</th>
				<th width="400" style="padding-bottom: 10px;">내용</th>
				<th width="200" style="padding-bottom: 10px;">작성자</th>
				<th width="200" style="padding-bottom: 10px;">작성일</th>
				<th width="100"/>
			</tr>
			
		</table>
		<div id="pagingDiv" style="text-align: center; margin-bottom: 10px;">
		
		</div>
		
		<table border="1" id=c cellspacing="0" cellpadding="10"
         bordercolor="#47597e" align="center" frame="hsides" rules="rows"
         width="1050" id="commentWriteTable" style="border-top: 1px solid #ffffff; border-bottom: 1px solid #ffffff;">
         <tr>
            <td height="80" width="140" align="left">댓글: &nbsp; <span id="replySpan"></span>
               <input type="text" placeholder="댓글을 입력하세요." size="110" id="commentText" class="commentInput">
               &nbsp;&nbsp;
               <input type="button" value="댓글 입력" class="commentInput" id="commentInputBtn" size="200" 
               style="height: 30px; width: 80px; background-color: #617aad; color: #fff; border: none; border-radius: 3px; margin-top: 5px;">
            </td>
         </tr>
      </table>
      
	</div>
</div>	
	<div class="graph1"><span></span></div>
	<div class="graph2"><span></span></div>
	<div class="graph3"><span></span></div>
	

	<input type="hidden" id="sale_seq" value="${param.sale_seq }"/>
	<input type="hidden" id="pg" value="${param.pg }"/>
	<input type="hidden" id="memId" value="${sessionScope.memId }">
	
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script src="/jaju/js/saleboardView.js"></script>	
<script src="/jaju/js/saleboardDelete.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js" ></script>
<script type="text/javascript">
function saleboardCommentPaging(pg){
	$.ajax({
		type: 'post',
		url: '/jaju/saleboard/getSaleboardComment',
		data: {'sale_seq': $('#sale_seq').val(), 'pg': pg},
		dataType: 'json',
		success: function(data){
			//alert(JSON.stringify(data));
			
			$('#commentTable tr:gt(0)').remove();
			
			$('#commentTable tr:gt(0)').remove();
			
			$.each(data.list, function(index,items){
				
				$('<tr/>').append($('<td/>',{
					text : items.comment_seq
				})).append($('<td/>',{
					style : 'text-align: left;'
					
					}).append($('<a/>',{
						text : items.comment_content,
						id: 'subjectA',
						class: 'content_'+ items.comment_seq
					}))
				).append($('<td/>',{
					text : items.member_id
				})).append($('<td/>',{
					class: 'trLast'+items.comment_seq,
					text : items.logtime
				})).appendTo($('#commentTable'));
				
				for(var i=1; i<items.comment_lev; i++){
					$('.content_'+items.comment_seq).before('&emsp;');
				}
				if(items.comment_pseq != 0 ){
					$('.content_'+items.comment_seq).before($('<img>',{
						src: '/jaju/jajuImage/reply.gif'
					}));
				}
				
				if(items.member_id == $('#memId').val()){
					$('.trLast'+items.comment_seq).after($('<td/>',{
						width: '100px',
					}).append($('<img>',{
						src: '/jaju/jajuImage/delete.png',
						id: 'commentDeleteBtn',
						style: 'cursor: pointer; float: right; border: 1px solid #00000033; margin-right: 10px;',
						width: '20px',
						height: '20px'
					})).append($('<img>',{
						src: '/jaju/jajuImage/modify.png',
						id: 'commentModifyBtn',
						style: 'cursor: pointer; float: right; border: 1px solid #00000033; margin-right: 10px;',
						width: '20px',
						height: '20px'
					})));
				}
			}); //each
			
			
			$('#pagingDiv').html(data.saleboardCommentPaging.pagingHTML);
			
			$(document).on('click', '#subjectA', function(){
					
					$('#reCommentTr').remove();
					$('#reCommentModifyTr').remove();
				
					$(this).parent().parent().after($('<tr/>',{
						id: 'reCommentTr'
					}).append($('<td/>',{
						style: 'background-color: #f5f5f5;'
					})).append($('<td/>',{
						colspan: 3,
						text: 're: ',
						style: 'background-color: #f5f5f5; text-align: left;'
					}).append($('<input/>',{
						type: 'text',
						id: 'reCommentText',
						width: '55%'
					})).append($('<input/>',{
						type: 'button',
						id: 'reCommentBtn',
						value: '   답글달기'
					}))
					));
					
			});
			
			
			
		},error: function(err){
			alert("댓글 불러오기 에러");
			console.log(err);
		}
	});
	
}

</script>

</body>
</html>