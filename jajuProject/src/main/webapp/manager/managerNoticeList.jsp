<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<link rel="stylesheet" href="/jaju/manager_css/managerNoticeList.css" />
<jsp:include page="/manager/managerHeader.jsp"/>

<div class="total">
<jsp:include page="/manager/managerMenu.jsp"/>
<form id=managerNoticeList name="managerNoticeList">
<div id="content" class="cont_post post_spam">
<input type="hidden" id="searchHidden" name="searchHidden">
<input type="hidden" id="pg" name="pg" value="${pg}">	
<%-- <input type="hidden" id="notice_seq" name="notice_seq" value="${notice_seq}"> --%>	
	<div class="wrap_tit">
		<h3 class="cont_tit">
			<span class="tit_menu">공지사항 관리</span>
		</h3>
		
		<div class="box_search">
			<div class="select_admin" style="font-size: 14px;">
			<select id="itemcd" name="itemcd">
				<option value="notice_subject">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="notice_content">&nbsp;&nbsp;&nbsp;&nbsp;내용&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</div>
			
			<div class="search_input">
				<input id="keyword" name="keyword" value="${keyword}" maxlength="20" size="25" class="tf_search textbox_default">
				<button type="button" class="noticeSearch">
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
			<button type="button" class="btn_admin btn_type7_1">
				<span class="ico_admin write"></span>
				<span class="txt_btn writeBtn">글쓰기</span>
			</button>
			<button type="button" id="noticeDeleteBtn" class="btn_admin btn_type2 button-delete-article">
				<span class="ico_admin ico_del"></span>
				<span class="txt_btn">삭제</span>
			</button>
		</div>
	</div>

	<div id="admin_listview">
		<table class="mangerNoticeTable" style="font-size: 13px; width: 840px; table-layout: fixed;">  
         <thead>
         <tr>
            <th class="" style="width:40px;"><input type="checkbox" id="all" onclick="checkAll()"></th>
               <th class="notice_seq" style="width:80px;">번호</th>
               <th class="notice_subject" style="width:594px;">제목</th>
               <th class="notice_logtime" style="width:120px;">작성일</th>
			</tr> 
			</thead>
			<!-- <tr>
			   <td align="center"><input type="checkbox"></td>
               <td align="center">번호</td>
               <td><a>제목 </a></td>
               <td align="center">작성일</td>
			</tr> -->
			
			<tr class="no_data">
				<td colspan="19" class="no_article">공지 글이 없습니다.</td>
			</tr>
	</table>
</div>

	<div id="pagingAreaPg" class="page_admin"></div>
	<div id="pagingArea" class="page_admin"></div>
</div>
</form>
</div>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerNoticeList.js"></script>
</html>