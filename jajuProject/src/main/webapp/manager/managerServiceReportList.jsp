<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="/jaju/manager_css/managerServiceReport.css" />

<div class="total" style="display:flex; justify-content: center;">
<jsp:include page="/manager/managerMenu.jsp"/>
<form id="managerSerivceReportList" name="managerSerivceReportList">
<div id="content" class="cont_post post_spam">
<input type="hidden" id="pg" name="pg" value="${pg}">	
<input type="hidden" id="report_seq" name="report_seq" value="${report_seq}">	
	<div class="wrap_tit">
		<h3 class="cont_tit">
			<span class="tit_menu">신고게시판 관리</span>
		</h3>
		
		<div class="box_search">
			<div class="select_admin" style="font-size: 14px;">
			<select id="itemcd" name="itemcd">
				<option value="managerService">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="managerService">&nbsp;&nbsp;&nbsp;&nbsp;작성자&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</div>
			
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

	<div class="set_list" id="listControlBar" style="width: 800px; height: 50px; background: #FAFAFA; border-top: 1px solid #e4e4e4; border-bottom: 1px solid #e4e4e4;">
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
		<table class="mangerReportTable" style="font-size: 13px">
		<thead>
			<tr>
			   <th class="" style="width:40px;"><input type="checkbox" id="all" onclick="checkAll()"></th>
               <th class="report_seq" style="width:75px;">번호</th>
               <th class="reportType" style="width:135px;">카테고리</th>
               <th class="report_subject" style="width:274px;">제목</th>
               <th class="report_id" style="width:100px;">작성자</th>
               <th class="report_logtime" style="width:105px;">작성일</th>
               <th class="report_state" style="width:105px;">처리상태</th>
			</tr> 
		</thead>
			<!-- <tr>
			   <td align="center"><input type="checkbox"></th>
               <td align="center">번호</td>
               <td align="center">카테고리</td>
               <td>제목</td>
               <td align="center">작성자</td>
               <td align="center">작성일</td>
               <td align="center">처리상태</td>
			</tr> -->
	
	</table>
</div>

	<div id="pagingAreaPg" class="page_admin"></div>
	<div id="pagingArea" class="page_admin"></div>
</div>
</form>
</div>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerServiceReportList.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerServiceReport').addClass('on');
});
</script>

<script type="text/javascript">
//전체 선택 또는 해제
$('#all').click(function(){
	//alert($('#all').attr('checked')); // - checked 속성이 없어서 undefind으로 나온다.
	//alert($('#all').prop('checked')); //true 또는 false
	
	if($('#all').prop('checked')){
		$('input[name=check]').prop('checked', true);
	}else{
		$('input[name=check]').prop('checked', false);
		
	}
});
</script>