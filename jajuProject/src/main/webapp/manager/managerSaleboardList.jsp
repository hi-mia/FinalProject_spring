<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/manager_css/managerBoard.css" />
</head>
<body>
<jsp:include page="/manager/managerHeader.jsp"/>
<div style="width: 1080px; margin: auto;">
<jsp:include page="/manager/managerMenu.jsp"/>
<div id="content" class="cont_post post_spam">
       

      
      <div class="wrap_tit">
	      	<div id="sale_title" style="display: flex;">
		         <h3 class="cont_tit">
		            <span class="tit_menu">판매게시판 관리</span>
		         </h3>
	        </div> 
         <form name = "managerSaleboardSearchList" id="managerSaleboardSearchList" method="post">
         <input type="hidden" id="categorySelected" value="${param.sale_category }" />
			<select name="categoryOption" id="categoryOption" style="float: left; font-size: 14px;">
				<option value="*">전체</option>
				<option value="digital">디지털/가전</option>
				<option value="life">생활</option>
				<option value="instant_food">가공식품</option>
				<option value="women_cloth">여성의류</option>
				<option value="beauty">뷰티 / 미용</option>
				<option value="furniture">가구 / 인테리어</option>
				<option value="sport">스포츠 / 레저</option>
				<option value="men_choth">남성 / 패션잡화</option>
				<option value="dogCat">반려동물용품</option>
				<option value="kids">유아동 / 유아도서</option>
				<option value="womenAcc">여성잡화</option>
				<option value="game">게임 / 취미</option>
				<option value="kitchen">주방용품</option>
				<option value="book">도서 / 티켓 / 음반</option>
				<option value="else">기타 중고물품</option>
			</select>
		
		<div class="box_search">
			<div class="select_admin" style="font-size: 14px;">
			
			<select name="searchOption" id="searchOption">
				<option value=sale_subject>&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="sale_content">&nbsp;&nbsp;&nbsp;&nbsp;내용&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="member_id">&nbsp;&nbsp;&nbsp;&nbsp;작성자&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</div>
			
			<div class="search_input">
				<input type="text" id="keyword" name="keyword" maxlength="20" size="25" class="tf_search textbox_default" title="검색어">
				<button type="button" id="managerBoardSearchBtn" class="btn_admin btn_search button-search">
					<span class="ico_admin">검색</span>
				</button>
			</div>
		</div>
         <input type="hidden" name="pg" id="pg" value="${param.pg }">
         <input type="hidden" name="searchPg" id="searchPg" value="1">   
         </form>
      </div>

      <div class="option_list article_option_list">
         <div class="info_option">
            <span class="txt_total">전체 게시글 <span id="totalNum" class="num_total"></span></span>
         </div>
      </div>

      <div class="set_list" id="listControlBar" style="width:800px">
         <div class="bundle_set">
            <div class="txt_choice">
               <div class="check_admin check-all">
                  <input type="checkbox" id="inpCheckAll" class="checkradio_styled">
               </div>
            </div>
         </div>
         <div class="bundle_set">
            <button type="button" id="choiceDeleteBtn" class="btn_admin btn_type2 button-delete-article">
               <span class="ico_admin ico_del"></span>
               <span class="txt_btn">삭제</span>
            </button>
         </div>
      </div>

      <div id="admin_listview">
<form name="managerSaleboardListDelete" id="managerSaleboardListDelete" method="post">
         <table id="managerSaleboardTable" class="tbl_admin" summary="게시글 목록입니다. 제목, 글쓴이, 작성일, 조회수를 제공합니다.">
            <caption class="ir_caption">게시글 관리 목록</caption>
            <colgroup>
               <col width="48px">
               <col width="150px" class="fldname">
               <col width="100%" class="title">
               <col width="140px" class="writer">
               <col width="100px">
               <col width="90px">
            </colgroup>
            <thead>
            <tr>
               <th scope="col" class=""><input type="checkbox" id="all"></th>
               <th scope="col" class="board_seq">글번호</th>
               <th scope="col" class="board_subject">제목</th>
               <th scope="col" class="board_id">글쓴이</th>
               <th scope="col" class="logtime">작성일</th>
               <th scope="col" class="board_hit">조회수</th>
            </tr>
            </thead>
            <tbody id="article-list">
</tbody>
         </table>
</form>      
      </div>


<!-- 페이징 -->

   <div id="pagingAreaPg" class="page_admin"></div>
   <div id="pagingArea" class="page_admin"></div>
</div>

</div>

<input type="hidden" id="searchTextHidden"/>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerSaleboardList.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerSaleboard').addClass('on');
});


function saleboardPaging(pg){
	//var boardSearchText = document.getElementById('keyword').value;
	
	//if(boardSearchText == ''){
	if($('#searchTextHidden').val() == ''){
		//location.href = '/jaju/freeboard/freeboardList?pg='+pg;
		location.href="/jaju/managerSaleboard/managerSaleboardList?pg="+pg+'&sale_category='+$('#categoryOption').val();
	} else{
		$('#searchPg').val(pg);
		$('#keyword').val($('#searchTextHidden').val());
		$('#managerBoardSearchBtn').trigger('click');
		//location.href = 'boardSearch?pg='+pg+'&select='+$('#select option:selected').val() +'&keyword='+$('#keyword').val();
		//encodeURIComponent('${keyword}');
		$('#searchPg').val(1);
	}	 	
}

</script>
</body>
</html>