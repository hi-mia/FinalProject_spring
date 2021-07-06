<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="/jaju/manager_css/managerReportList.css" />

<jsp:include page="/manager/managerHeader.jsp"/>
<div class="total">
<jsp:include page="/manager/managerMenu.jsp"/>
<form id="managerReportList" name="managerReportList">
<div id="content" class="cont_post post_spam">
<input type="hidden" id="searchHidden" name="searchHidden">
<input type="hidden" id="pg" name="pg" value="${pg}">	
<%-- <input type="hidden" id="report_seq" name="report_seq" value="${report_seq}"> --%>
	<div class="wrap_tit">
		<h3 class="cont_tit">
			<span class="tit_menu">신고게시판 관리</span>
		</h3>
		
		<div class="box_search">
			<div class="select_admin" style="font-size: 14px;">
			<select id="itemcd" name="itemcd">
				<option value="report_subject">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="report_id">&nbsp;&nbsp;&nbsp;&nbsp;작성자&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</div>
			
			<div class="search_input">
				<input id="keyword" name="keyword" value="${keyword}" maxlength="20" size="25" class="tf_search textbox_default">
				<button type="button" class="reportSearch" style="color: white;">
					<span class="ico_admin">검색</span>
				</button>
			</div>
		</div>
	</div>
	<div class="option_list article_option_list">
		
	</div>

	<div class="set_list" id="listControlBar" style="width: 840px; height: 59px; padding: 0; background: #FAFAFA; border-top: 1px solid #e4e4e4; border-bottom: 1px solid #e4e4e4;">
		<div class="bundle_set">
		
		</div>
		<div class="bundle_set" style="align: right; margin-top: 14px; margin-right: 14px;">
			<button type="button" id="reportDeleteBtn" class="btn_admin btn_type2 button-delete-article">
				<span class="ico_admin ico_del"></span>
				<span class="txt_btn">삭제</span>
			</button>
		</div>
	</div>

	<div id="admin_listview">
		<table class="mangerReportTable" style="font-size: 13px; width: 840px; table-layout: fixed;">
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
			<tr class="no_data">
				<td colspan="19" class="no_article">신고 내역이 없습니다.</td>
			</tr>
		
	</table>
</div>

	<div id="pagingAreaPg" class="page_admin"></div>
	<div id="pagingArea" class="page_admin"></div>
</div>
</form>
</div>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerReportList.js"></script>