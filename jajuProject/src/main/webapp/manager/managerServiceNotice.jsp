<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="/jaju/manager_css/managerServiceNotice.css" />

<div class="total" style="display:flex; justify-content: center;">
<jsp:include page="/manager/managerMenu.jsp"/>
<div id="content" class="cont_post post_spam">
	<div class="wrap_tit">
		<h3 class="cont_tit">
			<span class="tit_menu">공지사항 관리</span>
		</h3>
		
		<div class="box_search">
			<div class="search_input">
				<input id="search-text" maxlength="20" size="25" class="tf_search textbox_default" title="검색어">
				<button type="button" class="btn_admin btn_search button-search">
					<span class="ico_admin">검색</span>
				</button>
			</div>
		</div>
	</div>
	<div class="option_list article_option_list">
		
	</div>

	<div class="set_list" id="listControlBar" style="width: 840px; height: 50px; background: #FAFAFA; border-top: 1px solid #e4e4e4; border-bottom: 1px solid #e4e4e4;">
		<div class="bundle_set">
		
		</div>
		<div class="bundle_set" style="align: right;">
			<button type="button" class="btn_admin btn_type2 button-delete-article">
				<span class="ico_admin ico_del"></span>
				<span class="txt_btn">삭제</span>
			</button>
		</div>
	</div>

	<div id="admin_listview">
		<table class="tbl_admin">

		
			<thead>
			<tr>
				<th class="" style="width:40px;"><input type="checkbox" id="all" onclick="checkAll()"></th>
               <th class="board_seq" style="width:80px;">번호</th>
               <th class="board_subject" style="width:594px;">제목</th>
               <th class="board_hit" style="width:120px;">작성일</th>
			</tr> 
			</thead>
		<tr>
			   <td align="center"><input type="checkbox"></td>
               <td align="center">번호</td>
               <td>제목</td>
               <td align="center">작성일</td>
			</tr>
	
	</table>
</div>

<div id="pagingAreaPg" class="page_admin"></div>

		<div id="pagingArea" class="page_admin">
			
				<a class="btn_page btn_prev page_disabled" style="height: 20px;">
					<span class="ico_admin"></span>&nbsp;이전
				</a>
				
				<ul class="bundle_page"><li class="on"><a>1</a></li></ul>
				
				<a class="btn_page btn_next page_disabled">다음&nbsp;
					<span class="ico_admin"></span>
				</a>
			</div>
		<div id="article-summary-layer" class="layer_post summary-layer"></div>
	</div>
</div>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerServiceNotice.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerServiceNotice').addClass('on');
});
</script>

<script type="text/javascript">
//전체 선택 또는 해제
$('#all').click(function(){
	
	if($('#all').prop('checked')){
		$('input[name=check]').prop('checked', true);
	}else{
		$('input[name=check]').prop('checked', false);
		
	}
});

//선택 삭제
$('#choiceDeleteBtn').click(function(){
	var count = $('input[name=check]:checked').length;
	
	if(count == 0){
		alert("삭제할 항목을 선택하세요");
	}else{
		confirm("정말로 삭제하시겠습니까?");
		$('#imageboardDeleteForm').submit();
	}
});
</script>
</html>