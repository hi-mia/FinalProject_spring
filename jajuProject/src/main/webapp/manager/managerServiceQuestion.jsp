<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/manager/managerHeader.jsp"/>
<link rel="stylesheet" href="/jaju/manager_css/managerServiceQuestion.css" />
</head>
<body>
<form id = "managerQuestionDelete" method="get" action="managerQuestionDelete">
<input type = "hidden" id = "pg" name = "pg" value="${pg }">
<input type = "hidden" id = "question_seq" name = "question_seq" value = "">
<div class="total" style="display:flex; justify-content: center;">
<jsp:include page="/manager/managerMenu.jsp"/>
<div id="content" class="cont_post post_spam">
	<div class="wrap_tit">
		<h3 class="cont_tit">
			<span class="tit_menu">자주 묻는 질문 관리</span>
		</h3>
		
		<div class="box_search">
			<div class="select_admin" style="font-size: 14px;">
			<select id="itemcd" name="itemcd">
				<option value="question_subject">&nbsp;&nbsp;&nbsp;&nbsp;제목&nbsp;&nbsp;&nbsp;&nbsp;</option>
				<option value="questionType">&nbsp;&nbsp;&nbsp;&nbsp;카테고리&nbsp;&nbsp;&nbsp;&nbsp;</option>
			</select>
			</div>
			
			<div class="search_input">
				<input id="text" id = "keyword" name="keyword" value="${keyword}" maxlength="20" size="25" class="tf_search textbox_default" title="검색어">
				<button type="button" id = "managerServiceQuestionBtn" class="btn_admin btn_search button-search">
					<span class="ico_admin">검색</span>
				</button>
			</div>
		</div>                
	</div>
	<div class="option_list article_option_list">
		
	</div>

	<div class="set_list" id="listControlBar" style="width: 840px; height: 59px; padding : 0; background: #FAFAFA; border-top: 1px solid #e4e4e4; border-bottom: 1px solid #e4e4e4;">
		<div class="bundle_set">
		
		</div>
				<div class="bundle_set"
					style="align: right; margin-top: 14px; margin-right: 14px;">
					<a href="/jaju/manager/managerQuestionWriteForm">
						<button type="button" class="btn_admin btn_type7_1"
							id="questionWriteBtn">
							<span class="ico_admin write"></span> <span
								class="txt_btn writeBtn">글쓰기</span>
						</button>
					</a>
					<button type="button" id="noticeDeleteBtn"
						class="btn_admin btn_type2 button-delete-article">
						<span class="ico_admin ico_del"></span> 
						<span class="txt_btn" id = "choiceDeleteBtn">삭제</span>
					</button>
				</div>
			</div>

	<div id="admin_listview">
		<table class="tbl_admin">

		
			<thead>
			<tr>
				<th class="" style="width:40px;">
					<input type="checkbox" id="all" onclick="checkAll()">
				</th>
               <th class="question_seq" style="width:80px;">번호</th>
               <th class="questionType" style="width:150px;">카테고리</th>
               <th class="question_subject" style="width:564px;">제목</th>
			</tr> 
			</thead>
	</table>
	<div class="no_data" style="padding: 150px 0 148px; border-top: 1px solid #e6e6e6; border-bottom: 1px solid #e6e6e6; font-size: 14px; color: #4c4c4c; text-align: center;">
		자주묻는 질문 글이 등록되지 않았습니다.
	</div>
</div>
<table class="inquireTable" id="inquireTable" style="width:100%; border-top: 50px solid #FAFAFA;; border-bottom: 1px solid #e6e6e6;"></table>
<div id="pagingArea" class="page_admin">
<!-- <span class="paging currentPaging" onclick="inquirePaging">1</span> -->
</div>
	</div>
</div>
</form>
</body>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerServiceQuestion.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerServiceQuestion').addClass('on');
});
</script>

</html>