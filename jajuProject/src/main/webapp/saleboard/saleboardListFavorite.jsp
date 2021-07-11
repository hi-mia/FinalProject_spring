<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/jaju/css/saleboardFavorite.css" />
</head>
<body>

<div id="saleboardListDiv">

		<div class="search_bt">
		
			<div class="head_aticle" align="center">
				<h2 class="tit" style="color: #333;">관심게시판 <span class="tooltip-text" align="left">관심 키워드로 등록된 지역의 물품을 보여드려요. 만약 상품이 보이지 않는다면, 먼저 관심 키워드를 등록하세요!</span></h2>
			</div>
			
			<select id="sortinSelect" class="selectBox" >
				<option value="sale_date">최신순</option>
				<option value="sale_hit">인기순</option>
				<option value="low_sale_price">낮은가격순</option>
				<option value="sale_price">높은가격순</option>
			</select> 
			
			
			<input type="text" name="searchText" id="searchText" placeholder="검색할 중고 물품을 입력하세요." value="" required="">
			<input type="image" src="/jaju/jajuImage/search.png" align="absmiddle" width="30" height="30" id="searchBtn">
		</div>

		<!-- 리스트 -->
	<div id="goodsList" class="page_section section_goodslist">
		
		<div class="list_goods">
			<div class="inner_listgoods">
				<ul class="list">
					
				</ul>
			</div>
		</div>
		
		<!-- 페이징 -->
		<div id="pagingDiv">
			
			
		</div>
		
		<div id="noneDiv" style="padding: 300px; text-align: center; display: block;"><strong>등록된 상품이 없습니다</strong></div>
		
		<div style="position:relative; margin-top: -125px; margin-bottom: 170px;">
         <div style="position:absolute;right:0;top:60px;">
            <a id="writeA" href="/jaju/saleboard/saleboardWriteForm">
               <span class="bhs_buttonsm yb" style="float:none;">판매물품등록</span>
            </a>
         </div>
      </div>
	</div>
	
	
	
</div>
<input type="hidden" id="pg" value="${param.pg }">
<input type="hidden" id="searchPg" value="1">
<input type="hidden" id="memId" value="${sessionScope.memId }">
<input type="hidden" id="sortinSelected" value="${param.sortinSelect }">
<input type="hidden" id="searchHidden" >

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/js/saleboardListFavorite.js"></script>
<script type="text/javascript" >
$('.item').click(function(){
	location='/jaju/saleboard/saleboardView';
});
function saleboardPaging(pg){
	var searchText = document.getElementById('searchText').value;
	
	if($('#searchHidden').val() == ''){
		location.href = '/jaju/saleboard/saleboardListFavorite?pg='+pg+'&sortinSelect='+$('#sortinSelect').val();
		//$('#sortinSelect').trigger('change');		
	} else{
		
		$('#searchPg').val(pg);
		//alert($('#searchPg').val())
		$('#searchText').val($('#searchHidden').val());
		$('#searchBtn').trigger('click','research');
		//location.href = 'boardSearch?pg='+pg+'&select='+$('#select option:selected').val() +'&keyword='+$('#keyword').val();
		//encodeURIComponent('${keyword}');
		//$('#searchPg').val(1);
	}	 	
}

</script>

</body>
</html>