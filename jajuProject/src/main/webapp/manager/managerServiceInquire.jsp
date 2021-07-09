<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/jaju/manager_css/managerServiceInquire.css" />
</head>
<body>
<jsp:include page="/manager/managerHeader.jsp"/>
<form id = "managerInquireDelete" method="get" action="managerInquireDelete">
<div class="total" style="display:flex; justify-content: center;">
<jsp:include page="/manager/managerMenu.jsp"/>
<div id="content" class="cont_post post_spam">
<input type = "hidden" name = "pg" id = "pg" value="${pg }">
<input type = "hidden" name = "inquiry_id" id = "inquiry_id" value="${session.memId }">
<input type = "hidden" name = "inquiry_seq" id = "inquiry_seq" value = "${inquiry_seq }">
	<div class="wrap_tit">
		<h3 class="cont_tit">
			<span class="tit_menu">1:1 문의 관리</span>
		</h3>
		
		<div class="box_search">
			<div class="select_admin" style="font-size: 14px;">
			<select id="itemcd" name="itemcd">
				<option value="inquiry_subject">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="inquiry_id">&nbsp;&nbsp;&nbsp;&nbsp;작성자&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</div>
			
			<div class="search_input">
				<input id="text" id = "keyword" name="keyword" value="${keyword}" maxlength="20" size="25" class="tf_search textbox_default" title="검색어">
				<button type="button" id = "managerServiceInquireBtn" class="btn_admin btn_search button-search">
					<span class="ico_admin">검색</span>
				</button>
			</div>
		</div>
	</div>
	<div class="option_list article_option_list">
		
	</div>

	<div class="set_list" id="listControlBar" style="width: 800px; height: 50px; background: #FAFAFA; border-top: 1px solid #e4e4e4; border-bottom: 1px solid #e4e4e4;">
		<div class="bundle_set">
		
		</div>
		<div class="bundle_set" style="align: right;">
			<button type="button" class="btn_admin btn_type2 button-delete-article">
				<span class="ico_admin ico_del"></span>
				<span class="txt_btn" id = "choiceDeleteBtn">삭제</span>
			</button>
		</div>
	</div>

	<div id="admin_listview">
		<table class="tbl_admin" id = "tbl_admin">

		
			<thead>
			<tr>
				<th class="" style="width:40px;">
					<input type="checkbox" id="all" name="all"/>
				</th>
               <th class="board_seq" style="width:75px;">번호</th>
               <th class="board_subject" style="width:135px;">카테고리</th>
               <th class="board_subject" style="width:274px;">제목</th>
               <th class="board_hit" style="width:100px;">작성자</th>
               <th class="logtime" style="width:105px;">작성일</th>
               <th class="board_id" style="width:105px;">처리상태</th>
			</tr> 
			</thead>

	
	</table>
			
	<div class="no_data" style="padding: 150px 0 148px; border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6; font-size: 14px; color: #4c4c4c; text-align: center;">
		1:1 문의 내역이 존재하지 않습니다.
	</div>
	<table class="inquireTable" id="inquireTable" style="width:100%; border-top: 50px solid #FAFAFA;; border-bottom: 1px solid #e6e6e6;"></table>
 <div id="pagingArea" class="page_admin">

</div>
</div>
</div>

</div>
</form>
</body>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerServiceInquire.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerServiceInquire').addClass('on');
});
</script>
</html>