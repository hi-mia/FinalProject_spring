<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/manager/managerHeader.jsp"/>
<link rel="stylesheet" href="/jaju/css/serviceMenu.css" /> 
<link rel="stylesheet" href="/jaju/css/inquireWriteForm.css" />    

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width: 1050px; margin: auto;" >
<jsp:include page="/manager/managerMenu.jsp"/>

<div class="page_section section_qna">
<div class="head_aticle">
<h2 class="tit" style="color: #333; margin-top:50px;">자주 하는 질문 글쓰기 수정</h2>
</div>

<div class="xans-board-write">
<form name="managerQuestionModifyForm" id="managerQuestionModifyForm" method="post"  enctype="multipart/form-data" style="height: 100%;">
<input type="hidden" name="question_seq" id = "seq" value= "${seq}">
<input type="hidden" name="pg" value="${pg}">
<table id="table_after" class="boardWrite2" width="100%">
<colgroup><col width="14%" align="right"></colgroup>
<tbody>
<tr>
	<th class="input_txt">제목</th>
	<td>
		<select name="questionType" id = "questionType" label="문의 유형">
			<option value="">&nbsp;&nbsp;선택해주세요.&nbsp;&nbsp;</option>
			<option value="계정/인증">&nbsp;&nbsp;계정/인증&nbsp;&nbsp;</option>
			<option value="구매/판매">&nbsp;&nbsp;구매/판매&nbsp;&nbsp;</option>
			<option value="서비스 이용 및 기타">&nbsp;&nbsp;서비스 이용 및 기타&nbsp;&nbsp;</option>
		</select>
		<br>
		<input type="text" name="question_subject" id = "question_subject" style="width:100%" label="제목">
		<div id = "questionTypeDiv"></div>
		<div id = "question_subjectDiv" ></div>
	</td>
</tr>
<tr>
<th class="input_txt">내용</th>
<td class="edit_area" style="position: relative;">



<textarea name="question_content" id = "question_content" style="width:100%; height:474px; resize: none;" class="editing_area" label="내용"></textarea>
<div id = "question_contentDiv"></div>
</td>
</tr>
<tr>
<th class="input_txt">이미지</th>
<td>
<table width="95%" class = "questionModifyTable" id="questionModifyTable" cellpadding="0" cellspacing="0" border="0" style="border:solid 1px #f4f4f4; border-collapse:collapse;">
	<tr id="tr_0">
		<td width="20" align="left">1.
		<input type = "hidden" id = "question_image1" name="question_image1"></input></td>
			<td><span class="image1Name" id="image1Name"></span></td>
			<td width="100%">
				<input type="file" name="img1" style="width:50%" class="linebg" multiple size="50">
				<span class="image1Name">
					<input type="checkbox" value="삭제" name="checkbox1">삭제
				</span>
			 </td>
		</tr>
		
		<tr id="tr_0">
		<td width="20" align="left">2.
		<input type = "hidden" id = "question_image2" name="question_image2"></input></td>
			<td><span class="image2Name" id="image2Name"></span></td>
			<td width="100%">
				<input type="file" name="img2" style="width:50%" class="linebg" multiple size="50">
				<span class="image2Name">
					<input type="checkbox" value="삭제" name="checkbox2">삭제
				</span>
			 </td>
		</tr>
		
		<tr id="tr_0">
		<td width="20" align="left">3.
		<input type = "hidden" name = "question_image3" id = "question_image3"></input></td>
			<td><span class="image3Name" id="image3Name"></span></td>
			<td width="100%">
				<input type="file" name="img3" style="width:50%" class="linebg" multiple size="50">
				<span class="image3Name">
					<input type="checkbox" value="삭제" name="checkbox3">삭제
				</span>
			 </td>
		</tr>
		
</table>
<table>
	<tbody>
		<tr>
			<td height="2"></td>
		</tr>
	</tbody>
</table>
	<div width="100%" style="padding:5px;" class="stxt">
	- 파일은 최대 3개까지 업로드가 지원됩니다.<br>
	</div>
	</td>
		</tr>
	</tbody>
</table>

<table width="100%">
	<tbody>
		<tr>
			<td align="right" style="padding-top:5px; border:none;" id="avoidDbl">
				<input type="button"class = "bhs_button yb" id = "questionModifyBtn" value="저장" style="float:none;">
			</td>
		</tr>
	</tbody>
</table>
</form>
</div>

</div>
</div>
</body>
<script type = "text/javascript" src = "http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/jaju/manager_js/managerQuestionModifyForm.js"></script>

<script type="text/javascript">
$(document).ready(function(){
	
	$('#managerServiceQuestion').addClass('on');
});
</script>

</html>