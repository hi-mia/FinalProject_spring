<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/manager_css/managerMemberBlack.css" />
</head>
<body>
<jsp:include page="/manager/managerHeader.jsp"/>

<div style="width: 1080px; margin: auto;">

<jsp:include page="/manager/managerMenu.jsp"/>

<div id="framecontent">

<input type="hidden" name="pg" id="pg" value="${pg}">

	<div id="content" class="cont_post member_admin">
	
		<div class="wrap_tit">
			
			<h3 class="cont_tit">
				<span class="tit_menu">활동중지/강제탈퇴 회원</span>
			</h3>
			
			<form name="black_searchform" onsubmit="">
			
				<!-- 선택한 값으로 sort하기  -->
				<div class="box_search">
					<div class="select_admin">
						<select id="searchMode" fixedsize="110" class="selectbox_styled">
							<option value="member_id" selected="selected">아이디</option>
							<option value="member_email">이메일</option>
							<option value="member_id_email">아이디+이메일</option>
						</select>
						
						<!--  <a id="searchMode_img" class="img_selectbox" tabindex="0" style="width: 90px;">닉네임+이메일</a>-->
					</div>
					
					<!-- 선택한 값으로 검색 하기  -->
					<div class="search_input">
						<input id="search-text" maxlength="20" size="25" class="tf_search textbox_default" title="검색어">
						<button type="button" id="search-text_Btn" class="btn_admin btn_search button-search">
							<span class="ico_admin">검색</span>
						</button>
					</div>
				</div><!-- box_search -->
			</form>
		</div>

	<form name="managerMemberBlackForm" id="managerMemberBlackForm" method="post" action="">

			<!-- 전체회원관리 (append 되는 곳) -->
			<div id="admin_listview">
			
			<!-- 상단에 회원 정보 수정하는 거로 바꿈 -->
			<div class="set_list" id="listControlBar_black">
				<div class="bundle_set">
					<div class="txt_choice">
						<!--<div class="check_admin">
							 <img src="//t1.daumcdn.net/cafe_image/cf_img2/img_blank2.gif" width="18" height="18" class="img_checkbox"><input type="checkbox" id="inpCheckAll" onclick="boardManager.toggleAllCheck(this);" class="checkradio_styled">
						</div> -->
					    <select id="sortinSelect" class="selectBox" >
							<option value="break_member">활동중지</option>
							<option value="delete_member">강제탈퇴</option>
						</select> 
					</div>
				</div>
				
				<div class="bundle_set">
					<button type="button" class="btn_admin btn_type2" id="btnWithdraw">
						<span class="ico_admin ico_caution"></span>
						<span class="txt_btn" id="again_member_id">활동 중지 해제</span>
					</button>

				</div>
			</div>
			
			
			<table class="tbl_admin tbl_type3"  id="adminTable" summary="전체회원 목록입니다. 닉네임, 회원등급, 가입일, 최종방문일, 방문수, 게시글수를 제공합니다.">
				<caption class="ir_caption">전체회원 관리 목록</caption>
				<thead id="memberListHead">
					<tr>
				
						<th class="lineL chk" style="width: 38px;">
							<input type="checkbox" id="all" name="all"/>
						</th>
				
						<th class="member_writer" style="width:100px; text-align:center;">아이디</th>
						
						<th class="member_email" style="width: 120px; text-align:center;">이메일</th>
						
						<th class="txt_al" style="width: 120px; text-align:center;">회원등급</th>
						
						<th id="regdt" style="width: 90px;">
							<label class="btn_admin btn_date">
				                   <span class="txt_btn">가입일
				                       <span class="ico_admin ico_disabled"></span>
				                   </span>
								<input type="button" class="btn_g" value="가입일">
							</label>
						</th>
						
						<th id="lastcntdt" class="hidecell" style="width: 90px;">
							<label class="btn_admin btn_date">
				                   <span class="txt_btn">최종방문일
				                       <span class="ico_admin ico_disabled"></span>
				                   </span>
								<input type="button" class="btn_g" value="최종방문일">
							</label>
						</th>
						
						<th id="visit" style="width: 90px;">
							<label class="btn_admin btn_date">
				                   <span class="txt_btn">매너온도
				                       <span class="ico_admin ico_disabled"></span>
				                   </span>
								<input type="button" class="btn_g" value="방문수">
							</label>
						</th>
						
						<th id="comment" style="width: 90px;">
							<label class="btn_admin btn_date">
				                   <span class="txt_btn">신고누적수
				                       <span class="ico_admin ico_disabled"></span>
				                   </span>
								<input type="button" class="btn_g" value="댓글수">
							</label>
						</th>
						 
						<th id="article" style="width: 90px;" >
							<label class="btn_admin btn_date">
				                   <span class="txt_btn">판매글수
				                       <span class="ico_admin ico_disabled"></span>
				                   </span>
								<input type="button" class="btn_g" value="게시글수">
							</label>
						</th>
					</tr>
				</thead>
						<!-- ========= 여기가 append 되는 곳  ========= -->
						<tbody id="memberListBody">
						</tbody>
			</table>
		</div>
	</form>


	<div class="set_list" id="listControlBar2" style="background: #FAFAFA;height: 30px;">
	</div>


		<div style="text-align: center;" id="memberPagingDiv"></div>
		<div style="text-align: center;" id="memberPagingBlackDiv"></div>

<!-- 
			<div id="pagingArea" class="page_admin">
			
				<a class="btn_page btn_prev page_disabled">
					<span class="ico_admin"></span>&nbsp;이전
				</a>
				
				<ul class="bundle_page"><li class="on"><a>페이징처리하는곳</a></li></ul>
				
				<a class="btn_page btn_next page_disabled">다음&nbsp;
					<span class="ico_admin"></span>
				</a>
			</div> -->

           <div id="accountNotiLayer">
               <ul class="account_noti" style="text-align: left;">
                   <li>활동중지 카테고리를 클릭하면 활동중지 회원 목록과 강제탈퇴 회원 목록을 볼 수 있습니다.</li>
                   <li>회원을 체크한뒤 활동중지해제 버튼을 누르면 활동중지가 해제되고 회원관리로 이동합니다.</li>
                   <li>강제탈퇴된 회원은 복구가 불가능합니다.</li>
               </ul>
           </div>
           <div id="articleSummaryLayer" class="layer_post" style="top: -10000px; left: -10000px; visibility: hidden;"></div>
	</div><!-- end content -->
	</div>
</div>
<input type="hidden" id="searchPg" value="1">
<input type="hidden" id="sortinSelected" value="${param.sortinSelect }">


	<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>	
	<script src="/jaju/manager_js/managerMemberBlack.js"></script>
	
		<script type="text/javascript">

	function managerPaging(pg){
		var keyword = document.getElementById('search-text').value;
		if(keyword == ''){
			location.href="/jaju/manager/managerMemberBlack?pg="+pg+'&sortinSelect='+$('#sortinSelect').val();
			//$('#sortinSelect').trigger('change');		
		} else{
			$('input[name=pg]').val(pg);
			$('#search-text_Btn').trigger('click');
			$('input[name=pg]').val(1);
			//location.href = 'boardSearch?pg='+pg+'&select='+$('#select option:selected').val() +'&keyword='+$('#keyword').val();
			//encodeURIComponent('${keyword}');
			//$('#searchPg').val(1);
	}
}
	</script>
</body>
</html>